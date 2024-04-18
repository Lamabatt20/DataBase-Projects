package application;

public class Room {
	private int Room_Num ;
	private Boolean Room_availability;
	static Room R;
	public int getRoom_Num() {
		return Room_Num;
	}
	public void setRoom_Num(int room_Num) {
		Room_Num = room_Num;
	}
	public Boolean getRoom_availability() {
		return Room_availability;
	}
	public void setRoom_availability(Boolean room_availability) {
		Room_availability = room_availability;
	}
	public Room(int room_Num, Boolean room_availability) {
		super();
		Room_Num = room_Num;
		Room_availability= room_availability;
	}
	@Override
	public String toString() {
		return  Room_Num  +"";
	}
	public Room(int room_Num) {
		super();
		Room_Num = room_Num;
	}
	
	
	

}
