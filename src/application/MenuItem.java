package application;

import java.util.ArrayList;

public abstract class MenuItem implements Customizable{
	public abstract double itemPrice();
	public abstract ArrayList<String> getOrderList();
}
