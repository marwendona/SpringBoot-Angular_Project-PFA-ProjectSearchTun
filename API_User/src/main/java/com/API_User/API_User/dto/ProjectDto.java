package com.API_User.API_User.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class ProjectDto {
    private int projectId;
    @NotBlank(message = "Le champ title ne peut pas être nul")
    private String title;
    @NotBlank(message = "Le champ type ne peut pas être nul")
    private String type;
    @NotBlank(message = "Le champ description ne peut pas être nul")
    private String description;
    @CollectionTable(name = "requiredSkills", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "requiredSkill")
    private List<String> requiredSkills;

    public ProjectDto(int projectId, String title, String type, String description, List<String> requiredSkills) {
        this.projectId = projectId;
        this.title = title;
        this.type = type;
        this.description = description;
        this.requiredSkills = requiredSkills;
    }

    public ProjectDto() {
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}
