package edu.rice.kwl2.drinktracker;
import java.util.ArrayList;
import org.joda.time.*;

public class Event extends AEvent{
	
	private Person drinker;
	private DateTime startTime;
	private DateTime endTime;
	private DateTime date;
	private DateTime timeOfLastDrink;
	private ArrayList<IDrink> drinksList;
	private double numStandardDrinks;
	
	/**
	 * Creates a new drinking event.
	 */
	public Event (Person drinker) {
		this.drinker = drinker;
		this.startTime = DateTime.now();
		drinksList = new ArrayList<IDrink>();
//		this.date = startTime.dayOfYear(); // error!
	}
	
	/**
	 * Adds a new drink to the queue.
	 */
	public String addDrink (IDrink newDrink) {
		drinksList.add(newDrink);
		numStandardDrinks += newDrink.getNumStdDrinks();
		timeOfLastDrink = DateTime.now();
		return checkBAC(); 
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
		double BodyWeight = drinker.getBodyWaterConstant();
		double Wt = drinker.getWeight();
		double MR = drinker.getMetabolism();
		// calculate elapsed time as drinkingTime
		DateTime currTime = DateTime.now();
		Period DP = new Period(startTime, currTime);
		int hours = DP.getHours();
		int minutes = DP.getMinutes();
		double drinkingTime = (double) hours + ((double) minutes)/60;
		// BAC formula:
		return ((.806 * SD * 1.2) / (BodyWeight * Wt)) - (MR * drinkingTime);
	}
	
	public double getNumDrinks () {
		return numStandardDrinks;
	}
	
	/**
	 * Checks the current BAC and gives warnings if it's too high.
	 */
	public String checkBAC () {
		double BAC = getBAC();
		if (BAC >= 0.25)
			return raiseWarning(0);
		else if (BAC >= 0.2)
			return raiseWarning(1);
		else if (BAC >= 0.16)
			return raiseWarning(2);
		else if (BAC >= 0.12)
			return raiseWarning(3);
		else
			return raiseWarning(4);
	}
	
	public String raiseWarning(int alertLevel) {
		switch (alertLevel) {
			case 0: 
				return "Case 0 - Death";
			case 1:
				return "Case 1 - Almost Death";
			case 2:
				return "Case 2 - Super Sloppy";
			case 3:
				return "Case 3 - Schwasty-Schwaste";
			case 4:
				return "Case 4 - Drink more, biotch";
			default:
				return "You should never hit this one, something is wrong";
		}
	}
	
	public void endEvent() {
		endTime = DateTime.now();
	}

	@Override
	public String getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getTimeElapsed() {
		return 0d;
	}
	
	@Override
	public DateTime getStartTime() {
		return startTime;
	}

	@Override
	public String addDrink(String drinkType, double numStdDrinks) {
		Drink newDrink = new Drink(drinkType, numStdDrinks);
		return addDrink(newDrink);
	}
	

}
