package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class InitialController {

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/{name}")
	@ResponseBody
	public String helloName(@PathVariable String name) {
		return "Hello, " + name;
	}

}
