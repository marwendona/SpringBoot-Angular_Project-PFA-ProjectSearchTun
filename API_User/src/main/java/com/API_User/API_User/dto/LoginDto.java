package com.API_User.API_User.dto;
public class LoginDto {
    private String loginDtoEmail;
    private String loginDtoPassword;
    public LoginDto(String loginDtoEmail, String loginDtoPassword) {
        this.loginDtoEmail = loginDtoEmail;
        this.loginDtoPassword = loginDtoPassword;
    }
    public LoginDto() {
    }
    public String getLoginDtoEmail() {
        return loginDtoEmail;
    }
    public void setLoginDtoEmail(String loginDtoEmail) {
        this.loginDtoEmail = loginDtoEmail;
    }
    public String getLoginDtoPassword() {
        return loginDtoPassword;
    }
    public void setLoginDtoPassword(String loginDtoPassword) {
        this.loginDtoPassword = loginDtoPassword;
    }
    @Override
    public String toString() {
        return "LoginDto{" +
                "loginDtoEmail='" + loginDtoEmail + '\'' +
                ", loginDtoPassword='" + loginDtoPassword + '\'' +
                '}';
    }
}