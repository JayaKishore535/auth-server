package com.fintech.authservice.service.impl;

import com.fintech.authservice.config.APIClient;
import com.fintech.authservice.constant.AppConstant;
import com.fintech.authservice.dto.*;
import com.fintech.authservice.entity.UserRegDetails;
import com.fintech.authservice.exception.ErrorDetails;
import com.fintech.authservice.exception.InvalidInputException;
import com.fintech.authservice.exception.UnauthorizedException;
import com.fintech.authservice.repository.UserRegRepository;
import com.fintech.authservice.service.AuthService;
import com.fintech.authservice.util.APIResponse;
import com.fintech.authservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRegRepository userRegRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private APIClient apiClient;

    @Override
    public TokenDto generateToken(LoginDto loginDto) {
        UserRegDetails userDetails = null;
        TokenDto tokenDto = null;

        if (Objects.nonNull(loginDto.getMobileNumber())) {
            userDetails = userRegRepository.findByUserIdMobileNumber(loginDto.getMobileNumber());
        } else {
            if(Objects.nonNull(loginDto.getUserId()) && Objects.nonNull(loginDto.getPassword())) {
                userDetails = userRegRepository.findByUserIdId(loginDto.getUserId());
                if (Objects.nonNull(userDetails)) {
                    if(userDetails.getActive() != 'Y'){
                        throw new InvalidInputException(new ErrorDetails(AppConstant.USER_NOT_ACTIVE, AppConstant.ERROR_TYPE_CODE_VALIDATION,
                                AppConstant.ERROR_TYPE_VALIDATION, "User is not active in system."));
                    }
                    if (!userDetails.getPassword().equalsIgnoreCase(Base64.getEncoder().encodeToString(loginDto.getPassword().getBytes()))) {
                        throw new InvalidInputException(new ErrorDetails(AppConstant.USER_INVALID_INPUT, AppConstant.ERROR_TYPE_CODE_VALIDATION,
                                AppConstant.ERROR_TYPE_VALIDATION, "Incorrect Password for UserId: " + loginDto.getUserId()));
                    }
                }

            }else{
                throw new InvalidInputException(new ErrorDetails(AppConstant.USER_INVALID_INPUT, AppConstant.ERROR_TYPE_CODE_VALIDATION,
                        AppConstant.ERROR_TYPE_VALIDATION, "Please enter userId and Password."));
            }
        }

        if (Objects.nonNull((userDetails))) {
            tokenDto = new TokenDto();
            tokenDto.setUserId(userDetails.getUserId().getId());
            tokenDto.setMobileNumber(userDetails.getUserId().getMobileNumber());
            tokenDto.setToken(jwtUtil.generateToken(userDetails.getUserId().getId()));
            return tokenDto;
        } else {
            throw new UnauthorizedException(new ErrorDetails(AppConstant.USER_NOT_FOUND, AppConstant.ERROR_TYPE_CODE_VALIDATION,
                    AppConstant.ERROR_TYPE_VALIDATION, "User not found."));
        }
    }

    @Override
    public APIResponse registerUser(RegistrationDto registrationDto) {

        APIResponse apiResponse = apiClient.registerUser(registrationDto);
        LinkedHashMap responseData = (LinkedHashMap) apiResponse.getResponseData();

        if(Objects.nonNull(responseData)){
            responseData.put("token", jwtUtil.generateToken((String) responseData.get("userId")));
        }
        return apiResponse;
    }

    @Override
    public APIResponse addContactUs(ContactUsDto contactUsDto) {

       return apiClient.addContactUs(contactUsDto);
    }
}
