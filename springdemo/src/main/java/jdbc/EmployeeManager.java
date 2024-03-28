package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component 
public class EmployeeManager {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void hikeSalaries(int firstId, int secondId) {
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		System.out.println("Transaction Begins");

		int count = jdbcTemplate.update(
				"update employees set salary = salary * 1.1 where employee_id = ?",
				 firstId);
		if (count == 0) {
			// throw new RuntimeException();
			status.setRollbackOnly();
		} else {
			System.out.println("First Update Done");
			count = jdbcTemplate.update
					("update employees set salary = salary * 1.1 where employee_id = ?", secondId);
			if (count == 0)
				status.setRollbackOnly();
			else
				System.out.println("Second update done!");
		}
		
		System.out.println("New Transaction : " + status.isNewTransaction());
		System.out.println("Rollback ? " + status.isRollbackOnly());
		System.out.println("The End!");
	}
}
