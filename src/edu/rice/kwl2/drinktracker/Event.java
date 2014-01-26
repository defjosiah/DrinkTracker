package edu.rice.kwl2.drinktracker;
import java.util.ArrayList;

public class Event {
	
	private Person drinker;
	private DateTime startTime;
	private String date;
	private ArrayList<Drink> drinksList;
	
	public Event (Person drinker, String startTime, String date) {
		this.drinker = drinker;
		this.startTime = startTime;
		this.date = date;
	}
	
	public void addDrink (Drink newDrink) {
		drinksList.add(newDrink);
	}
	
	public double calcBAC() {
		DateTime timeNow = DateTime.now();
		return ((.806 * SD * 1.2) / (BW * Wt)) - (MR * DP);
	}
	
	/*
	 * Given a number of hours in the future (or negative), calculates BAC
	 */
	public double calcBAC(double xHours) {}

}
