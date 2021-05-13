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

import com.divergentsl.springbootcms.entity.Appointment;
import com.divergentsl.springbootcms.service.AppointmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "cms/appointment", produces = "application/json")
@CrossOrigin(origins = "*")
public class AppointmentRestController {


	@Autowired
	AppointmentService appointmentService;

	@GetMapping("/")
	private ResponseEntity<List<Appointment>> getAll() {
		// log.debug("get all LabTest");
		List<Appointment> allAppointments = appointmentService.findAllAppointment();
		return new ResponseEntity<>(allAppointments, HttpStatus.OK);
	}

	@DeleteMapping("/id")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int id) {
		appointmentService.removeAppointment(id);
	}

	@GetMapping("/id")
	private ResponseEntity<Appointment> find(@PathVariable int id) {
		Appointment appointment = appointmentService.findAppointment(id);
		if (appointment != null) {
			return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/")
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestBody Appointment appointment) {
		appointmentService.updateAppointment(appointment);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Appointment appointment) {
		appointmentService.insertAppointment(appointment);
	}
}