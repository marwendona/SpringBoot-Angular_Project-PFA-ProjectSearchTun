package com.API_User.API_User.adapter;

import com.API_User.API_User.dto.ProjectDto;
import com.API_User.API_User.entity.project.Project;
import com.API_User.API_User.entity.user.User;

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
