package application;

public class Stray_Pet {
	private int  pet_Id;

	public int getPet_Id() {
		return pet_Id;
	}

	public void setPet_Id(int pet_Id) {
		this.pet_Id = pet_Id;
	}

	public Stray_Pet(int pet_Id) {
		super();
		this.pet_Id = pet_Id;
	}

	@Override
	public String toString() {
		return "Stray_Pet [pet_Id=" + pet_Id + "]";
	}
	
	

}
