package application;

import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeType {

	private static final double BASEPRICE = 1.99;
	protected double priceIncrease = 0.0;
	protected double pricePerAddIn = 0.20;
	private int count = 0;
	
	private ArrayList<String> addedInList;
	private final ArrayList<String> AddIns = new ArrayList<String>(Arrays.asList("cream", "syrup", "milk", "caramel", "whipped cream"));
	
	
	public ArrayList<String> getListOfAddIn(){
		return AddIns;
	}
	
	public void addAddIns(String addIn) {
		addedInList.add(addIn);
	}
	
	public ArrayList<String> getAddIns(){
		return addedInList;
	}
	public double itemPrice() {
		final double price  = getNumberOfCoffee() * (BASEPRICE + priceIncrease + (pricePerAddIn * addedInList.size()));
		return price;
	}

	public void setNumberOfCoffee( int numberofCoffee) {
		count = numberofCoffee;
	}
	public int getNumberOfCoffee() {
		return count;
	}
}
