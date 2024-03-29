package jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	   @Query("from jpa.Employee e join fetch e.department")  // JPQL 
	   List<Employee> getAllEmployees();
	   
	   List<Employee> findByDepartmentName(String name);
}
