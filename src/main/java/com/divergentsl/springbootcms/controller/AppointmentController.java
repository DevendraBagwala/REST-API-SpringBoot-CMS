package com.divergentsl.springbootcms.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.divergentsl.springbootcms.entity.Appointment;
import com.divergentsl.springbootcms.service.AppointmentService;

@Controller

public class AppointmentController {
	
	
	@Autowired
	AppointmentService appointmentService;
	
	@RequestMapping(path = "/appointmentmenu", method = RequestMethod.GET)
	public String AppointmentMenu() {
		return "AppointmentMenu";
	}
	
	
	@RequestMapping(path = "/appointmentinsert", method = RequestMethod.GET)
	public String insertAppointment() {
		return "AppointmentInsert";
	}
	
	
	
	@RequestMapping(value = "/appointmentlist", method = RequestMethod.GET)
	public ModelAndView listAppointment() {
		List<Appointment> allAppointments = appointmentService.findAllAppointment();
		ModelAndView model = new ModelAndView("AppointmentList"); 
		model.addObject("allAppointments", allAppointments); 
		return model;
	}
	
	@RequestMapping(path = "/appointmentsearch", method = RequestMethod.GET)
	public ModelAndView searchById(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView("AppointmentSearch");
		int id = 0;
		if(request.getParameter("id") != null)
			 id = Integer.parseInt(request.getParameter("id"));
		
		
		 Appointment appointment = this.appointmentService.findAppointment(id);
		
		System.out.println("------------------------------------------------------" + id);
		
		if(appointment != null) {
			mv.addObject("appointment", appointment);
		}
		return mv;
	}
	
	
	@RequestMapping(path = "/appointmentinsert", method = RequestMethod.POST)
	public String AppointmentInsert(HttpServletRequest request, HttpServletResponse response) {
		

		int appointmentId = Integer.parseInt(request.getParameter("id"));
		String appointmentName = request.getParameter("name");
		String appointmentDate = request.getParameter("date");
		Appointment appointment = new Appointment(appointmentId,appointmentName, appointmentDate);
		appointmentService.insertAppointment(appointment);
		
		return "AppointmentInsert";
	}
	
	
	@RequestMapping(path = "/appointmentdelete", method = RequestMethod.GET)
	public ModelAndView deleteAppointment(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("AppointmentList");
		
		this.appointmentService.removeAppointment(id);
		
		mv.addObject("allAppointments", appointmentService.findAllAppointment());
		return mv;
	}	
	
	

}