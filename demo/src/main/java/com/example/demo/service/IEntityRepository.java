package com.example.demo.service;

import java.util.List;

import com.example.demo.models.FieldsValues;

public interface IEntityRepository {
	
	<T> List<T> getAllRecords(Class<T> clazz);
	<T> int SaveRecord(T save); 
	<T> T FindByRecord(FieldsValues[] object, Class<T> clazz);
	<T> List<T> FindByRecords(FieldsValues[] object, Class<T> clazz);
	<T> List<T> getRecordsContaning( Class<T> clazz , String name);
	<T> int UpdateRecord(T update, FieldsValues[] object);
	<T> T FindUserName(String userName, Class<?> clazz);
}
