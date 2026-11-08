package jdbc_prog_Day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Prog_13 {

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

				String query = "select * from employee where e_name = ? AND e_sal > ?";
				pstmt = con.prepareStatement(query);
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Employee name : ");
				pstmt.setString(1, sc.next());
				System.out.println("Enter Employee sal : ");
				pstmt.setInt(2, sc.nextInt());
				
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
