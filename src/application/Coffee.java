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
	public boolean remove(int index) {
		boolean remove = false;
		if (coffeeList.isEmpty()) {
			return remove;
		}
		
		if(index >= 0 && index < coffeeList.size()) {
			CoffeeType order = coffeeList.get(index);
			remove = coffeeList.remove(order);
		}
		
        return remove;
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

	@Override
	public int getNumberItems() {
		return coffeeList.size();
	}
	
//	@Override
//	public ArrayList<String> getOrderList(){
//		ArrayList<String> ret = new ArrayList<String>();
//		
//		if (coffeeList.isEmpty()) {
//			return ret;
//		}
//		
//		for (int index = 0; index  < coffeeList.size(); ++index) {
//			CoffeeType obj = coffeeList.get(index);
//			String infoString = obj.getSizeOfCoffee() +"Coffee [ ";
//			for(int addInIndex = 0; addInIndex < obj.getAddIns().size(); ++addInIndex) {
//				infoString += obj.getAddIns().get(addInIndex);
//				if(addInIndex != (obj.getAddIns().size()-1)) {
//					infoString += "::";
//				}
//			}
//			infoString += " ] ";
//			infoString += "[ "+obj.getNumberOfCoffee()+" ]";
//			ret.add(infoString);
//		}
//		
//		return ret;
//	}
	
	@Override
	public String toString(int index) {
		String  ret = "";
		if (coffeeList.isEmpty()) {
			return ret;
		}
		
		if(index >= 0 && index < coffeeList.size()) {
			CoffeeType obj = coffeeList.get(index);
			ret = obj.getSizeOfCoffee() +"Coffee [ ";
			for(int addInIndex = 0; addInIndex < obj.getAddIns().size(); ++addInIndex) {
				ret += obj.getAddIns().get(addInIndex);
				if(addInIndex != (obj.getAddIns().size()-1)) {
					ret += "::";
				}
			}
			ret += " ] ";
			ret += "[ "+obj.getNumberOfCoffee()+" ]";
		}
		return ret;
	}
}
