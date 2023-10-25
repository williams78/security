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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.request.PacienteRequest;
import com.example.demo.dao.response.FichaResponse;
import com.example.demo.service.IGeneric;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/resource")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class FichaController {

	private final IGeneric<FichaResponse, PacienteRequest> fichaService;
	private static final Logger logger = LoggerFactory.getLogger(FichaController.class);
	
	@GetMapping("/find_")
	public ResponseEntity<List<FichaResponse>> findByPaciente(@RequestParam(name="id", required = false) Long id) {
		
			return ResponseEntity.ok(fichaService.findByList(new PacienteRequest(id,null)));
	}
	
	@PostMapping("/save_")
	public ResponseEntity<String> saveByFicha(@RequestBody FichaResponse fichaResponse){
			return ResponseEntity.ok(fichaService.save(fichaResponse));
	}
	
	@PutMapping("/update_")
	public ResponseEntity<String> updateByFicha(@RequestBody FichaResponse fichaResponse){
		return ResponseEntity.ok(fichaService.update(fichaResponse));
	}
	
}
