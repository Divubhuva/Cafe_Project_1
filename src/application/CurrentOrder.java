package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CurrentOrder implements Customizable {

	private final double SALESTAX = 6.625;
	private final double RESPECTTO = 100.00;
	
	
	private ObservableList<MenuItem> orderItems = FXCollections.observableArrayList(); 
	
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
		if(!(obj instanceof MenuItem))
        {
            return false;
        }
		MenuItem items = (MenuItem) obj;
        return orderItems.remove(items);
	}
	
	public double getSubTotal() {
		double ret = 0.0;
		
		if (orderItems.isEmpty()) {
			return ret;
		}
		
		for(int index = 0; index <orderItems.size();index++) {
			ret += orderItems.get(index).itemPrice();
		}
		return ret;
	}
	
	public double getSalesTax() {
		double taxAmount = ((getSubTotal()/RESPECTTO) * SALESTAX);  
		return taxAmount;
	}

	public double getTotalPrice() {
		double totalPrice = getSubTotal() + getSalesTax();
		return totalPrice;
	}
	

	public ObservableList<MenuItem> getObserveOrderList(){
		return orderItems;
	}
}
