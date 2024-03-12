package basics;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddDepartment {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();

		// Create an object of Department
		var d = new Department();
		d.setId(90);
		d.setName("Sports");
		
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		

		em.close();
		emf.close();

	}

}
