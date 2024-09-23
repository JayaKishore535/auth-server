package com.fintech.authservice.controller;

import com.fintech.authservice.AuthServiceApp;
import com.fintech.authservice.dto.*;
import com.fintech.authservice.service.AuthService;
import com.fintech.authservice.util.APIResponse;
import com.fintech.authservice.util.JwtUtil;
import com.fintech.authservice.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) {

		TokenDto tokenDto  = authService.generateToken(loginDto);
		//String token = jwtUtil.generateToken(userName);

		return new ResponseEntity<Object>(ResponseBuilder.getSuccessResponse(tokenDto), HttpStatus.OK);
	}

	@PostMapping("/register")
	public APIResponse register(@RequestBody RegistrationDto registrationDto) {
		APIResponse res = authService.registerUser(registrationDto);
		return res;
	}

	@PostMapping("/addContactUs")
	public APIResponse addContactUs(@RequestBody ContactUsDto contactUsDto) {
		return authService.addContactUs(contactUsDto);
	}

}
