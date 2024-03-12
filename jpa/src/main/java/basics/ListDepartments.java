package basics;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListDepartments {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();

		var query = em.createQuery("from basics.Department", Department.class);  // JPQL
		var depts = query.getResultList();

		
		for (var dept : depts) {
			System.out.printf("%5d  %-20s\n",dept.getId(),dept.getName());
		}

		em.close();
		emf.close();

	}

}
