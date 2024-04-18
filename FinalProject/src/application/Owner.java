package application;

public class Owner {
	private int o_ssn;
	private String o_name;
	private  String o_phoneNum;
	private String o_email;
	private int  pet_ID ;
	public Owner(int o_ssn, String o_name, String o_phoneNum, String o_email, int pet_ID) {
		super();
		this.o_ssn = o_ssn;
		this.o_name = o_name;
		this.o_phoneNum = o_phoneNum;
		this.o_email = o_email;
		this.pet_ID = pet_ID;
	}
	public int getO_ssn() {
		return o_ssn;
	}
	public void setO_ssn(int o_ssn) {
		this.o_ssn = o_ssn;
	}
	public String getO_name() {
		return o_name;
	}
	public void setO_name(String o_name) {
		this.o_name = o_name;
	}
	public String getO_phoneNum() {
		return o_phoneNum;
	}
	public void setO_phoneNum(String o_phoneNum) {
		this.o_phoneNum = o_phoneNum;
	}
	public String getO_email() {
		return o_email;
	}
	public void setO_email(String o_email) {
		this.o_email = o_email;
	}
	public int getPet_ID() {
		return pet_ID;
	}
	public void setPet_ID(int pet_ID) {
		this.pet_ID = pet_ID;
	}
	@Override
	public String toString() {
		return "Owner [o_ssn=" + o_ssn + ", o_name=" + o_name + ", o_phoneNum=" + o_phoneNum + ", o_email=" + o_email
				+ ", pet_ID=" + pet_ID + "]";
	}
	

}
