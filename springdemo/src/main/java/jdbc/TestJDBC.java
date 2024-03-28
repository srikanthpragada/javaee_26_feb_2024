package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestJDBC implements CommandLineRunner {
	@Autowired
	DeptManager deptManager;
	@Autowired
	EmployeeManager empManager;
	 
	@Autowired
	SJIDemo sjiDemo;

	public static void main(String[] args) {
		SpringApplication.run(TestJDBC.class, args);
	}
	
	
	public void run(String... args) {
		//deptManager.showDeptCount();
		
		//deptManager.listDeptNames();
		
		//deptManager.listDepts();
		
		// deptManager.listDeptTotalSalary(); 
		
		// deptManager.updateDeptName(60, "IT & ITES");
		
		// sjiDemo.add("90","Department 90");
      
		empManager.hikeSalaries(100, 120);
	}
}
