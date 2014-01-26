package edu.rice.kwl2.drinktracker;

import org.joda.time.DateTime;

interface IEvent {
	
	public double getNumDrinks();
	
	public String getDate();
	
	public DateTime getStartTime();
	
	public double getBAC();
	
	/*
	 * Input: String: type of Drink
	 * 	      Double: number of Standard Drinks
	 * 
	 * Returns: String for the push notification
	 */
	public String addDrink(String drinkType, double numStdDrinks); 

}
