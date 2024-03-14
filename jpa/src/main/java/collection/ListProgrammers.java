package collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListProgrammers {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory
				  ("mysql_ddl");
		EntityManager em = emf.createEntityManager();
		
        var query = em.createQuery("from collection.Programmer", Programmer.class);
        var programmers = query.getResultList();
        
        for(var p : programmers) {
        	System.out.println(p.getName());
//        	for(var s : p.getSkills())
//        		System.out.println("   " + s);
        }
		

		em.close();
		emf.close();
	}

}
