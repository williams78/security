package com.example.demo.service;

import com.example.demo.dao.request.SignUpRequest;
import com.example.demo.dao.request.SigninRequest;
import com.example.demo.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {

	JwtAuthenticationResponse signup(SignUpRequest request);
	JwtAuthenticationResponse signin(SigninRequest request);
	
}
