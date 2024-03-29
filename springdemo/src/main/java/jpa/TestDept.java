package jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestDept implements CommandLineRunner {
	@Autowired
	DeptRepo deptRepo;

	public static void main(String[] args) {
		SpringApplication.run(TestDept.class, args);
	}

	public void listDepts() {
		for (var d : deptRepo.findAll()) {
			System.out.printf("%2d %-20s\n", d.getId(), d.getName());
		}
	}

	public void addDept() {
		var d = new Department();
		d.setId(100);
		d.setName("Dept 100");
		deptRepo.save(d);
	}

	public void updateDept(int id, String name) {
		var d = deptRepo.findById(id);
		if (d.isEmpty())
			System.out.println("Sorry! Department Id Not Found");
		else {
			var dept = d.get(); // get department
			dept.setName(name);
			deptRepo.save(dept);
		}
	}

	public void deleteDept(int id) {
		if (deptRepo.existsById(id)) {
			deptRepo.deleteById(id);
		} else
			System.out.println("Sorry! Department Id Not Found!");
	}

	public void getDeptByName(String name) {
		var d = deptRepo.getByName(name);
		System.out.println(d.getId() + " - " + d.getName());
	}

	
	public void listDeptByName(String name) {
		var depts = deptRepo.findByNameContainingIgnoreCase(name);
		for(var d : depts )
			System.out.println(d.getName());
	}
	
	public void run(String... args) {
		// System.out.println(deptRepo.getClass());
		// listDepts();
		// addDept();
		// updateDept(100, "Department 100");
		// deleteDept(100);
		// getDeptByName("Sales");
		// listDeptByName("i");

	}
}
