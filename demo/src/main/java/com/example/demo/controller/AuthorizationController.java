package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.request.PacienteRequest;
import com.example.demo.dao.response.PacienteResponse;
import com.example.demo.service.IGeneric;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/resource")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class AuthorizationController {

	private final IGeneric<PacienteResponse, PacienteRequest> pacienteService;
	private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);
	
	@GetMapping("/list")
	public ResponseEntity<List<PacienteResponse>> list(){
			return ResponseEntity.ok(pacienteService.getAllPaciente());
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<PacienteResponse> findByPaciente(PacienteRequest pacienteRequest){
			return ResponseEntity.ok(pacienteService.findByPaciente(pacienteRequest));
	}
	
	
	
}
