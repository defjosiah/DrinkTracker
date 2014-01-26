package edu.rice.kwl2.drinktracker;

public class Person {
	
	private String name;
	private double weight;
	private Height height;
	private String gender;
	
	Person(String name, double weight, Height height, String gender) {
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Height getHeight() {
		return height;
	}

	public void setHeight(Height height) {
		this.height = height;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public double getBodyWaterConstant () {
		if (gender == "Female") {
			return .49;
		} else {
			return .58;
		}
	}
	
	public double getMetabolism () {
		if (gender == "Female") {
			return .017;
		} else {
			return .015;
		}
	}
}
