package com.fintech.authservice.dto;

import lombok.Data;

@Data
public class TokenDto {
    private String userId;
    private String mobileNumber;
    private String token;
    //private String refreshToken;
}
