package jdbc_prog_Day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scrolable_last_TO_First {

	private static Connection con;
	private static PreparedStatement pstmt;

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

			String query = "select * from employee";
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet res = stmt.executeQuery(query);
			res.afterLast();
			while(res.previous() == true) {
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getString(3));
				System.out.println(res.getString(4));
				System.out.println(res.getInt(5));
				System.out.println(res.getInt(6));
				System.out.println("--------------");
			}
			
			
			
	}else {
		System.out.println("Connection Failed.");
	}
		

}catch (Exception e) {
	e.printStackTrace();
}
	}
}
