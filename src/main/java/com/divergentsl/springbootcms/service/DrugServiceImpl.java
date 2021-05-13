package com.divergentsl.springbootcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.springbootcms.dao.DrugDao;
import com.divergentsl.springbootcms.entity.Drug;
import com.divergentsl.springbootcms.entity.Labtest;

@Service
public class DrugServiceImpl implements DrugService {

	@Autowired
	DrugDao drugDao;
		
	@Override
	@Transactional
	public Drug insertDrug(Drug drug) {
		return (Drug)drugDao.insert(drug);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Drug findDrug(int id) {		
		return (Drug)drugDao.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Drug> findAllDrug() {
		return drugDao.findAll();
	}

	@Override
	@Transactional
	public void removeDrug(int id) {
		drugDao.remove(id);
		
	}


	@Override
	@Transactional
	public void updateDrug(Drug drug) {
		// TODO Auto-generated method stub
		drugDao.update(drug);
	}

}