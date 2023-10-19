package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dao.response.FichaResponse;
import com.example.demo.mapper.impl.GenericMapper;
import com.example.demo.models.Ficha;

@Mapper(componentModel = "spring")
public interface FichaResMapper extends GenericMapper<FichaResponse, Ficha>{

    Ficha entity(FichaResponse dto);
	
	FichaResponse toDto(Ficha entity);
	
	List<Ficha> entityList(List<FichaResponse> dto);
	
	List<FichaResponse> toDtoList(List<Ficha> entity);
	
}
