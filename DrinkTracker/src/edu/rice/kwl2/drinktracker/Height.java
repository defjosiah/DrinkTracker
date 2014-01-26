package edu.rice.kwl2.drinktracker;

public class Height {
	
	private int feet;
	private int inches;
	
	public Height(int feet, int inches) {
		 
		this.feet = feet;
		this.inches = inches;
		
	}
	
	public Height(double cm) {
		
		inches = (int) Math.round((cm * .393701) % 12);
		feet = inches / 12;
			
	}
	
	public int getFt() {
		return feet;
	}
	
	public int getIn() {
		return inches;
	}
	
	

}
