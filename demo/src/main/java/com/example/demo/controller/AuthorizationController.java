package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/getList")
	public ResponseEntity<List<PacienteResponse>> list(@RequestBody PacienteRequest request){
		   return ResponseEntity.ok(
		    	                   (request.getName()==null)?pacienteService.getAllPaciente():
		    		                            pacienteService.getNameContaning(
		    			                        		 new PacienteRequest(null,request.getName())));
	}
	
	@GetMapping("/find")
	public ResponseEntity<PacienteResponse> findByPaciente(@RequestBody PacienteRequest pacienteRequest){
		if(!pacienteRequest.getId().equals(null)) {
			return ResponseEntity.ok(pacienteService.findByPaciente(pacienteRequest));
		}else {
			return ResponseEntity.ok(new PacienteResponse());
		}
	}
		
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody PacienteResponse pacienteResponse ){
		return ResponseEntity.ok(pacienteService.save(pacienteResponse));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody PacienteResponse pacienteResponse){
		return ResponseEntity.ok(pacienteService.update(pacienteResponse));
	}
	
}
