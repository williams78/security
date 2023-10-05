package com.example.demo.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.request.SignUpRequest;
import com.example.demo.dao.request.SigninRequest;
import com.example.demo.dao.response.JwtAuthenticationResponse;
import com.example.demo.models.ERole;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
	
	private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
	
    
	public JwtAuthenticationResponse signup(SignUpRequest request) {
	    var user = User.builder().email(request.getEmail())
	    		.password(passwordEncoder.encode(request.getPassword()))
	    		.role(ERole.ROLE_USER).build();
	    userRepository.save(user);
	    var jwt = jwtService.generateToken(user);
		return JwtAuthenticationResponse.builder().token(jwt).build();
	}

	
	public JwtAuthenticationResponse signin(SigninRequest request) {
		authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		
		var user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new IllegalArgumentException("Invalid User or Password"));
		
		var jwt = jwtService.generateToken(user);
		
		return JwtAuthenticationResponse.builder().token(jwt).build();
	}

}
