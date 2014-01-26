package edu.rice.kwl2.drinktracker;
import java.util.ArrayList;
import org.joda.time.DateTime;
import org.joda.time.DateTime.Property;

public class Event {
	
	private Person drinker;
	private DateTime startTime;
	private DateTime endTime;
	private DateTime date;
	private ArrayList<Drink> drinksList;
	
	/**
	 * Creates a new drinking event.
	 */
	public Event (Person drinker, String startTime, DateTime date) {
		this.drinker = drinker;
		this.startTime = DateTime.now();
//		this.date = startTime.dayOfYear(); // error!
	}
	
	/**
	 * Adds a new drink to the queue.
	 */
	public void addDrink (Drink newDrink) {
		drinksList.add(newDrink);
	}
	
	public DateTime timeOfLastDrink() {
		return null;
	}
	
	public double calcBAC() {
		// TODO Kathy: Find number of since starting drinking and run other BAC function
		// double hoursSince = ;
		return calcBAC(hoursSince);
	}
	
	/*
	 * Given a number of hours in the future (or negative), calculates BAC
	 */
	public double calcBAC(double xHours) {
		// TODO Kathy: Get current time, set DP = num hours passed since startTime
		//DateTime timeNow = DateTime.now();
		double SD = getNumDrinks();
		double BW = drinker.getBodyWaterConstant();
		double Wt = drinker.getWeight();
		double MR = drinker.getMetabolism();
		//double DP = ;
		return ((.806 * SD * 1.2) / (BW * Wt)) - (MR * DP);
	}
	
	public double getNumDrinks {}

}
