package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateDeptName {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection
				           ("jdbc:mysql://localhost:3306/feb26","root","mysql");
		
		PreparedStatement ps = con.prepareStatement
		   ("update departments set department_name = ? where department_id = ?");
		
		ps.setString(1, "IT");
		ps.setInt(2, 60);
		
		int count = ps.executeUpdate();
		if(count == 1)
			System.out.println("Updated Successfully!");
		else
			System.out.println("Department Id not found!");
		
		con.close();
	}
}