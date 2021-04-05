package application;

import java.util.ArrayList;
import java.util.HashMap;



public class CafeHandler {
	
	private HashMap<String, DounteType> availableDounts = new HashMap<String, DounteType>();
	private HashMap<String, CoffeeType> availableSizeOfCoffee = new HashMap<String, CoffeeType>();
    private static final int MAXDONUTCOUNT = 100;
	
    private Dounte donuteHandler = new Dounte();
    private CurrentOrder currentOrder = new CurrentOrder();
    private Coffee coffeeHandler  = new Coffee();
    private CoffeeType brewedCoffee = new CoffeeType();
    
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
	
	public int getMaxCount() {
		return MAXDONUTCOUNT;
	}
	
	public boolean addDounteToList(String dounteType, String flowerName, int count) {
		DounteType dounte = null;
		
		if (dounteType.compareTo( new CakeDonut().getDountName()) == 0) {
			dounte = new CakeDonut();
		}
		else if (dounteType.compareTo( new Donuthole().getDountName()) == 0) {
			dounte = new Donuthole();
		}
		else if (dounteType.compareTo( new YeastDonut().getDountName()) == 0) {
			dounte = new YeastDonut();
		}
		
		if ( dounte == null) {
			return false;
		}
		
		dounte.setFlower(flowerName);
		dounte.setNumberOfDounte(count);
		return donuteHandler.add(dounte);
	}
	
	public boolean removeDounteFromList(int index) {
		DounteType dounte = donuteHandler.getItem(index);
		return donuteHandler.remove(dounte);
	}
	
	public double getTotalPriceForDonut() {
		return donuteHandler.itemPrice();
	}
	
	public double getNumberOfOrderDonuts() {
		return donuteHandler.getTotalNumberOfDonutInList();
	}
	
	public boolean addToDonutsOrder() {
		boolean added = false;
		
		if (donuteHandler.getTotalNumberOfDonutInList() == 0) {
			return added;
		}
		
		added = currentOrder.add(donuteHandler);
		if (added) {
			donuteHandler = new Dounte();
		}
		return added;
	}
	
	public ArrayList<String>  getTypesOfCoffeeSize() {
		ArrayList<String> ret = new ArrayList<String>();
		ret.addAll(availableSizeOfCoffee.keySet());
		return ret;
	}
}
