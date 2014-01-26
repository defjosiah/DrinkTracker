package edu.rice.kwl2.drinktracker;
import java.util.ArrayList;
import org.joda.time.DateTime;
import org.joda.time.DateTime.Property;
import org.joda.time.Interval;
import org.joda.time.*;

public class Event {
	
	private Person drinker;
	private DateTime startTime;
	private DateTime endTime;
	private DateTime date;
	private DateTime timeOfLastDrink;
	private ArrayList<Drink> drinksList;
	private double numStandardDrinks;
	
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
		numStandardDrinks += newDrink.getNumStdDrinks();
		timeOfLastDrink = DateTime.now();
	}
	
	public DateTime timeOfLastDrink() {
		return timeOfLastDrink;
	}
	
	public double calcBAC() {
		return calcBAC(0.0);
	}
	
	/*
	 * Given a number of hours in the future, calculates BAC
	 */
	public double calcBAC(double xHours) {
		double SD = getNumDrinks();
		double BW = drinker.getBodyWaterConstant();
		double Wt = drinker.getWeight();
		double MR = drinker.getMetabolism();
		// calculate elapsed time as drinkingTime
		DateTime currTime = DateTime.now();
		Period DP = new Period(startTime, currTime);
		int hours = DP.getHours();
		int minutes = DP.getMinutes();
		double drinkingTime = (double) hours + ((double) minutes)/60;
		return ((.806 * SD * 1.2) / (BW * Wt)) - (MR * drinkingTime);
	}
	
	public double getNumDrinks () {
		return numStandardDrinks;
	}
	
	

}
