package com.API_User.API_User.dto;

import com.API_User.API_User.entity.project_request.ProjectRequestStatus;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "project_request")
public class ProjectRequestDto {
    @Id
    @Column(name="projectRequest_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectRequestId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private UserDto user;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    @ToString.Exclude
    private ProjectDto project;

    @CreationTimestamp
    @Column
    private Date projectRequestDate;

    @Column(name = "status")
    private ProjectRequestStatus status;

    public ProjectRequestDto() {
    }

    public ProjectRequestDto(int projectRequestId, UserDto user, ProjectDto project, Date projectRequestDate, ProjectRequestStatus status) {
        this.projectRequestId = projectRequestId;
        this.user = user;
        this.project = project;
        this.projectRequestDate = projectRequestDate;
        this.status = status;
    }

    public int getProjectRequestId() {
        return projectRequestId;
    }

    public void setProjectRequestId(int projectRequestId) {
        this.projectRequestId = projectRequestId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }

    public Date getProjectRequestDate() {
        return projectRequestDate;
    }

    public void setProjectRequestDate(Date projectRequestDate) {
        this.projectRequestDate = projectRequestDate;
    }

    public ProjectRequestStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectRequestStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProjectRequestDto{" +
                "projectRequestId=" + projectRequestId +
                ", user=" + user +
                ", project=" + project +
                ", projectRequestDate=" + projectRequestDate +
                ", status=" + status +
                '}';
    }
}
