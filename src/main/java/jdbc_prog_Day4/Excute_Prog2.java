package jdbc_prog_Day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Excute_Prog2 {

	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet res;
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded.");
		System.out.println("------------");
		
		con = DriverManager.getConnection(Credentials.url, Credentials.user, Credentials.pwd);
		if(con!=null) {
			System.out.println("Connection established.");
			System.out.println("------------");

			String query = "select * from employee where e_id = ?";
			pstmt = con.prepareStatement(query);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the ID : ");
			pstmt.setInt(1, sc.nextInt());
			
			boolean b = pstmt.execute();
			System.out.println(b);
			if(b==true) {
		 res =pstmt.getResultSet();
			 
			while (res.next() == true) {
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getString(3));
				System.out.println(res.getString(4));
				System.out.println(res.getInt(5));
				System.out.println(res.getInt(6));

			}
			}
			else {
				System.out.println("Query Excution Failed.");
			}
		}
		else {
			System.out.println("Connection Failed.");
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
