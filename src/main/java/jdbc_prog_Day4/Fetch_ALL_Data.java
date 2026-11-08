package jdbc_prog_Day4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Fetch_ALL_Data {

	private static Connection con;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded.");
			System.out.println("------------");

			con = DriverManager.getConnection(Credentials.url, Credentials.user, Credentials.pwd);
			if (con != null) {
				System.out.println("Connection established.");
				System.out.println("------------");

				String query = "{call fetchAllData()}";
				CallableStatement call = con.prepareCall(query);
				ResultSet res = call.executeQuery();
				res.afterLast();
				while (res.previous() == true) {
					System.out.println(res.getInt(1));
					System.out.println(res.getString(2));
					System.out.println(res.getString(3));
					System.out.println(res.getString(4));
					System.out.println(res.getInt(5));
					System.out.println(res.getInt(6));
					System.out.println("--------------");
				}

			} else {
				System.out.println("Connection Failed.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}