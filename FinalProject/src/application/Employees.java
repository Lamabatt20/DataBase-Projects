package application;

public class Employees {
	private int e_ssn;
	private String e_name;
	private String e_email;
	private String e_Role ;
	private String e_phoneNum;
	private int e_salary;
	private String e_password;
	
	
	
	public Employees() {
		super();
	}
	static Employees emp;
	public Employees(int e_ssn, String e_name, String e_email, String e_Role, String e_phoneNum, int e_salary,
			String e_password) {
		super();
		this.e_ssn = e_ssn;
		this.e_name = e_name;
		this.e_email = e_email;
		this.e_Role = e_Role;
		this.e_phoneNum = e_phoneNum;
		this.e_salary = e_salary;
		this.e_password = e_password;
	}
	public int getE_ssn() {
		return e_ssn;
	}
	public void setE_ssn(int e_ssn) {
		this.e_ssn = e_ssn;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_email() {
		return e_email;
	}
	public void setE_email(String e_email) {
		this.e_email = e_email;
	}
	public String getE_Role() {
		return e_Role;
	}
	public void setE_Role(String e_Role) {
		this.e_Role = e_Role;
	}
	public String getE_phoneNum() {
		return e_phoneNum;
	}
	public void setE_phoneNum(String e_phoneNum) {
		this.e_phoneNum = e_phoneNum;
	}
	public int getE_salary() {
		return e_salary;
	}
	public void setE_salary(int e_salary) {
		this.e_salary = e_salary;
	}
	public String getE_password() {
		return e_password;
	}
	public void setE_password(String e_password) {
		this.e_password = e_password;
	}
	@Override
	public String toString() {
		return "Employee [e_ssn=" + e_ssn + ", e_name=" + e_name + ", e_email=" + e_email + ", e_Role=" + e_Role
				+ ", e_phoneNum=" + e_phoneNum + ", e_salary=" + e_salary + ", e_password=" + e_password + "]";
	}
	
	

}
