package basics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateDepartment {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();

		// Get department with id 90
		var d = em.find(Department.class, 90);
		if (d == null) {
			System.out.println("Sorry! Department id not found!");
		} else {
			em.getTransaction().begin();
			d.setName("Sports");
			em.getTransaction().commit();
		}

		em.close();
		emf.close();
	}
}
