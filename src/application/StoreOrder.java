package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StoreOrder implements Customizable{

	private static int PLACEORDER = 0;
	ObservableList<CurrentOrder> orderList = FXCollections.observableArrayList();
	 
	
	@Override
	public boolean add(Object obj) {
		
        if(!(obj instanceof CurrentOrder))
        {
            return false;
        }
        CurrentOrder order = (CurrentOrder) obj;
        
		return orderList.add(order);
	}

	@Override
	public boolean remove(Object obj) {
        if(!(obj instanceof CurrentOrder))
        {
            return false;
        }
        CurrentOrder order = (CurrentOrder) obj;
        
        return orderList.remove(order);
	}
	
	public boolean remove(int index) {
		boolean remove = false;
		if (orderList.isEmpty()) {
			return remove;
		}
		
		if(index >= 0 && index < orderList.size()) {
			CurrentOrder order = orderList.get(index);
			remove = remove(order);
		}
		
        return remove;
	}

	public ObservableList<CurrentOrder> getObserveOrderList(){
		return orderList;
	}
	
	public int generateOrderNumber() {
		PLACEORDER++;
		return PLACEORDER;
	}
	
	public String exportDatabase() {
    	String exportString = "";
    	
    	if (orderList.isEmpty()) {
    		return exportString;
    	}
    	
    	for (int index = 0;index < orderList.size();index++ ) {
    	
    		CurrentOrder order = orderList.get(index);
    	    ObservableList<MenuItem> orderItems = order.getObserveOrderList();
		
		    if (orderItems.isEmpty()) {
			    continue;
		    }
		    
		   DecimalFormat df2 = new DecimalFormat("###,###,##0.00");
		   exportString += "Order Number " + order.getUniqueOrderNumber() +"\n";
		   exportString += "Total Cost $" + df2.format(order.getTotalPrice()) +"\n";
		   
		   for(int orderindex = 0; orderindex < orderItems.size();orderindex++) {
			   MenuItem Items  = orderItems.get(orderindex);
			    for(int itemIndex = 0; itemIndex < Items.getNumberItems();itemIndex++) {
			    	exportString += "\t"+Items.toString(itemIndex) +"\n";
			    }
		    }
		   
		   exportString += "\n";
    	}
    	return exportString;
    }
}
