package com.divergentsl.springbootcms.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.springbootcms.entity.Drug;
import com.divergentsl.springbootcms.entity.Labtest;
import com.divergentsl.springbootcms.service.DrugService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "cms/drug", produces = "application/json")
@CrossOrigin(origins = "*")
public class DrugRestController {

	@Autowired
	DrugService drugService;

	@GetMapping("/")
	private ResponseEntity<List<Drug>> getAll() {
		// log.debug("get all LabTest");
		List<Drug> allDrugs = drugService.findAllDrug();
		return new ResponseEntity<>(allDrugs, HttpStatus.OK);
	}

	@DeleteMapping("/{drugId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int id) {
		drugService.removeDrug(id);
	}

	@GetMapping("/{drugId}")
	private ResponseEntity<Drug> find(@PathVariable int id) {
		Drug drug = drugService.findDrug(id);
		if (drug != null) {
			return new ResponseEntity<Drug>(drug, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/")
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestBody Drug drug) {
		drugService.updateDrug(drug);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Drug drug) {
		drugService.insertDrug(drug);
	}
}