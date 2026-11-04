package jdbc_prog_Day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Prog_6 {

	 static Connection con;
	 static Statement stmt;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loades .");
		System.out.println("------------");
		
		 con = DriverManager.getConnection(Credentials.url,Credentials.user,Credentials.pwd);
		
		  
		  
		  if(con!=null) {
			  String query ="insert into student values (1,'Anupama')";
			  
			  stmt= con.createStatement();
			  
			  int x =stmt.executeUpdate(query);
			  if(x>=0) {
				  System.out.println("Data is Uploaded.");
			  }else {
				  System.out.println("Data is Uploaded.");
			  }
		  }else {
			  System.out.println("Connction Failed");
		  }

		 
	}

}
