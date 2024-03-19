package query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NamedQueryDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		Query query =   em.createNamedQuery("CostlyEmployees", Employee.class);
		List<Employee> employees = query.getResultList();
		
		for(var e : employees)
			System.out.printf("%-20s  %8d\n", e.getName(), e.getSalary());
		 
		em.close();
		emf.close();

	}

}
