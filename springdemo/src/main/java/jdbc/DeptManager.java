package jdbc;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
public class DeptManager {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	public void showDeptCount() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from departments", Integer.class);
		System.out.println("Count = " + count);
	}

	public void listDeptNames() {
		List<String> deptNames = jdbcTemplate.queryForList("select department_name from departments", String.class);

		for (String name : deptNames)
			System.out.println(name);
	}

	public void listDepts() {
		List<Department> depts = jdbcTemplate.query("select * from departments",
				// RowMapper (mapRow(rs, int)) is implemented using Lambda Expression
				(rs, rowNum) -> new Department(rs.getString("department_id"), rs.getString("department_name")));

		for (Department d : depts)
			System.out.printf("%-4s  %s\n", d.getId(), d.getName());
	}

	public void listDeptTotalSalary() {
		List<DeptTotalSalary> depts = jdbcTemplate.query(
				"select department_name, sum(salary) from employees e inner join departments d using(department_id) group by department_name",
				(rs, rowNum) -> new DeptTotalSalary(rs.getString("department_name"), rs.getInt(2)));

		for (var d : depts)
			System.out.printf("%-20s  %d\n", d.getName(), d.getTotalSalary());
	}

	public void updateDeptName(int id, String name) {
		int count = jdbcTemplate.update("update departments set department_name = ? where department_id = ?",name, id);
		System.out.println("No. of rows updated : " + count);
	}
	

	public void updateDeptNameWithNT(int id, String name) {
		var params = new MapSqlParameterSource().addValue("id",id).addValue("name", name);

		int count = namedJdbcTemplate.update("update departments set department_name  = :name where department_id = :id", params);
		System.out.println("No. of rows updated : " + count);
	}
	

	
}
