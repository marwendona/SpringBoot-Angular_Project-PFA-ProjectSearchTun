package com.API_User.API_User.dto;
public class UserDto {
    private int userDtoId;
    private String userDtoName;
    private String userDtoEmail;
    private String userDtoPassword;
    public UserDto(int userDtoId, String userDtoName, String userDtoEmail, String userDtoPassword) {
        this.userDtoId = userDtoId;
        this.userDtoName = userDtoName;
        this.userDtoEmail = userDtoEmail;
        this.userDtoPassword = userDtoPassword;
    }
    public UserDto() {
    }
    public int getUserDtoId() {
        return userDtoId;
    }
    public void setUserDtoId(int userDtoId) {
        this.userDtoId = userDtoId;
    }
    public String getUserDtoName() {
        return userDtoName;
    }
    public void setUserDtoName(String userDtoName) {
        this.userDtoName = userDtoName;
    }
    public String getUserDtoEmail() {
        return userDtoEmail;
    }
    public void setUserDtoEmail(String userDtoEmail) {
        this.userDtoEmail = userDtoEmail;
    }
    public String getUserDtoPassword() {
        return userDtoPassword;
    }
    public void setUserDtoPassword(String userDtoPassword) {
        this.userDtoPassword = userDtoPassword;
    }
}