package com.divergentsl.springbootcms.dao;

import java.util.List;

import com.divergentsl.springbootcms.entity.Doctor;


public interface DoctorDao<T> {
	
	public T insert(T doctor);
	
	public T find(int id);
	
	public List<T> findAll();
	
	public void remove(int id);

	public void update(Doctor doctor);
	

}