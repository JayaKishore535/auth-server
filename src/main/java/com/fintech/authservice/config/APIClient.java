package com.fintech.authservice.config;

import com.fintech.authservice.dto.ContactUsDto;
import com.fintech.authservice.dto.RegistrationDto;
import com.fintech.authservice.util.APIResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(value = "USER-SERVICE", url = "https://fintech-users-service.azurewebsites.net/user-service")
@FeignClient(value = "USER-SERVICE", url = "https://finle-user-service.azurewebsites.net/user-service")
public interface APIClient {
    @PostMapping(value = "/register")
    APIResponse registerUser(@RequestBody RegistrationDto registrationDto);

    @PostMapping(value = "/addContactUs")
    APIResponse addContactUs(@RequestBody ContactUsDto contactUsDto);
}