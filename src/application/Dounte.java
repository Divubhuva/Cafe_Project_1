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
	public boolean remove(int index) {
		boolean remove = false;
		if (dountList.isEmpty()) {
			return remove;
		}
		
		if(index >= 0 && index < dountList.size()) {
			DounteType order = dountList.get(index);
			remove = dountList.remove(order);
		}
		
        return remove;
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
	
	public int getNumberItems() {
		return dountList.size();
	}
	
	
//	@Override
//	public ArrayList<String> getOrderList(){
//		ArrayList<String> ret = new ArrayList<String>();
//		
//		if (dountList.isEmpty()) {
//			return ret;
//		}
//		
//		for (int index = 0; index  < dountList.size(); ++index) {
//			DounteType currentDount = dountList.get(index);
//			String infoString = currentDount.getDountName() +" [ "+currentDount.getFlower() +" ] [ "+currentDount.getNumberOfDounte()+" ]";
//			ret.add(infoString);
//		}
//		
//		return ret;
//	}
	
	@Override
	public String toString(int index) {
		String  ret = "";
		if (dountList.isEmpty()) {
			return ret;
		}
		
		if(index >= 0 && index < dountList.size()) {
			DounteType currentDount = dountList.get(index);
			ret = currentDount.getDountName() +" [ "+currentDount.getFlower() +" ] [ "+currentDount.getNumberOfDounte()+" ]";
		}
		return ret;
		
	}
}
