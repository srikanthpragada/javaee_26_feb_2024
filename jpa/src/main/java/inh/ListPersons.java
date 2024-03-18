package inh;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListPersons {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_ddl");
		EntityManager em = emf.createEntityManager();

	  
		var query = em.createQuery("from inh.Player", Person.class);
		
		for(var p : query.getResultList()) {
			System.out.println(p.getName());
			System.out.println(p.getClass());
		}
		
		em.close();
		// Detached
		emf.close();

	}

}
