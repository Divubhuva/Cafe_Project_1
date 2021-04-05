package application;

import java.util.ArrayList;

public class CurrentOrder implements Customizable {

	private final Double SALESTAX = 6.625;
	private final Double RESPECTTO = 100.00;
	
	ArrayList<MenuItem> orderItems = new ArrayList<MenuItem>();
	
	@Override
	public boolean add(Object obj) {
		if(!(obj instanceof MenuItem))
        {
            return false;
        }
		MenuItem items = (MenuItem) obj;
		
		return orderItems.add(items);
	}

	@Override
	public boolean remove(Object obj) {
		if(!(obj instanceof CurrentOrder))
        {
            return false;
        }
		MenuItem items = (MenuItem) obj;
        return orderItems.remove(items);
	}
	
	public Double getSubTotal() {
		Double ret = 0.0;
		
		if (orderItems.isEmpty()) {
			return ret;
		}
		
		for(int index = 0; index <orderItems.size();index++) {
			ret += orderItems.get(index).itemPrice();
		}
		return ret;
	}
	
	public Double getSalesTax() {
		Double taxAmount = ((getSubTotal()/RESPECTTO) * SALESTAX);  
		return taxAmount;
	}

	public Double getTotalPrice() {
		Double totalPrice = getSubTotal() + getSalesTax();
		return totalPrice;
	}
}
