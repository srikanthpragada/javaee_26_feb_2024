package mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListDepartments {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feb26",
				                                     "root","mysql");
        
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from departments");
		
		while(rs.next()) {
			System.out.printf("%3d  %-20s\n", rs.getInt("department_id"), rs.getString("department_name"));
		}

		st.close();
		con.close();
	}

}
