package application;

import java.util.ArrayList;

public class DounteType {
	private int count = 0;
	private String flower = "";
	protected Double pricePerDounter = 0.0;
	
	public ArrayList<String> getAllFlowers(){
		ArrayList<String> ret  = new ArrayList<String>();
		return ret;
	}
	
	public Double itemPrice() {
		return pricePerDounter * getNumberOfDounte();
	}
	
	public String getFlower() {
		return flower;
	}
	
	public void setFlower(String dountFlower) {
		flower = dountFlower;
	}
	
	public void setNumberOfDounte(int numberofDount) {
		count = numberofDount;
	}
	public int getNumberOfDounte() {
		return count;
	} 
}
