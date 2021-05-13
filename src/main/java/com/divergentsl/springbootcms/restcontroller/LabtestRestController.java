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

import com.divergentsl.springbootcms.entity.Labtest;
import com.divergentsl.springbootcms.service.LabtestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "cms/labtest", produces = "application/json")
@CrossOrigin(origins = "*")
public class LabtestRestController {

	@Autowired
	LabtestService labtestService;

	@GetMapping("/")
	private ResponseEntity<List<Labtest>> getAll() {
		// log.debug("get all LabTest");
		List<Labtest> allLabtests = labtestService.findAllLabtest();
		return new ResponseEntity<>(allLabtests, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int id) {
		labtestService.removeLabtest(id);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Labtest> find(@PathVariable int id) {
		Labtest labtest = labtestService.findLabtest(id);
		if (labtest != null) {
			return new ResponseEntity<Labtest>(labtest, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/")
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestBody Labtest labtest) {
		labtestService.updateLabTest(labtest);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Labtest labtest) {
		labtestService.insertLabtest(labtest);
	}
}