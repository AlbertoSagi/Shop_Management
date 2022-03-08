package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Employee;
import service.EmployeeService;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

	@GetMapping("/employees/{role}")
	public ResponseEntity<?> getEmployeesByRole(@PathVariable String role) {
		return new ResponseEntity<>(EmployeeService.getEmployeesByRole(role), HttpStatus.OK);
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<>(EmployeeService.getAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Long employeeId) {
		if (employeeId < 0) {
			return new ResponseEntity<>("empoyeeId must be a positive number", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(EmployeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(EmployeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@PutMapping("/updateEmployee/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
		return new ResponseEntity<>(EmployeeService.updateEmployee(employeeId, employee), HttpStatus.OK);
	}

	@DeleteMapping("/deleteEmployee/{employeeId}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long employeeId) {
		return new ResponseEntity<>(EmployeeService.deleteEmployee(employeeId), HttpStatus.OK);
	}

}
