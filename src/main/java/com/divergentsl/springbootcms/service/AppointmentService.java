package com.divergentsl.springbootcms.service;
import java.util.List;

import com.divergentsl.springbootcms.entity.Appointment;

public interface AppointmentService {
	
	public Appointment insertAppointment(Appointment appointment);

	public Appointment findAppointment(int id);

	public List<Appointment> findAllAppointment();

	public void removeAppointment(int id);

	public void updateAppointment(Appointment appointment);
	

}
