package jdbc_prog_Day4;

public class Employee {
	private int eid;
	private String ename;
	private String company;
	private String desg;
	private int sal;
	private int exp;
	
	
	public Employee(int eid, String ename, String company, String desg, int sal, int exp) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.company = company;
		this.desg = desg;
		this.sal = sal;
		this.exp = exp;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public Employee() {
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.eid+"\n"+this.ename+"\n"+this.company+"\n"+this.desg+"\n"+this.sal+"\n"+this.exp;
	}

}
