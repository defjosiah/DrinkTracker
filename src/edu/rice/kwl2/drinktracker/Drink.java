package edu.rice.kwl2.drinktracker;

//import java.util.Date;
import org.joda.time.DateTime;

public class Drink extends ADrink {

	private String drinkType;
	private DateTime time;
	private double volumeOz = 1;
	private double percentAlc = 0.12;
	private double numStdDrinks = 1;
	
	/**
	 * Constructs a drink.
	 */
	public Drink (String drinkType, double numStdDrinks, DateTime time) {
		this.drinkType = drinkType;
		this.numStdDrinks = numStdDrinks;
		this.time = time;
		time = DateTime.now();
	}
	
	@Override
	public IDrink getDrinkType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getNumStdDrinks() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
