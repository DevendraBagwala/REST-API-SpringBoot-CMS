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

import com.divergentsl.springbootcms.entity.Drug;
import com.divergentsl.springbootcms.service.DrugService;

@Controller

public class DrugController {
	
	
	
	@Autowired
	DrugService drugService;

	
	@RequestMapping(path = "/drugmenu", method = RequestMethod.GET)
	public String DrugMenu() {
		return "DrugMenu";
	}
	
	
	@RequestMapping(path = "/druginsert", method = RequestMethod.GET)
	public String insertDrug() {
		return "DrugInsert";
	}
	
	
	
	@RequestMapping(value = "/druglist", method = RequestMethod.GET)
	public ModelAndView listLabTest() {
		List<Drug> allDrugs = drugService.findAllDrug();
		ModelAndView model = new ModelAndView("DrugList"); 
		model.addObject("allDrugs", allDrugs); 
		return model;
	}
	
	@RequestMapping(path = "/drugsearch", method = RequestMethod.GET)
	public ModelAndView searchById(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView("DrugSearch");
		int id = 0;
		if(request.getParameter("id") != null)
			 id = Integer.parseInt(request.getParameter("id"));
		
		
		Drug drug= this.drugService.findDrug(id);
		
		System.out.println("------------------------------------------------------" + id);
		
		if(drug != null) {
			mv.addObject("drug", drug);
		}
		return mv;
	}
	
	@RequestMapping(path = "/druginsert", method = RequestMethod.POST)
	public String labTestInsert(HttpServletRequest request, HttpServletResponse response) {
		

		int drugId = Integer.parseInt(request.getParameter("id"));
		String drugName = request.getParameter("name");
		String drugQuantity = request.getParameter("quantity");
		

		Drug drug = new Drug(drugId, drugName, drugQuantity);
		drugService.insertDrug(drug);
		
		return "DrugInsert";
	}
	
	
	@RequestMapping(path = "/drugdelete", method = RequestMethod.GET)
	public ModelAndView deleteDrug(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("DrugList");
		
		this.drugService.removeDrug(id);
		
		mv.addObject("allDrugs", drugService.findAllDrug());
		return mv;
	}	

}