package edu.rice.kwl2.drinktracker;

interface IPerson {
	
	public String getName();

	public void setName(String name);
	
	public double getWeight();
	
	public void setWeight(double weight);
	
	public Height getHeight();
	
	public void setHeight(int feet, int inches);
	
	public String getGender();
	
	public void setGender();
	
	public double getBodyWaterConstant();
	
	public double getMetabolism ();
	
<<<<<<< HEAD
	public Event getCurrentEvent();
=======
	public IEvent getCurrentEvent();
>>>>>>> caeb444abc6bbd4284de69cc0cc871af45af8d38

}
