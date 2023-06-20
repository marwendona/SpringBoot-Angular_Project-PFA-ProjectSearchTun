package tn.iit.project_search_tun.service.implement;

import tn.iit.project_search_tun.adapter.ProjectAdapter;
import tn.iit.project_search_tun.dto.LoginDto;
import tn.iit.project_search_tun.dto.ProjectDto;
import tn.iit.project_search_tun.dto.UserDto;
import tn.iit.project_search_tun.entity.project.Project;
import tn.iit.project_search_tun.entity.project.ProjectStatus;
import tn.iit.project_search_tun.entity.project_request.ProjectRequest;
import tn.iit.project_search_tun.entity.user.User;
import tn.iit.project_search_tun.repository.ProjectRepository;
import tn.iit.project_search_tun.repository.ProjectRequestRepository;
import tn.iit.project_search_tun.repository.UserRepository;
import tn.iit.project_search_tun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private ProjectRepository projectRepository;
    private ProjectRequestRepository projectRequestRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ProjectRepository projectRepository, ProjectRequestRepository projectRequestRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.projectRequestRepository = projectRequestRepository;
    }

    public UserServiceImpl() {
    }

    @Override
    public String addUser(User user) {
        UserDto userDto = new UserDto(
                user.getUserId(),
                user.getRole(),
                user.getUserFirstName(),
                user.getUserLastName(),
                user.getEmail(),
                this.passwordEncoder.encode(user.getPassword()),
                user.getInstitute(),
                user.getProfession(),
                user.getSkills(),
                user.getPhoto(),
                user.getCv(),
                user.getLinkedin(),
                user.getGithub(),
                user.getProjects()
        );
        var user1 = userRepository.findByEmail(user.getEmail());
        if (user1.isEmpty()) {
            userRepository.save(userDto);
            return userDto.getUserFirstName();
        } else {
            return "userDto exists";
        }
    }

    @Override
    public Optional<UserDto> getUser(LoginDto loginDto) {
        return userRepository.findByEmail(loginDto.getEmail())
                .filter(user -> {
                    var password = loginDto.getPassword();
                    var encodedPassword = user.getPassword();
                    return passwordEncoder.matches(password, encodedPassword);
                });
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDto getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("UserDto with id " + id + " not found"));
    }

    @Override
    public void updateUser(int id, User user) {
        UserDto userDtoFromDb = getUserById(id);
        System.out.println(userDtoFromDb.toString());

        userDtoFromDb.setUserFirstName(user.getUserFirstName());
        userDtoFromDb.setUserLastName(user.getUserLastName());
        userDtoFromDb.setEmail(user.getEmail());
        userDtoFromDb.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userDtoFromDb.setInstitute(user.getInstitute());
        userDtoFromDb.setProfession(user.getProfession());
        userDtoFromDb.setSkills(user.getSkills());
        userDtoFromDb.setPhoto(user.getPhoto());
        userDtoFromDb.setCv(user.getCv());
        userDtoFromDb.setLinkedin(user.getLinkedin());
        userDtoFromDb.setGithub(user.getGithub());

        userRepository.save(userDtoFromDb);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);

    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public String addProject(Project project, int userId) {
        Optional<UserDto> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new NoSuchElementException("Utilisateur introuvable avec l'ID : " + userId);
        }
        project.setProjectStatus(ProjectStatus.ACTIVE);

        ProjectDto projectDto = new ProjectDto(
                project.getProjectId(),
                userOptional.get(),
                project.getTitle(),
                project.getType(),
                project.getDescription(),
                project.getRequiredSkills(),
                project.getCreatedDate(),
                project.getNumberOfMembers(),
                project.getProjectStatus()
        );

        projectRepository.save(projectDto);

        return projectDto.getTitle();
    }

    @Override
    public List<Project> getProjects(int userId) {
        var userDtoOptional = userRepository.findById(userId);
        if (userDtoOptional.isPresent()) {
            var userDto = userDtoOptional.get();
            return userDto.getProjects()
                    .stream()
                    .map(ProjectAdapter::toProject)
                    .toList();
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<ProjectRequest> getProjectsRequests(int userId) {
        return userRepository.findById(userId)
                .map(UserDto::getProjectRequests)
                .map(projectRequestDtos -> projectRequestDtos
                        .stream()
                        .map(projectRequestDto -> {
                            ProjectRequest projectRequest = new ProjectRequest();
                            projectRequest.setProjectRequestId(projectRequestDto.getProjectRequestId());
                            projectRequest.setUserId(projectRequestDto.getUser().getUserId());
                            projectRequest.setProject(ProjectAdapter.toProject(projectRequestDto.getProject()));
                            projectRequest.setProjectRequestDate(projectRequestDto.getProjectRequestDate());
                            projectRequest.setStatus(projectRequestDto.getStatus());
                            return projectRequest;
                        }).toList())
                .orElseGet(Collections::emptyList);
    }
}
