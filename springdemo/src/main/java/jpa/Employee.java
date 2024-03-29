package jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "employees")
@Entity(name = "jpa.Employee")
public class Employee {
	@Id // primary key
	@Column(name = "employee_id")
	private int id;

	@Column(name = "first_name")
	private String name;

	@Column(name = "salary")
	private int salary;

	@Column(name = "department_id")
	private int deptId;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", updatable = false, insertable = false)
	private Department department;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
