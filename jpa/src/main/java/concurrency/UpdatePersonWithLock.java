package concurrency;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

public class UpdatePersonWithLock {
	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_dll");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin(); 
		
		// Pessimistic locking 
	    Person p = em.find(Person.class, 1, LockModeType.PESSIMISTIC_READ);
	    p.setName("Srikanth3");
        Scanner s = new Scanner(System.in);
        System.out.println("Press ENTER to continue ...");
        var input = s.nextLine();
      	
		em.persist(p);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
