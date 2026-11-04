package jdbc_prog_Day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Prog_1_secure {

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
			String query = "CREATE DATABASE JDBC_DB";
			// step 4: convert query to SQL into statement
			stmt = con.createStatement();
			//step:5 Execute the query and collect result
			int x = stmt.executeUpdate(query);
			if (x >= 0) {
				System.out.println("DataBase is Created.");
			} else {
				System.out.println("DataBase is not Created.");

			}

		} else {
			System.out.println("Connection Failed");
		}

	}

}
