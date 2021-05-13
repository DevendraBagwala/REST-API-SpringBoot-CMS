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

import com.divergentsl.springbootcms.entity.Labtest;
import com.divergentsl.springbootcms.service.LabtestService;

@Controller

public class LabtestController {
	
	@Autowired
	LabtestService labtestService;
	
	
	@RequestMapping(path = "/labtestmenu", method = RequestMethod.GET)
	public String LabTestMenu() {
		return "LabTestMenu";
	}
	
	
	@RequestMapping(path = "/labtestinsert", method = RequestMethod.GET)
	public String insertLabTest() {
		return "LabTestInsert";
	}
	
	
	
	@RequestMapping(value = "/labtestlist", method = RequestMethod.GET)
	public ModelAndView listLabTest() {
		List<Labtest> allLabtests= labtestService.findAllLabtest();
		ModelAndView model = new ModelAndView("LabTestList"); 
		model.addObject("allLabtests", allLabtests); 
		return model;
	}
	
	@RequestMapping(path = "/Labtestsearch", method = RequestMethod.GET)
	public ModelAndView searchById(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView("LabTestSearch");
		int id = 0;
		if(request.getParameter("id") != null)
			 id = Integer.parseInt(request.getParameter("id"));
		
		
		Labtest labtest = this.labtestService.findLabtest(id);
		
		System.out.println("------------------------------------------------------" + id);
		
		if(labtest != null) {
			mv.addObject("labtest", labtest);
		}
		return mv;
	}
	
	@RequestMapping(path = "/labtestinsert", method = RequestMethod.POST)
	public String labTestInsert(HttpServletRequest request, HttpServletResponse response) {
		
		int labtestId = Integer.parseInt(request.getParameter("id"));
		String labtestName = request.getParameter("name");
		String labtestPatientname = request.getParameter("patientname");
		
				
		Labtest labtest = new Labtest(labtestId, labtestName, labtestPatientname);
		labtestService.insertLabtest(labtest);
		
		return "LabTestInsert";
	}
	
	
	@RequestMapping(path = "/labtestdelete", method = RequestMethod.GET)
	public ModelAndView deleteLabTest(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("LabTestList");
		
		this.labtestService.removeLabtest(id);
		
		mv.addObject("allLabtests", labtestService.findAllLabtest());
		return mv;
	}

	

}