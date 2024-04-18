package application;

public class Survice {
	private int survice_id;
	private String survice_type;
	private  int survice_price ;
	public Survice(int survice_id, String survice_type, int survice_price) {
		super();
		this.survice_id = survice_id;
		this.survice_type = survice_type;
		this.survice_price = survice_price;
	}
	public int getSurvice_id() {
		return survice_id;
	}
	public void setSurvice_id(int survice_id) {
		this.survice_id = survice_id;
	}
	public String getSurvice_type() {
		return survice_type;
	}
	public void setSurvice_type(String survice_type) {
		this.survice_type = survice_type;
	}
	public int getSurvice_price() {
		return survice_price;
	}
	public void setSurvice_price(int survice_price) {
		this.survice_price = survice_price;
	}
	@Override
	public String toString() {
		return "Survice [survice_id=" + survice_id + ", survice_type=" + survice_type + ", survice_price="
				+ survice_price + "]";
	}
	
	

}
