package jdbc_prog_Day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Excute_Prog {
private static Connection con;
private static PreparedStatement pstmt;

public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded.");
		System.out.println("------------");
		
		con = DriverManager.getConnection(Credentials.url, Credentials.user, Credentials.pwd);
		if (con != null) {
			System.out.println("Connection Established.");
			System.out.println("------------");

			String query = "update employee set e_name = ? where e_id =?";
			pstmt = con.prepareStatement(query);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter New Name : ");
			pstmt.setString(1, sc.next());
			System.out.println("Enter New Name : ");
			pstmt.setInt(2, sc.nextInt());
			
			boolean b = pstmt.execute();
			System.out.println(b);
		if(b==false) {//excute() will return false if the query is non select query
			int x=pstmt.getUpdateCount();
			if(x>0) {
				System.out.println("Update successful");
			}else {
				System.out.println("Update not successful");
			}
		}else {
			System.out.println("Query Exceution failed");
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
