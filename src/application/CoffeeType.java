package application;

import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeType {

	private static final double BASEPRICE = 1.99;
	protected double priceIncrease = 0.0;
	protected double pricePerAddIn = 0.20;
	private int count = 1;
	protected String sizeofCoffee = "";
	
	private ArrayList<String> addedInList = new ArrayList<String>();
	private final ArrayList<String> AddIns = new ArrayList<String>(Arrays.asList("Cream", "Syrup", "Milk", "Caramel", "Whipped Cream"));
	
	
	public ArrayList<String> getListOfAddIn(){
		return AddIns;
	}
	
	public boolean addAddIns(String addIn) {
		boolean ret = false;
		if (AddIns.contains(addIn)) {
			ret = addedInList.add(addIn);
		}
		return ret;
	}
	
	public boolean removeAddIns(String addIn) {
		boolean ret = false;
		if (AddIns.contains(addIn)) {
			ret = addedInList.remove(addIn);
		}
		return ret;
	}
	
	public void addAddIns(ArrayList<String> selectedAddIn) {
		for(int index = 0; index < selectedAddIn.size();index++ ) {
			addedInList.add(selectedAddIn.get(index));
		}
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
	public double getNumberOfCoffee() {
		return (double)count;
	}
	
	public String getSizeOfCoffee() {
		return sizeofCoffee;
	} 
}
