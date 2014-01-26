package edu.rice.kwl2.drinktracker;

interface IEvent {
	
	public double getNumDrinks();
	
	public String getDate();
	
	public String getStartTime();
	
	public double getBAC();
	
	/*
	 * Input: String: type of Drink
	 * 	      Double: number of Standard Drinks
	 * 
	 * Returns: String for the push notification
	 */
	public String addDrink(String drinkType, double numStdDrinks); 

}
