package com.divergentsl.springbootcms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "labtest")
public class Labtest {
	
	@Id
	public int id;
	public String name;
	public String patientname;
	
	
	public Labtest() {	
		super();
		// TODO Auto-generated constructor stub
	}
	public Labtest(int id, String name, String patientname) {
		super();
		this.id = id;
		this.name = name;
		this.patientname = patientname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	@Override
	public String toString() {
		return "Labtest [id=" + id + ", name=" + name + ", patientname=" + patientname + "]";
	}
	
	
	
	

}