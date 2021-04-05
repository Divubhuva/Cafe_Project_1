package application;

import java.util.ArrayList;

public class Coffee extends MenuItem{

	ArrayList<CoffeeType> coffeeList = new ArrayList<CoffeeType>();
	
	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double itemPrice() {
		double ret = 0.0;
		if (coffeeList.isEmpty()) {
			return ret;
		}
		
		for (int index = 0; index  < coffeeList.size(); ++index) {
			ret += coffeeList.get(index).itemPrice();
		}
		
		return ret;
	}

	

}
