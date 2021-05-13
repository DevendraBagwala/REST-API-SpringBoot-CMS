package com.divergentsl.springbootcms.service;

import java.util.List;

import com.divergentsl.springbootcms.entity.Doctor;

public interface DoctorService {
	
	public Doctor insertDoctor(Doctor doctor);

	public Doctor findDoctor(int id);

	public List<Doctor> findAllDoctor();

	public void removeDoctor(int id);

	public void updateDoctor(Doctor doctor);

}