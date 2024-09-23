package com.fintech.authservice.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String userId;
    private String mobileNumber;
    private String password;
}