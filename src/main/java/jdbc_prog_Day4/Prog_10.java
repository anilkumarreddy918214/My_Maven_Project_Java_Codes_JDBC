package jdbc_prog_Day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Prog_10 {

	static Connection con;
	static PreparedStatement pstmt;
	static ResultSet res;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded.");
			System.out.println("------------");

			con = DriverManager.getConnection(Credentials.url, Credentials.user, Credentials.pwd);
			if (con != null) {
				System.out.println("Connection Established.");
				System.out.println("------------");

				String query = "select * from employee";
				pstmt = con.prepareStatement(query);
				res = pstmt.executeQuery();

				while (res.next() == true) {
					System.out.println(res.getInt(1));
					System.out.println(res.getString(2));
					System.out.println(res.getString(3));
					System.out.println(res.getString(4));
					System.out.println(res.getInt(5));
					System.out.println(res.getInt(6));

				}

			} else {
				System.out.println("Conection Failed.");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
