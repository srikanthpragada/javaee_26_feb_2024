package pk;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddCustomer {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_ddl");
		EntityManager em = emf.createEntityManager();

        var c = new Customer("Customer1"); 
		
		em.getTransaction().begin();
		em.persist(c);
		// Managed 
		em.getTransaction().commit();
		

		em.close();
		// Detached
		emf.close();

	}

}
