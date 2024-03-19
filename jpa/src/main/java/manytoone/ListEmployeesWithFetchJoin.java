package manytoone;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListEmployeesWithFetchJoin {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();

		var query = em.createQuery("from manytoone.Employee e JOIN FETCH e.department", Employee.class);  // JPQL
		var emps  = query.getResultList();

		for (var emp : emps) {
			System.out.printf("%5d  %-20s  %6d  %-20s\n",
					  emp.getId(), emp.getName(), emp.getSalary(), emp.getDepartment().getName());
		}

		em.close();
		emf.close();

	}

}
