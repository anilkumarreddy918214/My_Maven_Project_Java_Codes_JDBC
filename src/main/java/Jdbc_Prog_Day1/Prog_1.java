package Jdbc_Prog_Day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Prog_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		//Step : 1 --> Loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("The Driver is Loaded Successfully.");
		System.out.println("-------");
		
		//Step : 2 --> Establishing Connection
		/*
		 * URL = jdbc:mysql://localhost:3306/db_name
		 * 
		 * ---> jdbc  = API
		 * ---> mysql = database
		 * ---> localhost = network
		 * ---> 3306  = port number
		 * ---> db_name =database to which connection has to be made
		 * 
		 * user = root
		 * password = AnilJishnu@918
		 */
		
		String url ="jdbc:mysql://localhost:3306/jdbc_c1";
		String root = "root";
		String psw = "AnilJishnu@918";
		Connection con = DriverManager.getConnection(url,root,psw);
		
		System.out.println("Connection Established Successfully.");
		}
		
		catch(ClassNotFoundException e) {
			System.out.println("Driver Class Not Detected");
			e.printStackTrace();
		}
		
		catch(SQLException e) {
			System.out.println("Sql Exception Generated");
			e.printStackTrace();
		
		}
    }
	}


