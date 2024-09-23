package com.fintech.authservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USERREG")
public class UserRegDetails {

    @EmbeddedId
    private UserId userId;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Column(name = "LASTNAME", nullable = false)
    private String lastName;

    @Column(name = "USERTYPE")
    private String userType;

    @Column(name = "EMAILID")
    private String emailId;

    @Column(name = "PASSWD")
    private String password;

    @Column(name = "ACTIVE", nullable = false)
    private Character active;

    @Column(name = "ADMINFLAG", nullable = false)
    private Character adminFlag;

    @Column(name = "USERMOD")
    private String userMode;

    @Column(name = "CREATEDBY")
    private String createdBy;

    @Column(name = "CREATEDDATE")
    private Date createdDate;


    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserMode() {
        return userMode;
    }

    public void setUserMode(String userMode) {
        this.userMode = userMode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Character getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(Character adminFlag) {
        this.adminFlag = adminFlag;
    }
}
