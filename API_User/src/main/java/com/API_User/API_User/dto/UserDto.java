package com.API_User.API_User.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class UserDto {
    private int userId;
    @NotBlank(message = "Le champ first name ne peut pas être vide")
    private String userFirstName;
    @NotBlank(message = "Le champ last name ne peut pas être vide")
    private String userLastName;
    @Email(message = "Le champ email doit être une adresse email valide")
    private String email;
    @NotBlank(message = "Le champ password ne peut pas être vide")
    private String password;
    @NotBlank(message = "Le champ institue ne peut pas être vide")
    private String institute;
    @NotBlank(message = "Le champ profession ne peut pas être vide")
    private String profession;
    private List<String> skills;
    @NotBlank(message = "Le champ photo ne peut pas être vide")
    @Pattern(regexp = "^.*\\.(jpg|jpeg|png)$", message = "Le champ photo doit être une image (JPEG, JPG ou PNG)")
    private String photo;
    @NotBlank(message = "Le champ cv ne peut pas être vide")
    @Pattern(regexp = "^.*\\.pdf$", message = "Le champ cv doit être un fichier PDF")
    private String cv;
    @Pattern(regexp = "^https?://[a-zA-Z0-9\\-.]+\\.[a-zA-Z]{2,}(?:/[a-zA-Z0-9\\-._~,!%\\?&=]*)?$", message = "Le champ linkedin doit être un lien web valide")
    private String linkedin;
    @Pattern(regexp = "^https?://[a-zA-Z0-9\\-.]+\\.[a-zA-Z]{2,}(?:/[a-zA-Z0-9\\-._~,!%\\?&=]*)?$", message = "Le champ github doit être un lien web valide")
    private String github;

    public UserDto(int userId, String userFirstName, String userLastName, String email, String password, String institute, String profession, List<String> skills, String photo, String cv, String linkedin, String github) {
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

    public UserDto() {
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
}