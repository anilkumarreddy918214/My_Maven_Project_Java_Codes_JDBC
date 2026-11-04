package jdbc_prog_Day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Prog_5 {
	
	static Connection con;
	static Statement stmt;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		// Step : 1 --> Loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is Loaded Successfully");
		System.out.println("----------");

		// Step : 2 --> Establishing Connection

		con = DriverManager.getConnection(Credentials.url, Credentials.user, Credentials.pwd);

		if (con != null) {
			// Step :3 Create SQL Query
			String query = "delete from student where s_id = 1;";

			// step 4: convert query to SQL into statement

			stmt = con.createStatement();

			// step:5 Execute the query and collect result
			int x = stmt.executeUpdate(query);

			if (x >= 0) {
				System.out.println("Data is deleted");
			} else {
				System.out.println("Data is not deleted");
			}
		} else {
			System.out.println("Connection failed");
		}

}

}
