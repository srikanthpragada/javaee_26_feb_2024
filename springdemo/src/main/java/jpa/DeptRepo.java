package jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DeptRepo extends CrudRepository<Department, Integer> {

	// Get department by name - query derivation 
	Department getByName(String name);
	
	// Get department by name - query derivation 
	List<Department> findByNameContainingIgnoreCase(String name);

}
