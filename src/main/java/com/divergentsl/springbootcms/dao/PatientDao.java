package com.divergentsl.springbootcms.dao;

import java.util.List;

import com.divergentsl.springbootcms.entity.Patient;

public interface PatientDao<T> {

	public void insert(T patient);

	public Patient find(int id);

	public List<T> findAll();

	public void remove(int id);

	public void update(Patient patient);


	
}