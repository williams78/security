package com.example.demo.service;

import java.util.List;

public interface IGeneric<D,E> {

	List<D> getAll();
	D findBy(E e);
	List<D> getNameContaning(E e);
	String save(D d);
	String update(D d);
	List<D> findByList(E e);
}
