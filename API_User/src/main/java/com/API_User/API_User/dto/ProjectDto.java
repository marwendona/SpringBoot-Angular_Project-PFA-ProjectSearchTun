package com.API_User.API_User.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="project")
public class ProjectDto {
    @Id
    @Column(name="project_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;
    @Column(name="title", length = 255)
    @NotBlank(message = "Le champ title ne peut pas être nul")
    private String title;
    @Column(name="type", length = 255)
    @NotBlank(message = "Le champ type ne peut pas être nul")
    private String type;
    @Column(name="description", length = 255)
    @NotBlank(message = "Le champ description ne peut pas être nul")
    private String description;
    @ElementCollection
    @CollectionTable(name = "requiredSkills", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "requiredSkill")
    private List<String> requiredSkills;
    @Column(name = "createdDate")
    @NotBlank(message = "Le champ date ne peut pas être nul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    @Column(name="numberOfMembers", length = 255)
    @NotBlank(message = "Le champ nombre des members ne peut pas être nul")
    private int numberOfMembers;

    public ProjectDto(int projectId, String title, String type, String description, List<String> requiredSkills, LocalDate createdDate, int numberOfMembers) {
        this.projectId = projectId;
        this.title = title;
        this.type = type;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.createdDate = createdDate;
        this.numberOfMembers = numberOfMembers;
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", requiredSkills=" + requiredSkills +
                ", createdDate=" + createdDate +
                ", numberOfMembers=" + numberOfMembers +
                '}';
    }
}