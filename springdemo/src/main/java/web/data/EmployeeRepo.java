package web.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	// Query Derivation
	List<Employee> findByDeptId(int id);

	// Query Derivation
    List<Employee> findByJobId(String id);
		
	// Query Derivation
	List<Employee> findByNameContaining(String name);

}
