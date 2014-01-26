package edu.rice.kwl2.drinktracker;

interface IPerson {
	
	public String getName();

	public void setName(String name);
	
	public double getWeight();
	
	public void setWeight(double weight);
	
	public Height getHeight();
	
	public void setHeight(int feet, int inches);
	
	public String getGender();
	
	public void setGender(String gender);
	
	public double getBodyWaterConstant();
	
	public double getMetabolism ();
	
	public IEvent getCurrentEvent();

}
