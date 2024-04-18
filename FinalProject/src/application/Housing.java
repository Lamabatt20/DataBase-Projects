package application;

public class Housing {
	private int housing_id;
	private int survice_id;
	private int Ownerssn;
	private String Description;
	private String Namepet;
	private int petid;
	private String Typepet;
	private String ToDate;
	private String fromDate;
	private int RoomNum;

	
	
   static  Housing s;
	public Housing(int housing_id,  int ownerssn,int survice_id, String description, String namepet, int petid,
			String typepet, String toDate, String fromDate, int roomNum) {
		super();
		this.housing_id = housing_id;
		this.survice_id = survice_id;
		Ownerssn = ownerssn;
		Description = description;
		Namepet = namepet;
		this.petid = petid;
		Typepet = typepet;
		ToDate = toDate;
		this.fromDate = fromDate;
		RoomNum = roomNum;
	}

	public Housing(int ownerssn, String description, String namepet, int petid, String typepet, String toDate,
			String fromDate, int roomNum) {
		super();
		Ownerssn = ownerssn;
		Description = description;
		Namepet = namepet;
		this.petid = petid;
		Typepet = typepet;
		ToDate = toDate;
		this.fromDate = fromDate;
		RoomNum = roomNum;
	}



	public int getHousing_id() {
		return housing_id;
	}


	public void setHousing_id(int housing_id) {
		this.housing_id = housing_id;
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

	public void setOwnerssn(int Ownerssn) {
		Ownerssn = Ownerssn;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getNamepet() {
		return Namepet;
	}

	public void setNamepet(String Namepet) {
		Namepet = Namepet;
	}

	public int getPetid() {
		return petid;
	}

	public void setPetid(int petid) {
		this.petid = petid;
	}

	public String getTypepet() {
		return Typepet;
	}

	public void setTypepet(String typepet) {
		Typepet = typepet;
	}

	public String getToDate() {
		return ToDate;
	}

	public void setToDate(String toDate) {
		ToDate = toDate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public int getRoomNum() {
		return RoomNum;
	}

	public void setRoomNum(int roomNum) {
		RoomNum = roomNum;
	}

	@Override
	public String toString() {
		return "Housing [Ownerssn=" + Ownerssn + ", Description=" + Description + ", Namepet=" + Namepet + ", petid="
				+ petid + ", Typepet=" + Typepet + ", ToDate=" + ToDate + ", fromDate=" + fromDate + ", RoomNum="
				+ RoomNum + "]";
	}

}
