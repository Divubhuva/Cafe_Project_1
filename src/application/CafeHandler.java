package application;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;



public class CafeHandler {
	
	private HashMap<String, DounteType> availableDounts = new HashMap<String, DounteType>();
	private HashMap<String, CoffeeType> availableSizeOfCoffee = new HashMap<String, CoffeeType>();
    private static final int MAXDONUTCOUNT = 100;
	
    private Dounte donutHandler = new Dounte();
    private CurrentOrder currentOrder = new CurrentOrder();
    private Coffee coffeeHandler  = new Coffee();
    private CoffeeType brewedCoffee = null;
    
    public String getTwoUpToTwoDecimalPoint(double val)
    {
        DecimalFormat df2 = new DecimalFormat("###,###,##0.00");
        return df2.format(val);
    }
    
    public  CafeHandler(){
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
		return donutHandler.add(dounte);
	}
	
	public boolean removeDounteFromList(int index) {
		DounteType dounte = donutHandler.getItem(index);
		return donutHandler.remove(dounte);
	}
	
	public String getTotalPriceForDonut() {
		return getTwoUpToTwoDecimalPoint(donutHandler.itemPrice());
	}
	
	public int getNumberOfOrderDonuts() {
		return donutHandler.getTotalNumberOfDonutInList();
	}
	
	public boolean addToDonutsOrder() {
		boolean added = false;
		
		if (donutHandler.getTotalNumberOfDonutInList() == 0) {
			return added;
		}
		
		added = currentOrder.add(donutHandler);
		if (added) {
			donutHandler = new Dounte();
		}
		return added;
	}
	
	public ArrayList<String>  getTypesOfCoffeeSize() {
		ArrayList<String> ret = new ArrayList<String>();
		ret.addAll(availableSizeOfCoffee.keySet());
		return ret;
	}
	
	public boolean selectSizeOfCoffee(String size, ArrayList<String> selectedAddIn, int count) {
		
		brewedCoffee = null;
		if (size.compareTo( new CoffeeShort().getSizeOfCoffee()) == 0) {
			brewedCoffee = new CoffeeShort();
		}
		else if (size.compareTo( new CoffeeTall().getSizeOfCoffee()) == 0) {
			brewedCoffee = new CoffeeTall();
		}
		else if (size.compareTo( new CoffeeGrande().getSizeOfCoffee()) == 0) {
			brewedCoffee = new CoffeeGrande();
		}
		else if (size.compareTo( new CoffeeVenti().getSizeOfCoffee()) == 0) {
			brewedCoffee = new CoffeeVenti();
		}
		
		if ( brewedCoffee == null) {
			return false;
		}
		else {
			brewedCoffee.addAddIns(selectedAddIn);
			brewedCoffee.setNumberOfCoffee(count);
		}
		
		return true;
	}
	
	
	public boolean addAddIn(String addIn) {
		if (brewedCoffee == null) {
			return false;
		}
		return brewedCoffee.addAddIns(addIn);
	}
	public boolean removeAddIn(String addIn) {
		if (brewedCoffee == null) {
			return false;
		}
		return brewedCoffee.removeAddIns(addIn);
	}
	
	public boolean setNumberOfCoffee(int numberOFCoffee) {
		if (brewedCoffee == null) {
			return false;
		}
		brewedCoffee.setNumberOfCoffee(numberOFCoffee);
		return true;
	}
	
	public String getCoffeePrice() {
		double ret = 0.0;
		if (brewedCoffee != null) {
			ret = brewedCoffee.itemPrice();
		}
		return getTwoUpToTwoDecimalPoint(ret);
	}
	
	public boolean addToCoffeeOrder() {
		boolean added = false;
		if (brewedCoffee == null) {
			return added;
		}
		coffeeHandler.add(brewedCoffee);
		
		added = currentOrder.add(coffeeHandler);
		if (added) {
			brewedCoffee = null;
			coffeeHandler =  new Coffee();
		}
		return added;
	}
	
	public String getCurrentOderTotal() {
		return getTwoUpToTwoDecimalPoint(currentOrder.getTotalPrice());
	}
	
	public String getCurrentOrderSalesTax() {
		return getTwoUpToTwoDecimalPoint(currentOrder.getSalesTax());
	}
	
	public String getCurrentOderSubTotal() {
		return getTwoUpToTwoDecimalPoint(currentOrder.getSubTotal());
	}
	
	public ArrayList<String> getCurrentOrderList(){
		return currentOrder.getOrderList();
	}
}
