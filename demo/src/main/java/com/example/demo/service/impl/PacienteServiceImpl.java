package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.demo.dao.request.PacienteRequest;
import com.example.demo.dao.response.PacienteResponse;
import com.example.demo.mapper.PacienteRespMapper;
import com.example.demo.models.Paciente;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.service.IGeneric;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements IGeneric<PacienteResponse,PacienteRequest> {

	private final PacienteRepository pacienteRepository;
    
	
    private final PacienteRespMapper pacienteMapper;
    private static final Logger logger = LoggerFactory.getLogger(PacienteServiceImpl.class);
	
	@Override
	public List<PacienteResponse> getAllPaciente() {
		return pacienteMapper.toDtoList(pacienteRepository.findAll()); 
	} 

	@Override
	public PacienteResponse findByPaciente(PacienteRequest request) {
		Optional<Paciente> p = pacienteRepository.findById(request.getId());
		return pacienteMapper.toDto(p.get()) ;
	}

	@Override
	public PacienteResponse getNameContaning(PacienteRequest e) {
		
		return null;
	} 
	
	

}
