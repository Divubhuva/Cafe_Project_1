package application;

import java.util.ArrayList;

public class Coffee extends MenuItem{

	ArrayList<CoffeeType> coffeeList = new ArrayList<CoffeeType>();
	
	@Override
	public boolean add(Object obj) {
		if(!(obj instanceof CoffeeType))
        {
            return false;
        }
		CoffeeType order = (CoffeeType) obj;
        return coffeeList.add(order);
	}

	@Override
	public boolean remove(Object obj) {
		if(!(obj instanceof CoffeeType))
        {
            return false;
        }
		CoffeeType order = (CoffeeType) obj;
        return coffeeList.remove(order);
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
