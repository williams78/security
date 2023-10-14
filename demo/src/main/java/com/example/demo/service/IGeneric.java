package com.example.demo.service;

import java.util.List;

public interface IGeneric<D,E> {

	List<D> getAllPaciente();
	D findByPaciente(E e);
	D getNameContaning(E e);
	
	
}
