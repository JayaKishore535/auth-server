package com.fintech.authservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDetailDto {
    private Integer id;
    private String userId;
    private String firstName;
    private String lastName;
    private String userType;
    private String emailId;
    private String mobileNumber;
    private String password;
    private boolean isActive;
    private boolean isAdminFlag;
    private String userMode;
    private String createdBy;
    private Date createdDate;
    private TokenDto tokenDto;
}