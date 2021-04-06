package application;

import java.util.ArrayList;

public class DounteType {
	private int count = 0;
	private String flower = "";
	protected double pricePerDounter = 0.0;
	
	public ArrayList<String> getAllFlowers(){
		ArrayList<String> ret  = new ArrayList<String>();
		return ret;
	}
	
	public String getDountName() {
		
		return "";
	}
	
	public double itemPrice() {
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
	public double getNumberOfDounte() {
		return (double)count;
	} 
}
