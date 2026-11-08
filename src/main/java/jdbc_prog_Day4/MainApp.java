package jdbc_prog_Day4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Select the Operations : \n"
				+ "1.Insert Operation\n" 
				+ "2.Update Name Operation\n"
				+ "3.Update Salary from All Employee\n" 
				+ "4.Update Salary from Employee for Specificc Company\n"
				+ "5.Delete an employee by ID\n" 
				+ "6.View All Employees\n" 
				+ "7.View Employee by ID\n" 
				+ "8.View Employee Based on Company\n"
				+ "9.Exit");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		Model m = new Model();
		switch (choice) {
		case 1: {
			m.insertData();
			main(null);
		}
		case 2: {
			m.updateName();
			main(null);
		}
		case 3: {
			m.updateAllSalary();
			main(null);
		}
		case 4: {
			m.updateSalaryWithID();
			main(null);
		}
		case 5: {
			m.deleteByID();
			main(null);
		}

		case 6: {
			ArrayList<Employee> al = m.viewAllEmp();
			if (al != null) {
				Iterator<Employee> itr = al.iterator();
				while (itr.hasNext() == true) {
					System.out.println(itr.next());
				}
			} else {
				System.out.println("Could not fetech the Data.");
			}
			main(null);
		}
		
		case 7:{
			 Employee e = m.viewEmpByID();
			System.out.println(e.getEid());
			System.out.println(e.getEname());
			System.out.println(e.getCompany());
			System.out.println(e.getDesg());
			System.out.println(e.getSal());
			System.out.println(e.getExp());
			
			main(null);
		}
		case 8:{
			 Employee e = m.viewEmpBasedOnComp();
			System.out.println(e.getEid());
			System.out.println(e.getEname());
			System.out.println(e.getCompany());
			System.out.println(e.getDesg());
			System.out.println(e.getSal());
			System.out.println(e.getExp());
			
			main(null);
		}
		default:
			System.out.println("Terminated.");
			System.exit(0);
		}

	}

}
