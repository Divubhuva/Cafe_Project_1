package application;

import java.util.ArrayList;
import java.util.Arrays;

public class Donuthole extends DounteType{
	private final ArrayList<String> FLOWERS = new ArrayList<String>(Arrays.asList("h","i","j"));
	private final double PRICE = 0.33;
	
	Donuthole(){
		pricePerDounter = PRICE;
	}
	
	@Override
	public ArrayList<String> getAllFlowers(){
		return FLOWERS;
	}
	
	
}
