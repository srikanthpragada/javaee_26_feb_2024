package manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddCoursesStudents {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory
				   ("mysql_ddl");
		EntityManager em = emf.createEntityManager();
		
		Student s1 = new Student("Student1");
		Student s2 = new Student("Student2");
		
		Course c1 = new Course("Java");
		Course c2 = new Course("Python");
		
		c1.getStudents().add(s1);
		c1.getStudents().add(s2);
		c2.getStudents().add(s2);
		
		s1.getCourses().add(c1);
		s2.getCourses().add(c1);
		s2.getCourses().add(c2);
		
		em.getTransaction().begin();
		em.persist(s1);  
		em.persist(s2);
		em.persist(c1);
		em.persist(c2);
		em.getTransaction().commit();

		em.close();
		emf.close();
		
	}

}
