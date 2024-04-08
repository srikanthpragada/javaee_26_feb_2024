package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import web.data.Employee;
import web.data.EmployeeRepo;

@RestController
@RequestMapping("/rest")
public class RestEmployeeController {
	@Autowired
	public EmployeeRepo empRepo; 

	@GetMapping("/employees") 
	@CrossOrigin(origins = {"http://localhost:8000"})
	@Operation(summary = "Gets all employees!")
	public Iterable<Employee> getAllEmployees() {
		try {
			return empRepo.findAll(); 
		} catch (DataAccessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@GetMapping("/employees/{id}")
	@Operation(summary = "Get details of a single employee based on given employee id")
	@ApiResponses (value ={ @ApiResponse (responseCode = "200",
	    description = "Returned A Single Employee Successfully"),
	   @ApiResponse(responseCode = "404", description = "Employee Id Not Found") })
	public Employee getOneEmployee(
			@Parameter( description = "Employee id of the employee")
			@PathVariable Integer id) {
		try { 
			var optEmp = empRepo.findById(id);
			if (optEmp.isEmpty()) // Id not found
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Id Not Found");
			return optEmp.get(); // return Employee
		} catch (DataAccessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
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

	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		try {
			var optEmp = empRepo.findById(id);
			if (optEmp.isEmpty()) // Id not found
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Id Not Found");
			System.out.println("Deleting " + id);
			empRepo.delete(optEmp.get());
		
		} catch (DataAccessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}
	
	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		try {
			if (employee.getSalary() < 0)
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Salary");
			
			var optEmp = empRepo.findById(id);
			if (optEmp.isEmpty()) // Id not found
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Id Not Found");
			
			var emp = optEmp.get();
			emp.setSalary(employee.getSalary());
			emp.setJobId(employee.getJobId());
			empRepo.save(emp);
		
		} catch (DataAccessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@GetMapping("/employees/dept/{id}")
	public Iterable<Employee> getDeptEmployees(@PathVariable Integer id) {
		try {
			return empRepo.findByDeptId(id);
		} catch (DataAccessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@GetMapping("/employees/search/{name}")
	public Iterable<Employee> searchEmployees(@PathVariable String name) {
		try {
			return empRepo.findByNameContaining(name);
		} catch (DataAccessException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}
	
	
}
