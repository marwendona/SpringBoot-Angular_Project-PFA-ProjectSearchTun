package com.API_User.API_User.dto;

import com.API_User.API_User.entity.project.ProjectStatus;
import com.API_User.API_User.entity.project_request.ProjectRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "project")
public class ProjectDto {
    @Id
    @Column(name="project_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDto user;

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

    @Column(name = "status")
    private ProjectStatus projectStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<ProjectRequestDto> projectRequests = new ArrayList<>();

    public ProjectDto() {
    }

    public ProjectDto(int projectId, UserDto user, String title, String type, String description, List<String> requiredSkills, LocalDate createdDate, int numberOfMembers, ProjectStatus projectStatus) {
        this.projectId = projectId;
        this.user = user;
        this.title = title;
        this.type = type;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.createdDate = createdDate;
        this.numberOfMembers = numberOfMembers;
        this.projectStatus = projectStatus;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
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

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public List<ProjectRequestDto> getProjectRequests() {
        return projectRequests;
    }

    public void setProjectRequests(List<ProjectRequestDto> projectRequests) {
        this.projectRequests = projectRequests;
    }
}