package inh;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddPersons {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_ddl");
		EntityManager em = emf.createEntityManager();

	 
		Player p1 = new Player();
		p1.setName("Dhoni");
		p1.setGame("Cricket");
		
		Singer s1 = new Singer();
		s1.setName("Micheal Jackson");
		s1.setLang("English");
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(s1);
		em.getTransaction().commit();
		

		em.close();
		// Detached
		emf.close();

	}

}
