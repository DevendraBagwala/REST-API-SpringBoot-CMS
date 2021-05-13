package com.divergentsl.springbootcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.springbootcms.dao.PatientDao;
import com.divergentsl.springbootcms.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientDao patientDao;
	
	@Transactional
	@Override
	public void insert(Patient patient) {
		
		//patient.setContactNumber(contactNumber);		
		patientDao.insert(patient);
		
	}

	@Transactional(readOnly = true)
	@Override
	public List<Patient> findAll() {
		
		return patientDao.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Patient find(int patientId) {
		return patientDao.find(patientId);
	}

	/*
	 * public void delete(int patientId) { patientDao.delete(patientId); }
	 */

	@Transactional
	@Override
	public void removePatient(int id) {
		patientDao.remove(id);
	}

	@Override
	public void updateEmployee(Patient patient) {
		// TODO Auto-generated method stub
		patientDao.update(patient);
	}


	

	
}