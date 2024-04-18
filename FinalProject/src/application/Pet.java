package application;

public class Pet {
	private int pet_Id;
	private String p_Name ;
	private String p_Type;
	private String p_Breed;
	private String p_BirthOfDate ;
	private int  p_Weight;
	private String p_Des ;
	public Pet(int pet_Id, String p_Name, String p_Type, String p_Breed, String p_BirthOfDate, int p_Weight,
			String p_Des) {
		super();
		this.pet_Id = pet_Id;
		this.p_Name = p_Name;
		this.p_Type = p_Type;
		this.p_Breed = p_Breed;
		this.p_BirthOfDate = p_BirthOfDate;
		this.p_Weight = p_Weight;
		this.p_Des = p_Des;
	}
	public int getPet_Id() {
		return pet_Id;
	}
	public void setPet_Id(int pet_Id) {
		this.pet_Id = pet_Id;
	}
	public String getP_Name() {
		return p_Name;
	}
	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}
	public String getP_Type() {
		return p_Type;
	}
	public void setP_Type(String p_Type) {
		this.p_Type = p_Type;
	}
	public String getP_Breed() {
		return p_Breed;
	}
	public void setP_Breed(String p_Breed) {
		this.p_Breed = p_Breed;
	}
	public String getP_BirthOfDate() {
		return p_BirthOfDate;
	}
	public void setP_BirthOfDate(String p_BirthOfDate) {
		this.p_BirthOfDate = p_BirthOfDate;
	}
	public int getP_Weight() {
		return p_Weight;
	}
	public void setP_Weight(int p_Weight) {
		this.p_Weight = p_Weight;
	}
	public String getP_Des() {
		return p_Des;
	}
	public void setP_Des(String p_Des) {
		this.p_Des = p_Des;
	}
	@Override
	public String toString() {
		return "Pet [pet_Id=" + pet_Id + ", p_Name=" + p_Name + ", p_Type=" + p_Type + ", p_Breed=" + p_Breed
				+ ", p_BirthOfDate=" + p_BirthOfDate + ", p_Weight=" + p_Weight + ", p_Des=" + p_Des + "]";
	}
	
	
	

}
