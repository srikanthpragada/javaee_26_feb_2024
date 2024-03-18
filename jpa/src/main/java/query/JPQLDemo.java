package query;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPQLDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();

		Scanner s = new Scanner(System.in);
		String query;
		while (true) {
			System.out.println("Enter Query [enter to stop] : ");
			query = s.nextLine();
			
			if (query.length() == 0)
				break;
			
			try {
				List result = em.createQuery(query).getResultList();
				System.out.println("Query Result");
				System.out.println("=====================================================");
				for (Object obj : result) {
					if (obj instanceof Object[]) {
						// print each element of the array 
						for (Object o : (Object[]) obj) {
							System.out.print(o == null ? "  " : o.toString() + "  ");
						}
						System.out.println();
					} else // print object 
						System.out.println(obj.toString());

				} // for
			} // try
			catch (Exception ex) {
				System.out.println("Error-->" + ex.getMessage());
			}
		}
		em.close();
		emf.close();

	}

}
