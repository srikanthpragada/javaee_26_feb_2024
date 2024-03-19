package query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NativeQueryDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		Query query =   em.createNativeQuery("select * from employees order by salary desc  limit 3", Employee.class);
		List<Employee> employees = query.getResultList();
		
		for(var e : employees)
			System.out.println(e.getName());
		 
		em.close();
		emf.close();

	}

}
