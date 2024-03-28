package jdbc;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

@Component
public class SJIDemo {
	private SimpleJdbcInsert sji;
	
    // Constructor injection 
	public SJIDemo(DataSource datasource) {
		this.sji = new SimpleJdbcInsert(datasource);
		this.sji.withTableName("departments").usingColumns("department_id","department_name");
	}

	public void add(String id, String name) {
		HashMap<String, String> dept = new HashMap<>();
		dept.put("department_id", id);
		dept.put("department_name", name);
		int count = sji.execute(dept);  // INSERT is executed 
		System.out.printf("Added %d Dept Successfully!\n", count);
	}
}
