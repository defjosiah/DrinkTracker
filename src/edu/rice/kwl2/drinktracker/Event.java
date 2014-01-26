package edu.rice.kwl2.drinktracker;
import java.util.ArrayList;
import org.joda.time.DateTime;
import org.joda.time.DateTime.Property;

public class Event {
	
	private Person drinker;
	private DateTime startTime;
	private DateTime date;
	private ArrayList<Drink> drinksList;
	
	public Event (Person drinker, String startTime, DateTime date) {
		this.drinker = drinker;
		this.startTime = DateTime.now();
//		this.date = startTime.dayOfYear(); // error!
	}
	
	public void addDrink (Drink newDrink) {
		drinksList.add(newDrink);
	}
	
	public DateTime timeOfLastDrink() {
		return null;
	}
	
	public double calcBAC() {
		DateTime timeNow = DateTime.now();
		Wt = getTheWight();
		return ((.806 * SD * 1.2) / (BW * Wt)) - (MR * DP);
	}
	
	/*
	 * Given a number of hours in the future (or negative), calculates BAC
	 */
	public double calcBAC(double xHours) {}

}
