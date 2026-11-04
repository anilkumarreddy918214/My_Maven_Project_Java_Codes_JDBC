package jdbc_prog_Day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Prog_1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is Loaded Successfully");
		System.out.println("----------");

		String url = "jdbc:mysql://localhost:3306/gqt_sep_batch";
		String user = "root";
		String pwd = "AnilJishnu@918";
		Connection con = DriverManager.getConnection(url, user, pwd);

		if (con != null) {
			String query = "CREATE DATABASE JDBC_DB";
			Statement stmt = con.createStatement();

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
