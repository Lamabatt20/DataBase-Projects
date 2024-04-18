package application;

public class VeterinaryCare {
	private  int care_id ;
	private int survice_id;
	private  int Ownerssn;
	private String CareType;
	private  String Description;
	private String NamePet ;
	private int petId;
	private String TypePet;
	
	static VeterinaryCare vc;
	public VeterinaryCare(int care_id, int survice_id, int ownerssn, String careType, String description,
			String namePet, int petId, String typePet) {
		super();
		this.care_id = care_id;
		this.survice_id = survice_id;
		Ownerssn = ownerssn;
		CareType = careType;
		Description = description;
		NamePet = namePet;
		this.petId = petId;
		TypePet = typePet;
	}
	

	public VeterinaryCare(int ownerssn, String careType, String description, String namePet, int petId,
			String typePet) {
		super();
		Ownerssn = ownerssn;
		CareType = careType;
		Description = description;
		NamePet = namePet;
		this.petId = petId;
		TypePet = typePet;
	}


	public int getCare_id() {
		return care_id;
	}


	public void setCare_id(int care_id) {
		this.care_id = care_id;
	}


	public int getSurvice_id() {
		return survice_id;
	}


	public void setSurvice_id(int survice_id) {
		this.survice_id = survice_id;
	}


	public int getOwnerssn() {
		return Ownerssn;
	}
	
	public void setOwnerssn(int ownerssn) {
		Ownerssn = ownerssn;
	}
	public String getCareType() {
		return CareType;
	}
	public void setCareType(String careType) {
		CareType = careType;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getNamePet() {
		return NamePet;
	}
	public void setNamePet(String namePet) {
		NamePet = namePet;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getTypePet() {
		return TypePet;
	}
	public void setTypePet(String typePet) {
		TypePet = typePet;
	}

	@Override
	public String toString() {
		return "VeterinaryCare [Ownerssn=" + Ownerssn + ", CareType=" + CareType + ", Description=" + Description
				+ ", NamePet=" + NamePet + ", petId=" + petId + ", TypePet=" + TypePet + "]";
	}
	
	
	

}
