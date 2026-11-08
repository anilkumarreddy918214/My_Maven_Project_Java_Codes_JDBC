package jdbc_prog_Day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Prog_8 {

	static Connection con;
	static PreparedStatement pstmt;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded Successfully .");
		System.out.println("------------");

		con = DriverManager.getConnection(Credentials.url, Credentials.user, Credentials.pwd);
		if (con != null) {
			System.out.println("Connection estabilshed Succesfully");
			System.out.println("------------");

			String query = "insert into employee values(?,?,?,?,?,?)";
			// Since we have Placeholders the query must be handled
			// by preaparedStatement

			pstmt = con.prepareStatement(query);

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Employee ID : ");
			int eid = sc.nextInt();
			System.out.println("Enter the Employee name : ");
			String name = sc.next();
			System.out.println("Enter the Employee company : ");
			String com = sc.next();
			System.out.println("Enter the Employee desigination : ");
			String desg = sc.next();
			System.out.println("Enter the Employee Salary : ");
			int sal = sc.nextInt();
			System.out.println("Enter the Employee Experience : ");
			int exp = sc.nextInt();

			// Allocating the collected values
			pstmt.setInt(1, eid);
			pstmt.setString(2, name);
			pstmt.setString(3, com);
			pstmt.setString(4, desg);
			pstmt.setInt(5, sal);
			pstmt.setInt(6, exp);

			int x = pstmt.executeUpdate();
			if (x > 0) {
				System.out.println("Data inserted.");
			} else {
				System.out.println("Data not  inserted.");
			}
		} else {
			System.out.println("Connection Failed.");
		}
	}

}
