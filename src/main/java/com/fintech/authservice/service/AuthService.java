package com.fintech.authservice.service;

import com.fintech.authservice.dto.*;
import com.fintech.authservice.util.APIResponse;

public interface AuthService {

    public TokenDto generateToken(LoginDto loginDto);
    public APIResponse registerUser(RegistrationDto registrationDto);
    public APIResponse addContactUs(ContactUsDto contactUsDto);
}
