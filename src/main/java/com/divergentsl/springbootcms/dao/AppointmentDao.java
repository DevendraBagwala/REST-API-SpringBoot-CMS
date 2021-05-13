package com.divergentsl.springbootcms.dao;

import java.util.List;

import com.divergentsl.springbootcms.entity.Appointment;

public interface AppointmentDao<T> {

	public T insert(T appointment);

	public T find(int id);

	public List<T> findAll();

	public void remove(int id);

	public void update(Appointment appointment);
	
}