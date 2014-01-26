package edu.rice.kwl2.drinktracker;

interface IPerson {
	
	public String getName();

	public void setName(String name);
	
	public double getWeight();
	
	public void setWeight(double weight);
	
	public void setHeight(int feet, int inches);
	
	public Height getHeight();

}
