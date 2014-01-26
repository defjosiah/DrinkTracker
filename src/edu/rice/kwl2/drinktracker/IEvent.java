package edu.rice.kwl2.drinktracker;

interface IEvent {
	
	public int getNumDrinks();
	
	public String getDate();
	
	public String getStartTime();
	
	public double getBAC();
	
	/*
	 * Input: 
	 */
	public String addDrink(String drinkType, double numStdDrinks); 

}
