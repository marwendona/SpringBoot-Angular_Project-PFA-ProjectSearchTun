package tn.iit.project_search_tun.service.implement;

import tn.iit.project_search_tun.entity.project_request.ProjectRequestStatus;
import tn.iit.project_search_tun.exception.ResourceNotFoundException;
import tn.iit.project_search_tun.repository.ProjectRequestRepository;
import tn.iit.project_search_tun.service.ProjectRequestService;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@Transactional
public class ProjectRequestServiceImpl implements ProjectRequestService {
    private final ProjectRequestRepository projectRequestRepository;
    private final JavaMailSender javaMailSender;

    @Autowired
    public ProjectRequestServiceImpl(ProjectRequestRepository projectRequestRepository, JavaMailSender javaMailSender) {
        this.projectRequestRepository = projectRequestRepository;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public ProjectRequestStatus acceptOrRejectProjectRequest(int projectRequestId, ProjectRequestStatus status) {
        var projectRequestDto = projectRequestRepository.findById(projectRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Project Request not found"));
        projectRequestDto.setStatus(status);

        projectRequestRepository.save(projectRequestDto);

        sendEmailToUser(projectRequestDto.getUser().getEmail(), status, projectRequestDto.getProject().getTitle());

        return projectRequestDto.getStatus();
    }

    private void sendEmailToUser(String userEmail, ProjectRequestStatus status, String projectTitle) {
        try {
            var mimeMessage = javaMailSender.createMimeMessage();
            var messageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            messageHelper.setSubject(getEmailSubject(status, projectTitle));
            messageHelper.setFrom("bidbattle666@gmail.com");
            messageHelper.setTo(userEmail);
            messageHelper.setText(getEmailContent(status, projectTitle), true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    private String getEmailSubject(ProjectRequestStatus status, String projectTitle) {
        if (status == ProjectRequestStatus.ACCEPTED) {
            return "Your project request entitled \"" + projectTitle + "\" has been accepted";
        } else if (status == ProjectRequestStatus.REJECTED) {
            return "Your project request entitled \"" + projectTitle + "\" has been rejected";
        }
        return "";
    }

    private String getEmailContent(ProjectRequestStatus status, String projectTitle) {
        if (status == ProjectRequestStatus.ACCEPTED) {
            return "Congratulations! Your project request entitled \"" + projectTitle + "\" has been accepted.";
        } else if (status == ProjectRequestStatus.REJECTED) {
            return "We are sorry to inform you that your project request entitled \"" + projectTitle + "\" has been rejected.";
        }
        return "";
    }
}
