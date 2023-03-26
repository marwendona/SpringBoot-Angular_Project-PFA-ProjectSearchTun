package com.API_User.API_User.response;

public class LoginResponse {
    String loginMessage;
    Boolean loginStatus;
    public LoginResponse(String loginMessage, Boolean loginStatus) {
        this.loginMessage = loginMessage;
        this.loginStatus = loginStatus;
    }
    public LoginResponse() {
    }
    public String getLoginMessage() {
        return loginMessage;
    }
    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }
    public Boolean getLoginStatus() {
        return loginStatus;
    }
    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
    @Override
    public String toString() {
        return "LoginResponse{" +
                "loginMessage='" + loginMessage + '\'' +
                ", loginStatus=" + loginStatus +
                '}';
    }
}