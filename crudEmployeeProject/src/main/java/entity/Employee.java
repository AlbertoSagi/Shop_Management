package entity;

public class Employee {

	private Long id;
	private String name;
	private RoleEmployee role;
	private Long salary;

	public enum RoleEmployee {
		SALES, DEVELOPER, ACCOUNTANT, RRHH;

	}

	public Employee() {

	}

	public Employee(Long id, String name, RoleEmployee role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public Employee(Long id, String name, RoleEmployee role, Long salary) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoleEmployee getRole() {
		return role;
	}

	public void setRole(RoleEmployee role) {
		this.role = role;
		this.setSalary(getSalaryFromRole(role));
	}

	public Long getSalary() {
		return this.salary;
	}

	private Long getSalaryFromRole(RoleEmployee role) {
		switch (role) {
		case SALES:
			return 40000L;
		case ACCOUNTANT:
			return 50000L;
		case DEVELOPER:
			return 35000L;
		case RRHH:
			return 25000L;
		}
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

}
