package composition;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddPlayer {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_ddl");
		EntityManager em = emf.createEntityManager();

        var p = new Player("Player1", new Address("Street1", "City1")); 
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		

		em.close();
		emf.close();

	}

}
