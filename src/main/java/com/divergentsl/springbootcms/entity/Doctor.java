package com.divergentsl.springbootcms.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {
	
	@Id
	public int id;
	public String name;
	public String fees;
	
	
	public Doctor(int id, String name, String fees) {
		super();
		this.id = id;
		this.name = name;
		this.fees = fees;
	}
	
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", fees=" + fees + "]";
	}
	
	

}