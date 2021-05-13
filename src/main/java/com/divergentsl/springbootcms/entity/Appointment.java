package com.divergentsl.springbootcms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {
	
	@Id
	public int id;
	public String name;
	public String date;

	public Appointment( int id, String name, String date) {
		super();
	    this.id = id;
		this.name = name;
		this.date = date;
	}




	public String getName() {
		return name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Appointment [id=" + id + ",name=" + name + ", date=" + date + "]";
	}
	
	
	

}