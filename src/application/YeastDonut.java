package application;

import java.util.ArrayList;
import java.util.Arrays;

public class YeastDonut extends DounteType{
	
	private final ArrayList<String> FLOWERS = new ArrayList<String>(Arrays.asList("Jelly","Berry Blast","Blueberry Filled"));
	private final double PRICE = 1.39;
	
	YeastDonut(){
		pricePerDounter = PRICE;
	}

	@Override
	public ArrayList<String> getAllFlowers(){
		return FLOWERS;
	}
	
	@Override
	public String getDountName() {
		return "YeastDonut";
	}

}
