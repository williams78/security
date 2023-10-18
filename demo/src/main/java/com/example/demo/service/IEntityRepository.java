package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEntityRepository {
	
	<T> List<T> getAllRecords(Class<T> clazz);
	<T> int SaveRecord(T save); 
	<T> T FindById(Long id, Class<T> clazz);
	<T> List<T> getRecordsContaning( Class<T> clazz , String name);
	<T> int UpdateRecord(T update);
	<T> T FindUserName(String userName, Class<?> clazz);
}
