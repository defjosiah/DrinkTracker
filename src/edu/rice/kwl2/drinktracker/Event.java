package edu.rice.kwl2.drinktracker;
import java.util.ArrayList;
import org.joda.time.*;
import org.joda.time.DateTime.Property;

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
	public Event (Person drinker, DateTime date) {
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
	
	/**
	 * Gets current blood alcohol content.
	 */
	public double getBAC() {
		return getBAC(0.0);
	}
	
	/*
	 * Given a number of hours in the future, calculates BAC
	 */
	public double getBAC(double xHours) {
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
		// BAC formula:
		return ((.806 * SD * 1.2) / (BW * Wt)) - (MR * drinkingTime);
	}
	
	public double getNumDrinks () {
		return numStandardDrinks;
	}
	
	/**
	 * Checks the current BAC and gives warnings if it's too high.
	 */
	public void checkBAC () {
		double BAC = getBAC();
		if (BAC >= 0.25)
			raiseWarning(0);
		else if (BAC >= 0.2)
			raiseWarning(1);
		else if (BAC >= 0.16)
			raiseWarning(2);
		else if (BAC >= 0.12)
			raiseWarning(3);
	}
	
	public void raiseWarning(int alertLevel) {
		switch (alertLevel) {
			case 0: 
				;
				break;
			case 1:
				;
				break;
			case 2:
				;
				break;
			case 3:
				;
				break;
		}
	}
	
	public void endEvent() {
		endTime = DateTime.now();
	}
	

}
