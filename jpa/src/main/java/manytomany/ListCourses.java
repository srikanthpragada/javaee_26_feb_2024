package manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListCourses {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory
				   ("mysql_ddl");
		EntityManager em = emf.createEntityManager();
		
		var course = em.find( Course.class, 1);
		
		System.out.println(course.getName());
		
		for(var s : course.getStudents()) {
			System.out.println(s.getName().indent(5));
		}

		em.close();
		emf.close();
		
	}

}
