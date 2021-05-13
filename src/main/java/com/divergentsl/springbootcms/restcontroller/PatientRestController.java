package com.divergentsl.springbootcms.restcontroller;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

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

import com.divergentsl.springbootcms.entity.Patient;
import com.divergentsl.springbootcms.service.PatientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "cms/patient", produces = "application/json")
@CrossOrigin(origins = "*")

public class PatientRestController {

	@Autowired
	private PatientService patientService;

	@GetMapping("/")
	private ResponseEntity<List<Patient>> getAll() {
		// log.debug("get all patient");
		List<Patient> allPatient = patientService.findAll();

		return new ResponseEntity<>(allPatient, HttpStatus.OK);
	}

	@DeleteMapping("/{patientId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int id) {
		patientService.removePatient(id);
	}

	@GetMapping("/{patientId}")
	private ResponseEntity<Patient> find(@PathVariable int patientId) {
		Patient patient = patientService.find(patientId);

		if (patient != null) {
			return new ResponseEntity<>(patient, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	
	  @PutMapping("/")
	  @ResponseStatus(HttpStatus.OK) private void update(@RequestBody Patient
	  patient) { patientService.updateEmployee(patient); }
	 

	
	  @PostMapping("/")
	  @ResponseStatus(HttpStatus.CREATED) private void insert(@RequestBody Patient
	  patient) { patientService.insert(patient); }
	 

}
