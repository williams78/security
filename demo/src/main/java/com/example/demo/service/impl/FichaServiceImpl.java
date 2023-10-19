package com.example.demo.service.impl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.dao.request.PacienteRequest;
import com.example.demo.dao.response.FichaResponse;
import com.example.demo.mapper.FichaResMapper;
import com.example.demo.mapper.FichaResMapperImpl;
import com.example.demo.models.Ficha;
import com.example.demo.models.FieldsValues;
import com.example.demo.models.Paciente;
import com.example.demo.repository.CustomRepository;
import com.example.demo.service.IGeneric;

import ch.qos.logback.classic.Logger;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FichaServiceImpl implements IGeneric<FichaResponse, PacienteRequest>{

	private final CustomRepository customRepository;
	private final FichaResMapper fichaResMapper;
	private final FieldsValues object[] =  new FieldsValues[3];
	//private static final org.slf4j.Logger logger =LoggerFactory.getLogger(FichaServiceImpl.class);
	
	@Override
	public List<FichaResponse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public FichaResponse findBy(PacienteRequest e) {
     return null;
    }
	@Override
	public List<FichaResponse> getNameContaning(PacienteRequest e) {
		return null;
	}
	@Override
	public String save(FichaResponse d) {
		return (customRepository.SaveRecord(fichaResMapper.entity(d))==1)?"Se guardo Correctamente":"Error al guardar";
	}
	@Override
	public String update(FichaResponse d) {
		object[0] = new FieldsValues(d.getPacienteno(),"pacienteno");
		object[1] = new FieldsValues(d.getNo_ficha_evolucion(),"no_ficha_evolucion");
		object[2] = new FieldsValues(d.getId(),"id");
		return (customRepository.UpdateRecord(fichaResMapper.entity(d),object)==1)?"Se actualizo Correctamente":"Error al actualiza";
		
	}
	@Override
	public List<FichaResponse> findByList(PacienteRequest e) {
		object[0] = new FieldsValues(e.getId(),"pacienteno");
		return fichaResMapper.toDtoList(customRepository.FindByRecords(object, Ficha.class));
		
	}
	
	
	
}
