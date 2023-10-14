package com.example.demo.mapper.impl;

import java.util.List;

import org.springframework.data.domain.Page;

public interface GenericMapper<D,E> {

	/**
	 * 
	 * @param dto
	 * @return
	 */
	E entity(D dto);
	
	/**
	 * 
	 * @param entity
	 * @return D
	 */
	
	D toDto(E entity);
	
	
	/**
	 * 
	 * @param List Dto
	 * @return List entity 
	 */
	
	List<E> entityList(List<D> dto);
	
	/**
	 * 
	 * @param List entity
	 * @return List D
	 */
	
	List<D> toDtoList(List<E> entity);
	
	default Page<D> toDto(Page<E> entityPage) {
		
		return entityPage.map(data -> toDto(data));
		
	}



		
}
