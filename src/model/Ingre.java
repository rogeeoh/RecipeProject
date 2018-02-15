package model;

public class Ingre {
	private int recp_no;
	private String ingre;
	private String amount;
	
	@Override
	public String toString() {
		return "Ingre [recp_no=" + recp_no + ", ingre=" + ingre + ", amount=" + amount + "]";
	}
	
	public int getRecp_no() {
		return recp_no;
	}
	public void setRecp_no(int recp_no) {
		this.recp_no = recp_no;
	}
	public String getIngre() {
		return ingre;
	}
	public void setIngre(String ingre) {
		this.ingre = ingre;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
