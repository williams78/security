package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.request.SignUpRequest;
import com.example.demo.dao.request.SigninRequest;
import com.example.demo.dao.response.JwtAuthenticationResponse;
import com.example.demo.service.AuthenticationService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class AuthenticationController {

private final AuthenticationService authenticationService;

	@PostMapping("/signup")
	public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request){
		return ResponseEntity.ok(authenticationService.signup(request));		
	}
	
	@PostMapping("/signin")
	public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request){
		return ResponseEntity.ok(authenticationService.signin(request));
	}
	
}
