package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import web.data.Employee;
import web.data.EmployeeRepo;

@RestController
@RequestMapping("/rest")
public class RestEmployeeController {
	@Autowired
	public EmployeeRepo empRepo;

	@GetMapping("/employees")
	public Iterable<Employee> getAllEmployees() {
		try {
			return empRepo.findAll();
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@GetMapping("/employees/{id}")
	public Employee getOneEmployees(@PathVariable Integer id) {
		var optEmp = empRepo.findById(id);
		if (optEmp.isEmpty()) // Id not found
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Id Not Found");
		return optEmp.get(); // return Employee
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		try {
			empRepo.save(employee);
			return employee;
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}

	}

}
