package com.divergentsl.springbootcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.springbootcms.dao.LabtestDao;
import com.divergentsl.springbootcms.entity.Labtest;

@Service
public class LabtestServiceImpl implements LabtestService {
	
	@Autowired
	LabtestDao labtestDao;
	

	@Override
	@Transactional
	public Labtest insertLabtest(Labtest labtest) {
		return (Labtest)labtestDao.insert(labtest);
	}

	@Override
	@Transactional(readOnly = true)
	public Labtest findLabtest(int id) {
				return (Labtest)labtestDao.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Labtest> findAllLabtest() {
		return labtestDao.findAll();
	}

	@Override
	@Transactional
	public void removeLabtest(int id) {
		labtestDao.remove(id);
		
	}

	@Override
	@Transactional
	public void updateLabTest(Labtest labtest) {
		// TODO Auto-generated method stub
		labtestDao.update(labtest);
	}

}
