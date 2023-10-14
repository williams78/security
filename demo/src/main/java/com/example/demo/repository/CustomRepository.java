package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.service.IEntityRepository;

public class CustomRepository implements IEntityRepository{

	@Override
	public <T> Page<T> getAllRecords(Class<T> clazz, Pageable pageable, int isActive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> int SaveRecord(T save) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> T FindById(Long id, Class<T> clazz, int isActive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Page<T> getRecordsContaning(Class<T> clazz, Pageable pageable, int isActive, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> int UpdateRecord(T update) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> T FindUserName(String userName, Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

}
