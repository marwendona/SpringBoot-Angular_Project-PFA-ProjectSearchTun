package tn.iit.project_search_tun.adapter;

import tn.iit.project_search_tun.dto.ProjectDto;
import tn.iit.project_search_tun.entity.project.Project;
import tn.iit.project_search_tun.entity.user.User;

public class ProjectAdapter {
    public static Project toProject(ProjectDto projectDto) {
        var userDto = projectDto.getUser();
        var user = User.builder()
                .userFirstName(userDto.getUserFirstName())
                .userLastName(userDto.getUserLastName())
                .email(userDto.getEmail())
                .institute(userDto.getInstitute())
                .profession(userDto.getProfession())
                .skills(userDto.getSkills())
                .photo(userDto.getPhoto())
                .cv(userDto.getCv())
                .linkedin(userDto.getLinkedin())
                .github(userDto.getGithub())
                .build();
        return Project.builder()
                .projectId(projectDto.getProjectId())
                .user(user)
                .title(projectDto.getTitle())
                .type(projectDto.getType())
                .description(projectDto.getDescription())
                .requiredSkills(projectDto.getRequiredSkills())
                .createdDate(projectDto.getCreatedDate())
                .numberOfMembers(projectDto.getNumberOfMembers())
                .projectStatus(projectDto.getProjectStatus())
                .build();
    }
}
