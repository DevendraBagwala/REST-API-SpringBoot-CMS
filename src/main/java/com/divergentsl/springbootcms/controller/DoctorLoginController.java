package com.divergentsl.springbootcms.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class DoctorLoginController {

	@GetMapping("/doctorlogin")
	public String doctorLogin() {
		return "DoctorLogin";
	}
}
