package com.divergentsl.springbootcms.service;

import java.util.List;

import com.divergentsl.springbootcms.entity.Drug;
import com.divergentsl.springbootcms.entity.Labtest;

public interface DrugService {

	public Drug insertDrug(Drug drug);

	public Drug findDrug(int id);

	public List<Drug> findAllDrug();

	public void removeDrug(int id);
	
	public void updateDrug(Drug drug);
}
