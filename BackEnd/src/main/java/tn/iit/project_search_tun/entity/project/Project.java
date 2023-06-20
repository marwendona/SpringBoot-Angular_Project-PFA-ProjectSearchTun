package tn.iit.project_search_tun.entity.project;

import tn.iit.project_search_tun.entity.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Builder
@Jacksonized
public class Project {
    private int projectId;

    private User user;

    @NotBlank(message = "Le champ title ne peut pas être nul")
    private String title;

    @NotBlank(message = "Le champ type ne peut pas être nul")
    private String type;

    @NotBlank(message = "Le champ description ne peut pas être nul")
    private String description;

    @CollectionTable(name = "requiredSkills", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "requiredSkill")
    private List<String> requiredSkills;

    @NotBlank(message = "Le champ date ne peut pas être nul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @NotBlank(message = "Le champ nombre des members ne peut pas être nul")
    private int numberOfMembers;

    private ProjectStatus projectStatus;

    public Project() {
    }

    public Project(int projectId, User user, String title, String type, String description, List<String> requiredSkills, LocalDate createdDate, int numberOfMembers, ProjectStatus projectStatus) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
}
