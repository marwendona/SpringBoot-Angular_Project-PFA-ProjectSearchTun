package com.API_User.API_User.entity.project_request;

import com.API_User.API_User.entity.project.Project;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Builder
@Jacksonized
public class ProjectRequest {
    private int projectRequestId;

    private int userId;

    private Project project;

    private Date projectRequestDate;

    private ProjectRequestStatus status;

    public ProjectRequest() {
    }

    public ProjectRequest(int projectRequestId, int userId, Project project, Date projectRequestDate, ProjectRequestStatus status) {
        this.projectRequestId = projectRequestId;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
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
}
