package service;

import java.util.List;

import entity.Employee;
import repository.EmployeeRepository;

public class EmployeeService {

	public static List<Employee> getEmployeesByRole(String role) {
		return EmployeeRepository.getEmployeesByRole(role);
	}

	public static List<Employee> getAllEmployees() {
		return EmployeeRepository.getAllEmployees();
	}

	public static Employee getEmployeeById(Long employeeId) {
		return EmployeeRepository.getEmployeeById(employeeId);
	}

	public static Employee addEmployee(Employee employee) {
		return EmployeeRepository.addEmployee(employee);
	}

	public static Employee updateEmployee(Long employeeId, Employee employee) {
		return EmployeeRepository.updateEmployee(employeeId, employee);
	}

	public static Employee deleteEmployee(Long employeeId) {
		return EmployeeRepository.deleteEmployee(employeeId);
	}

}
