package com.divergentsl.springbootcms.service;

import java.util.List;

import com.divergentsl.springbootcms.entity.Labtest;

public interface LabtestService {
	
	public Labtest insertLabtest(Labtest labtest);

	public Labtest findLabtest(int id);

	public List<Labtest> findAllLabtest();

	public void removeLabtest(int id);

	public void updateLabTest(Labtest labtest);

}
