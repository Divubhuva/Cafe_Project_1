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
	public Double itemPrice() {
		Double price = 0.0;
		if(dountList.isEmpty()) {
			return price;
		}
		
		for (int index = 0; index < dountList.size();++index) {
			price += dountList.get(index).itemPrice();
		}
		return price;
	}

}
