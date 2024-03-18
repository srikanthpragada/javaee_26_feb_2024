package inh.tps;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListPersons {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_ddl");
		EntityManager em = emf.createEntityManager();

	  
		var query = em.createQuery("from inh.tps.Player", Person.class);
		
		for(var p : query.getResultList()) {
			System.out.println(p.getName());
		}
		
		em.close();
		emf.close();

	}

}
