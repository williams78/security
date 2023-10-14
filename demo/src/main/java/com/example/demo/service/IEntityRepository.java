package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEntityRepository {
	
	<T> Page<T> getAllRecords(Class<T> clazz, Pageable pageable , int isActive);
	<T> int SaveRecord(T save); 
	<T> T FindById(Long id, Class<T> clazz, int isActive);
	<T> Page<T> getRecordsContaning( Class<T> clazz , Pageable pageable , int isActive, String name);
	<T> int UpdateRecord(T update);
	<T> T FindUserName(String userName, Class<?> clazz);
}
