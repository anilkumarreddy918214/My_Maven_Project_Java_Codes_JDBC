package jdbc_prog_Day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;

	public Model() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded.");
			System.out.println("------------");
			con = DriverManager.getConnection(Credentials.url, Credentials.user, Credentials.pwd);
			System.out.println("Connection Established.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean insertData() {
		try {

			String query = "insert into employee values (?,?,?,?,?,?)";
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
				return true;
			} else {
				System.out.println("Data not  inserted.");
				return false;
			}

		}

		catch (Exception e1) {
			return false;
		}

	}

	public boolean updateName() {
		try {

			String query = "update employee set e_name = ? where e_id =?";
			pstmt = con.prepareStatement(query);

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Employee ID : ");
			int eid = sc.nextInt();
			System.out.println("Enter the New Employee name : ");
			String name = sc.next();

			// Allocating the collected values
			pstmt.setString(1, name);
			pstmt.setInt(2, eid);

			int x = pstmt.executeUpdate();
			if (x > 0) {
				System.out.println("Data inserted.");
				return true;
			} else {
				System.out.println("Data not  inserted.");
				return false;
			}

		}

		catch (Exception e1) {
			return false;
		}

	}

	public boolean updateAllSalary() {
		try {

			String query = "update employee set e_sal = e_sal + ?";
			pstmt = con.prepareStatement(query);

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Amount Incremented to the Salary : ");
			int amt = sc.nextInt();

			// Allocating the collected values

			pstmt.setInt(1, amt);

			int x = pstmt.executeUpdate();
			if (x > 0) {
				System.out.println("Salary Updated for All Employees");
				return true;
			} else {
				System.out.println("Salary not  Updated for All Employees");
				return false;
			}

		}

		catch (Exception e1) {
			return false;
		}

	}

	public boolean updateSalaryWithID() {
		try {

			String query = "update employee set e_sal = e_sal + ? where e_id = ?";
			pstmt = con.prepareStatement(query);

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Amount Incremented to the Salary : ");
			int amt = sc.nextInt();
			System.out.println("Enter the Employee ID :");
			int eid = sc.nextInt();
			// Allocating the collected values

			pstmt.setInt(1, amt);
			pstmt.setInt(2, eid);

			int x = pstmt.executeUpdate();
			if (x > 0) {
				System.out.println("Salary Updated for the Employees with ID " + eid);
				return true;
			} else {
				System.out.println("Salary Updated for the Employees with ID " + eid);
				return false;
			}

		}

		catch (Exception e1) {
			return false;
		}

	}

	public boolean deleteByID() {
		try {

			String query = "delete from employee where e_id = ?";
			pstmt = con.prepareStatement(query);

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the Employee ID :");
			int eid = sc.nextInt();
			// Allocating the collected values

			pstmt.setInt(1, eid);

			int x = pstmt.executeUpdate();
			if (x > 0) {
				System.out.println(" Employees with ID " + eid + " is Deleted");
				return true;
			} else {
				System.out.println("Employees with ID " + eid + " is Deleted");
				return false;
			}

		}

		catch (Exception e1) {
			return false;
		}

	}

	public ArrayList<Employee> viewAllEmp() {
		try {

			String query = "select * from employee";
			stmt = con.createStatement();
			res = stmt.executeQuery(query);

			ArrayList<Employee> al = new ArrayList<Employee>();

			while (res.next() == true) {
				Employee e = new Employee();

				e.setEid(res.getInt(1));
				e.setEname(res.getString(2));
				e.setCompany(res.getString(3));
				e.setDesg(res.getString(4));
				e.setSal(res.getInt(5));
				e.setExp(res.getInt(6));

				// Employee e1 = new Employee(res.getInt(1),res.getString(2),....);

				al.add(e);

			}

			return al;

		}

		catch (Exception e1) {
			return null;
		}

	}

	public Employee viewEmpByID() {
		try {

			String query = "select * from employee where e_id = ?";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Employee ID : ");
			int eid = sc.nextInt();

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, eid);

			res = pstmt.executeQuery();

			Employee e = new Employee();

			while (res.next() == true) {

				e.setEid(res.getInt(1));
				e.setEname(res.getString(2));
				e.setCompany(res.getString(3));
				e.setDesg(res.getString(4));
				e.setSal(res.getInt(5));
				e.setExp(res.getInt(6));

				// Employee e1 = new Employee(res.getInt(1),res.getString(2),....);

			}

			return e;

		}

		catch (Exception e1) {
			return null;
		}

	}

	public Employee viewEmpBasedOnComp() {
		try {

			String query = "select * from employee where e_company = ?";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Employee company : ");
			String com = sc.next();

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, com);

			res = pstmt.executeQuery();

			Employee e = new Employee();

			while (res.next() == true) {

				e.setEid(res.getInt(1));
				e.setEname(res.getString(2));
				e.setCompany(res.getString(3));
				e.setDesg(res.getString(4));
				e.setSal(res.getInt(5));
				e.setExp(res.getInt(6));

				// Employee e1 = new Employee(res.getInt(1),res.getString(2),....);

			}

			return e;

		}

		catch (Exception e1) {
			return null;
		}

	}

}
