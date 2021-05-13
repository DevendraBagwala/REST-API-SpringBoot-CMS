package com.divergentsl.springbootcms.service;

import java.util.List;

import com.divergentsl.springbootcms.entity.Patient;

public interface PatientService {

	public void insert(Patient patient);

	public List<Patient> findAll();

	public Patient find(int patientId);

	public void removePatient(int id);

	public void updateEmployee(Patient patient);

}