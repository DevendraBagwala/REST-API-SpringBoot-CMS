package com.divergentsl.springbootcms.dao;


import java.util.List;

import com.divergentsl.springbootcms.entity.Labtest;

public interface LabtestDao<T> {
	
	public T insert(T labtest );
	
	public T find(int id);

	public List<T> findAll();

	public void remove(int id);

	public void update(Labtest labtest);

}