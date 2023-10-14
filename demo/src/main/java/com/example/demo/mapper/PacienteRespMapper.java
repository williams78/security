package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dao.response.PacienteResponse;
import com.example.demo.mapper.impl.GenericMapper;
import com.example.demo.models.Paciente;

@Mapper(componentModel = "spring")
public interface PacienteRespMapper extends GenericMapper<PacienteResponse, Paciente>{

	@Override
	Paciente entity(PacienteResponse response) ;

	@Override
	PacienteResponse toDto(Paciente request) ;

	@Override
	List<Paciente> entityList(List<PacienteResponse> response) ;

	@Override
	List<PacienteResponse> toDtoList(List<Paciente> request);
	
	
}
