package application;

import java.util.ArrayList;
import java.util.HashMap;



public class CafeHandler {
	
	private HashMap<String, DounteType> availableDounts = new HashMap<String, DounteType>();
	private HashMap<String, CoffeeType> availableSizeOfCoffee = new HashMap<String, CoffeeType>();
    private static final int MAXDONUTCOUNT = 100;
	
	CafeHandler(){
		availableDounts.put(new CakeDonut().getDountName(), new CakeDonut());
		availableDounts.put(new YeastDonut().getDountName(), new YeastDonut());
		availableDounts.put(new Donuthole().getDountName(), new Donuthole());
		
		availableSizeOfCoffee.put(new CoffeeShort().getSizeOfCoffee(), new CoffeeShort());
		availableSizeOfCoffee.put(new CoffeeTall().getSizeOfCoffee(), new CoffeeTall());
		availableSizeOfCoffee.put(new CoffeeGrande().getSizeOfCoffee(), new CoffeeGrande());
		availableSizeOfCoffee.put(new CoffeeVenti().getSizeOfCoffee(), new CoffeeVenti());
		
		
	}
	
	public ArrayList<String>  getTypesOfDounts() {
		ArrayList<String> ret = new ArrayList<String>();
		ret.addAll(availableDounts.keySet());
		return ret;
	}
	
	public ArrayList<String>  getDountsFlavor(String SelectedType) {
		ArrayList<String> ret = new ArrayList<String>();
		ret.addAll(availableDounts.get(SelectedType).getAllFlowers());
		return ret;
	}
	
	public int getMaxDocuntCount() {
		return MAXDONUTCOUNT;
	}
}
