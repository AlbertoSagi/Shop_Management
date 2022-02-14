package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class InitialController {

	@GetMapping("/")
	public String helloMaven() {
		return "Hello Maven";
	}

	@GetMapping("/{name}")
	public String helloName(@PathVariable String name) {
		return "Hello, " + name;
	}

}
