package manytoone;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListDepartments {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();

		var query = em.createQuery("from manytoone.Department", Department.class);  // JPQL
		var depts  = query.getResultList();

		for (var dept : depts) {
			System.out.println(dept.getName());
			// Employees
			for(var emp : dept.getEmployees()) {
				System.out.println(emp.getName().indent(3));
			}
		}

		em.close();
		emf.close();

	}

}
