package application;

import java.util.ArrayList;
import java.util.Arrays;

public class CakeDonut extends DounteType{
	private final ArrayList<String> FLOWERS = new ArrayList<String>(Arrays.asList("e","f","g"));
	private final double PRICE = 1.59;
	
	CakeDonut(){
		pricePerDounter = PRICE;
	}
	
	@Override
	public ArrayList<String> getAllFlowers(){
		return FLOWERS;
	}
	
	@Override
	public String getDountName() {
		return "CakeDonut";
	}
}
