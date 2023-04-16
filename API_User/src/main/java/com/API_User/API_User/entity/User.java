package com.API_User.API_User.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.apache.tika.Tika;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    private static final Tika TIKA = new Tika();
    @Id
    @Column(name="user_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Enumerated(EnumType.STRING)
    @Column(name="role", length = 10)
    private Role role;
    @Column(name="user_firstName", length = 255)
    @NotBlank(message = "Le champ first name ne peut pas être nul")
    private String userFirstName;
    @Column(name="user_lastName", length = 255)
    @NotBlank(message = "Le champ last name ne peut pas être nul")
    private String userLastName;
    @Column(name="email", length = 255)
    @NotBlank(message = "Le champ email ne peut pas être nul")
    @Email(message = "L'email doit être valide")
    private String email;
    @Column(name="password", length = 255)
    @NotBlank(message = "Le champ password ne peut pas être nul")
    @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
    @Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]+$", message = "Le mot de passe doit contenir des lettres majuscules, minuscules, chiffres et caractères spéciaux")
    private String password;
    @Column(name="institute", length = 255)
    @NotBlank(message = "Le champ institue ne peut pas être nul")
    private String institute;
    @Column(name="profession", length = 255)
    @NotBlank(message = "Le champ profession ne peut pas être nul")
    private String profession;
    @ElementCollection
    @CollectionTable(name = "skills", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "skill")
    private List<String> skills;
    @Column(name="photo", length = 255)
    @NotBlank(message = "Le champ photo ne peut pas être nul")
    @Pattern(regexp = "^.*\\.(jpg|jpeg|png)$", message = "Le champ photo doit être une image (JPEG, JPG ou PNG)")
    private String photo;
    @Column(name="cv", length = 255)
    @NotBlank(message = "Le champ cv ne peut pas être nul")
    @Pattern(regexp = "^.*\\.pdf$", message = "Le champ cv doit être un fichier PDF")
    private String cv;
    @Column(name="linkedin", length = 255)
    @Pattern(regexp = "^https?://[a-zA-Z0-9\\-.]+\\.[a-zA-Z]{2,}(?:/[a-zA-Z0-9\\-._~,!%\\?&=]*)?$", message = "Le champ linkedin doit être un lien web valide")
    private String linkedin;
    @Column(name="github", length = 255)
    @Pattern(regexp = "^https?://[a-zA-Z0-9\\-.]+\\.[a-zA-Z]{2,}(?:/[a-zA-Z0-9\\-._~,!%\\?&=]*)?$", message = "Le champ github doit être un lien web valide")
    private String github;

    public User(int userId, Role role, String userFirstName, String userLastName, String email, String password, String institute, String profession, List<String> skills, String photo, String cv, String linkedin, String github) {
        this.userId = userId;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public String getCv() {
        return cv;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getGithub() {
        return github;
    }
    public void setCv(String cv) throws IllegalArgumentException {
//        String mimeType = null;
//        mimeType = TIKA.detect(cv.getBytes());
//        if (mimeType == null || !mimeType.equals("application/pdf")) {
//            throw new IllegalArgumentException("CV must be a PDF file");
//        }
        this.cv = cv;
    }

    public void setPhoto(String photo) throws IllegalArgumentException {
//        String mimeType = null;
//        try {
//            mimeType = TIKA.detect(new URL(photo));
//        } catch (IOException e) {
//            // Handle exception
//        }
//        if (mimeType == null || (!mimeType.equals("image/jpeg") && !mimeType.equals("image/png"))) {
//            throw new IllegalArgumentException("Photo must be a JPEG, JPG or PNG file");
//        }
        this.photo = photo;
    }

    public void setLinkedin(String linkedin) {
//        // Vérification de la validité du lien LinkedIn
//        String regex = "^(https?://)?([a-z]{2,3}\\.linkedin\\.com/(mwl|in|pub|profile|edu/|groups/|company/[^/]*))";
//        if (linkedin != null && !linkedin.isEmpty() && linkedin.matches(regex)) {
//            this.linkedin = linkedin;
//        } else {
//            throw new IllegalArgumentException("Le lien LinkedIn n'est pas valide.");
//        }
        this.linkedin = linkedin;
    }

    public void setGithub(String github) {
//        // Vérification de la validité du lien GitHub
//        String regex = "^https://github.com/[a-zA-Z0-9](?:[a-zA-Z0-9]|-(?=[a-zA-Z0-9])){0,38}/?$";
//        if (github != null && !github.isEmpty() && github.matches(regex)) {
//            this.github = github;
//        } else {
//            throw new IllegalArgumentException("Le lien GitHub n'est pas valide.");
//        }
        this.github = github;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", role=" + role +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", institute='" + institute + '\'' +
                ", profession='" + profession + '\'' +
                ", skills=" + skills +
                ", photo='" + photo + '\'' +
                ", cv='" + cv + '\'' +
                ", linkedin='" + linkedin + '\'' +
                ", github='" + github + '\'' +
                '}';
    }
}
