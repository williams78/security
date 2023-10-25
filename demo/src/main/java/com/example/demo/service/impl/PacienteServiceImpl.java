package com.example.demo.service.impl;


import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.dao.request.PacienteRequest;
import com.example.demo.dao.response.PacienteResponse;
import com.example.demo.mapper.PacienteRespMapper;
import com.example.demo.models.FieldsValues;
import com.example.demo.models.Paciente;
import com.example.demo.repository.CustomRepository;
import com.example.demo.service.IGeneric;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements IGeneric<PacienteResponse,PacienteRequest> {
	
	private final CustomRepository customRepository;
    private final PacienteRespMapper pacienteMapper;
    //private static final Logger logger = LoggerFactory.getLogger(PacienteServiceImpl.class);
	private final FieldsValues object[] = new FieldsValues[1];
    
	@Override
	public List<PacienteResponse> getAll() {
		return pacienteMapper.toDtoList(customRepository.getAllRecords(Paciente.class)); 
	} 

	@Override
	public PacienteResponse findBy(PacienteRequest request) {
		object[0] = new FieldsValues(request.getId(),"nopaciente");
		return pacienteMapper.toDto(customRepository.FindByRecord(object,Paciente.class)); 
	}

	@Override
	public List<PacienteResponse> getNameContaning(PacienteRequest e) {
		return pacienteMapper.toDtoList(customRepository.getRecordsContaning(Paciente.class,e.getName()));
	}

	@Override
	public String save(PacienteResponse d) {
		return (customRepository.SaveRecord(pacienteMapper.entity(d))==1)?"Se guardo Correctamente":"Error al guardar";
	}

	@Override
	public String update(PacienteResponse d) {
		object[0] = new FieldsValues(d.getNopaciente(),"nopaciente");
		return (customRepository.UpdateRecord(pacienteMapper.entity(d),object)==1)?"Se actualizo Correctamente":"Error al actualizar";
	}

	@Override
	public List<PacienteResponse> findByList(PacienteRequest e) {
		// TODO Auto-generated method stub
		return null;
	} 

}
