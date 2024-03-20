package concurrency;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddPerson {
	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_ddl");
		EntityManager em = emf.createEntityManager();
		 
	    Person p = new Person();
	    p.setName("Srikanth");

		em.getTransaction().begin(); 
		em.persist(p);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
