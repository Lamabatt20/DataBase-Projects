package application;

public class Vets {
	private int veteran_id ;
	private int  e_ssn ;
	public int getVeteran_id() {
		return veteran_id;
	}
	static Vets v;
	public void setVeteran_id(int veteran_id) {
		this.veteran_id = veteran_id;
	}
	public int getE_ssn() {
		return e_ssn;
	}
	public void setE_ssn(int e_ssn) {
		this.e_ssn = e_ssn;
	}
	public Vets(int veteran_id, int e_ssn) {
		super();
		this.veteran_id = veteran_id;
		this.e_ssn = e_ssn;
	}
	@Override
	public String toString() {
		return "Vets [veteran_id=" + veteran_id + ", e_ssn=" + e_ssn + "]";
	}
	
	

}
