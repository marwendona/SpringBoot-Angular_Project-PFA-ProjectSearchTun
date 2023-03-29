package com.API_User.API_User.entity;

import jakarta.persistence.*;
import org.intellij.lang.annotations.Pattern;

import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="user_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name="user_firstName", length = 255)
    private String userFirstName;
    @Column(name="user_lastName", length = 255)
    private String userLastName;
    @Column(name="email", length = 255)
    private String email;
    @Column(name="password", length = 255)
    private String password;
    @Column(name="institute", length = 255)
    private String institute;
    @Column(name="profession", length = 255)
    private String profession;
    @ElementCollection
    @CollectionTable(name = "skills", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "skill")
    private List<String> skills;
    @Column(name = "photo", length = 255)
    private String photo;
    @Column(name="cv", length = 255)
    private String cv;
    @Column(name="linkedin", length = 255)
    private String linkedin;
    @Column(name="github", length = 255)
    private String github;

    public User(int userId, String userFirstName, String userLastName, String email, String password, String institute, String profession, List<String> skills, String photo, String cv, String linkedin, String github) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.email = email;
        this.password = password;
        this.institute = institute;
        this.profession = profession;
        this.skills = skills;
        this.photo = photo;
        this.cv = cv;
        this.linkedin = linkedin;
        this.github = github;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", institute='" + institute + '\'' +
                ", profession='" + profession + '\'' +
                ", skils=" + skills +
                ", photo='" + photo + '\'' +
                ", cv='" + cv + '\'' +
                ", linkedin='" + linkedin + '\'' +
                ", github='" + github + '\'' +
                '}';
    }
}
