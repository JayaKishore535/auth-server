package com.fintech.authservice.dto;


import com.fintech.authservice.constant.UserType;
import lombok.Data;

@Data
public class RegistrationDto {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private UserType category;
    private String password;
    private String confirmedPassword;
}