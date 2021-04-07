package application;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Order implements Customizable {

	private final double SALESTAX = 6.625;
	private final double RESPECTTO = 100.00;
	private ObservableList<MenuItem> orderItems = FXCollections.observableArrayList(); 
	private int orderNumber = -1;
	
	public Order() {
		
	}
	
	public Order(Order src, int orderNumber) {
		this.orderItems.addAll(src.orderItems);
		this.orderNumber = orderNumber;
	}
	
	public int getUniqueOrderNumber() {
		return orderNumber;
	}
	
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
