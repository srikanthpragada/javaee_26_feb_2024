package jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class TestEmployee implements CommandLineRunner {
	@Autowired
	EmployeeRepo empRepo;

	public static void main(String[] args) {
		SpringApplication.run(TestEmployee.class, args);
	}

	public void listEmployees() {
		for (var e : empRepo.findAll())
			System.out.printf("%-20s %-20s\n", e.getName(), e.getDepartment().getName());
	}

	public void listAllEmployees() {
		for (var e : empRepo.getAllEmployees())
			System.out.printf("%-20s %-20s\n", e.getName(), e.getDepartment().getName());
	}

	public void listFirstFiveEmployees() {
		Pageable firstPage = PageRequest.of(0, 5);
		Page<Employee> emps = empRepo.findAll(firstPage);
		for (var e : emps)
			System.out.println(e.getName());
	}

	public void listTopFiveEmployees() {
		Pageable firstPage = PageRequest.of(0, 5, Sort.by("salary").descending());
		Page<Employee> emps = empRepo.findAll(firstPage);
		System.out.println(emps.getTotalPages());
		System.out.println(emps.getNumber());
		for (var e : emps)
			System.out.printf("%-20s  %6d\n", e.getName(), e.getSalary());
	}

	public void listEmployeesByDept(String name) {
		for (var e : empRepo.findByDepartmentName(name))
			System.out.printf(e.getName());
	}

	public void listNativeEmployees() {
		for (var e : empRepo.getEmployees())
			System.out.printf("%-20s\n", e.getName());
	}

	public void run(String... args) {
		// listEmployees();
		// listAllEmployees();
		// listFirstFiveEmployees();
		// listTopFiveEmployees();
		// listEmployeesByDept("Sales");
		listNativeEmployees();
	}
}
