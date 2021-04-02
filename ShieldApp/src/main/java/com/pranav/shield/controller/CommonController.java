package com.pranav.shield.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

	@GetMapping("/common")
	public String demo() {
		return "It works";
	}
}
