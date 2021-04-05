package application;

import java.util.ArrayList;

public class StoreOrder implements Customizable{

	ArrayList<CurrentOrder> orderList = new ArrayList<CurrentOrder>();
	
	
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
        
		if (index >= 0  && index < orderList.size()) {
			orderList.remove(index);
		}
        return false;
	}
	
	public CurrentOrder getOrderInfo(int index) {
		CurrentOrder order = null;
		if (index >= 0  && index < orderList.size()) {
			order = orderList.get(index);
		}
        return order;
	}
	
	public int getTotalNumberOfOrder() {
		return orderList.size();
	}
}
