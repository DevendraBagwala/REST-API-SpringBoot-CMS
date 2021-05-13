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

import com.divergentsl.springbootcms.entity.Doctor;
import com.divergentsl.springbootcms.service.DoctorService;

@Controller

public class DoctorController {
	
	
	
	@Autowired
	DoctorService doctorService;
	
	@RequestMapping(path = "/doctoroperatemenu", method = RequestMethod.GET)
	public String DoctorOperateMenu() {
		return "DoctorOperateMenu";
	}
	
	
	@RequestMapping(path = "/doctoroperateinsert", method = RequestMethod.GET)
	public String insertDoctorOperate() {
		return "DoctorOperateInsert";
	}
	
	
	
	@RequestMapping(value = "/doctoroperatelist", method = RequestMethod.GET)
	public ModelAndView listLabTest() {
		List<Doctor> allDoctors = doctorService.findAllDoctor();
		ModelAndView model = new ModelAndView("DoctorOperateList"); 
		model.addObject("allDoctors", allDoctors); 
		return model;
	}
	
	@RequestMapping(path = "/doctoroperatesearch", method = RequestMethod.GET)
	public ModelAndView searchById(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView("DoctorOperateSearch");
		int id = 0;
		if(request.getParameter("id") != null)
			 id = Integer.parseInt(request.getParameter("id"));
		
		
		 Doctor doctor = this.doctorService.findDoctor(id);
		
		System.out.println("------------------------------------------------------" + id);
		
		if(doctor != null) {
			mv.addObject("doctor", doctor);
		}
		return mv;
	}
	
	@RequestMapping(path = "/doctoroperateinsert", method = RequestMethod.POST)
	public String labTestInsert(HttpServletRequest request, HttpServletResponse response) {
		

		int doctorId = Integer.parseInt(request.getParameter("id"));
		String doctorName = request.getParameter("name");
		String doctorFees = request.getParameter("fees");
		

		Doctor doctor = new Doctor(doctorId, doctorName, doctorFees);
		doctorService.insertDoctor(doctor);
		
		return "DrugInsert";
	}
	
	
	@RequestMapping(path = "/doctoroperatedelete", method = RequestMethod.GET)
	public ModelAndView deleteDoctor(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("DoctorOperateList");
		
		this.doctorService.removeDoctor(id);
		
		mv.addObject("allDoctors", doctorService.findAllDoctor());
		return mv;
	}	

}