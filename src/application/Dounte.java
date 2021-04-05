package application;

import java.util.ArrayList;

public class Dounte extends MenuItem {

	ArrayList<DounteType> dountList = new ArrayList<DounteType>();
	
	@Override
	public boolean add(Object obj) {
		
		if(!(obj instanceof DounteType))
        {
            return false;
        }
		DounteType order = (DounteType) obj;
        return dountList.add(order);
	}

	@Override
	public boolean remove(Object obj) {
		
		if(!(obj instanceof DounteType))
        {
            return false;
        }
		DounteType order = (DounteType) obj;
        return dountList.remove(order);
	}

	@Override
	public double itemPrice() {
		double price = 0.0;
		if(dountList.isEmpty()) {
			return price;
		}
		
		for (int index = 0; index < dountList.size();++index) {
			price += dountList.get(index).itemPrice();
		}
		return price;
	}
	
	
	public DounteType getItem(int index) {
		DounteType ret = null;
		if(index >= 0  && index <dountList.size() ) {
			ret = dountList.get(index);
		}
		return ret;
	}
	
	public int getTotalNumberOfDonutInList() {
		return dountList.size();
	}
	
	
	@Override
	public ArrayList<String> getOrderList(){
		ArrayList<String> ret = new ArrayList<String>();
		
		if (dountList.isEmpty()) {
			return ret;
		}
		
		for (int index = 0; index  < dountList.size(); ++index) {
			DounteType currentDount = dountList.get(index);
			String infoString = currentDount.getDountName() +" [ "+currentDount.getFlower() +" ] [ "+currentDount.getNumberOfDounte()+" ]";
			ret.add(infoString);
		}
		
		return ret;
	}
}
