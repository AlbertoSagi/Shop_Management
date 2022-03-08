package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Employee;
import entity.Employee.RoleEmployee;

public class EmployeeRepository {

	private static Map<Long, Employee> employees = new HashMap<>();
	private static Long index = 4L;

	static {
		Employee employee1 = new Employee(1L, "emp1", RoleEmployee.SALES, 40000L);
		Employee employee2 = new Employee(2L, "emp2", RoleEmployee.ACCOUNTANT, 50000L);
		Employee employee3 = new Employee(3L, "emp3", RoleEmployee.ACCOUNTANT, 50000L);
		Employee employee4 = new Employee(4L, "emp4", RoleEmployee.SALES, 40000L);
		employees.put(1L, employee1);
		employees.put(2L, employee2);
		employees.put(3L, employee3);
		employees.put(4L, employee4);
	}

	public static List<Employee> getEmployeesByRole(String role) {
		List<Employee> listEmployee = new ArrayList<>(employees.values());
		List<Employee> listEmployeeByRole = new ArrayList<Employee>();
		for (Employee e : listEmployee) {
			if (e.getRole().name().equalsIgnoreCase(role)) {
				listEmployeeByRole.add(e);
			}
		}
		return listEmployeeByRole;
	}

	public static List<Employee> getAllEmployees() {
		return new ArrayList<>(employees.values());

	}

	public static Employee getEmployeeById(Long employeeId) {
		return employees.get(employeeId);
	}

	public static Employee addEmployee(Employee employee) {
		index += 1;
		employee.setId(index);

//		Otra opcion era hacer condicionales if()
//		if (employee.getRole() == RoleEmployee.SALES) {
//			employee.setSalary(40000L);
//		} else if (employee.getRole() == RoleEmployee.ACCOUNTANT) {
//			employee.setSalary(50000L);
//		} else if (employee.getRole() == RoleEmployee.DEVELOPER) {
//			employee.setSalary(30000L);
//		} else if (employee.getRole() == RoleEmployee.RRHH) {
//			employee.setSalary(25000L);
//		}

		employees.put(index, employee);
		return employee;
	}

	public static Employee updateEmployee(Long employeeId, Employee employee) {
		employee.setId(employeeId);
		employees.put(employeeId, employee);
		return employee;
	}

	public static Employee deleteEmployee(Long employeeId) {
		return employees.remove(employeeId);
	}

}
