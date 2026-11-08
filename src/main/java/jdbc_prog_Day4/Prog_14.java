package jdbc_prog_Day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Prog_14 {

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

				String query = "select e_name,e_desg from employee where e_exp > ?";
				pstmt = con.prepareStatement(query);
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Enter Employee exp : ");
				pstmt.setInt(1, sc.nextInt());
				
				res = pstmt.executeQuery();

				while (res.next() == true) {
					System.out.println(res.getString(1));
					System.out.println(res.getString(2));
					

				}

			} else {
				System.out.println("Conection Failed.");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
