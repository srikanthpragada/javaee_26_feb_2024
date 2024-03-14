package collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddProgrammer {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory
				  ("mysql_ddl");
		EntityManager em = emf.createEntityManager();
		
		Programmer p = new Programmer();
		p.setName("Anders");
		p.getSkills().add("C#");
		p.getSkills().add("TypeScript");
		p.getSkills().add("Delphi");
		
		em.getTransaction().begin(); 
		em.persist(p);
	    em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
