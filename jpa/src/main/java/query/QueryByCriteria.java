package query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class QueryByCriteria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
		
		Root<Employee> root = cr.from(Employee.class);
		cr.select(root).where(cb.between(root.get("salary"), 10000, 20000));

		var query = em.createQuery(cr);
		List<Employee> employees = query.getResultList();

		for (var e  : employees)
			System.out.printf("%-20s %8d\n", e.getName(), e.getSalary());
		
		em.close();
		emf.close();
	}
}
