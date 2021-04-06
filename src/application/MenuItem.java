package application;

import java.util.ArrayList;

public abstract class MenuItem implements Customizable{
	public abstract double itemPrice();
	public abstract String toString(int index);
	public abstract int getNumberItems();
	public abstract boolean remove(int index); 
}
