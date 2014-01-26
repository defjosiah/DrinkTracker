package edu.rice.kwl2.drinktracker;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	private IPerson person;

	public final static String PERSON_NAME = "edu.rice.kwl2.drinktracker";

	boolean personExists=false; //set whether or not a person has been made

	@Override
	protected void onCreate(Bundle savedInstanceState) { //main function
		super.onCreate(savedInstanceState);
		if(!personExists)
		{
			setContentView(R.layout.make_a_person);
		}
		else setContentView(R.layout.activity_main);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) { //for the options menu in the corner
		// Inflate the menu; this adds items to the action bar if it is present.
		getActionBar().setDisplayShowTitleEnabled(false); //hide "DrinkTracker"
		getActionBar().setDisplayShowHomeEnabled(false); //hide icon
		getMenuInflater().inflate(R.menu.main, menu);
		MenuInflater inflater = getMenuInflater(); //used for action bar buttons
		inflater.inflate(R.menu.main_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	/* After OK is hit it will create the Person */
	public void createPerson(View view) {
		EditText myEditName = (EditText)findViewById(R.id.editText1);
		String name = myEditName.getText().toString();

		ToggleButton myGender = (ToggleButton)findViewById(R.id.toggleButton1);
		boolean female = myGender.isChecked(); 
		String gender;
		if (female) {
			gender = "Female";
		} else {
			gender = "Male";
		}

		EditText myFeet = (EditText)findViewById(R.id.editText3);
		EditText myInch = (EditText)findViewById(R.id.editText4);
		int feet = Integer.parseInt(myFeet.getText().toString());
		int inch = Integer.parseInt(myInch.getText().toString());
		Height height = new Height(feet,inch);

		EditText myWeight = (EditText)findViewById(R.id.editText2);
		int weight = Integer.valueOf(myWeight.getText().toString());

		
		if(!personExists){
			
			person = new Person(name, weight, height, gender);

			personExists = true;
			
			setContentView(R.layout.activity_main);
		}else{
			if(!name.equals(person.getName()))
				person.setName(name);
			else if(height.getFt() != person.getHeight().getFt())
				person.setHeight(height.getFt(), person.getHeight().getIn());
			else if(height.getIn() != person.getHeight().getIn())
				person.setHeight(person.getHeight().getFt(), height.getIn());
			else if(weight != person.getWeight())
				person.setWeight(weight);
			else if(!gender.equals(person.getGender()))
				person.setGender(gender);
				
			setContentView(R.layout.activity_main);
			TextView textView = (TextView) findViewById(R.id.textView1);
			textView.setText("" + person.getCurrentEvent().getNumDrinks());
		}
		
		
	}

	//Below are methods that would update the number of drinks when buttons are pushed
	public void updateNumDrinksBeer(View view){
		person.getCurrentEvent().addDrink("Beer", 1.0);
		TextView textView = (TextView) findViewById(R.id.textView1);
		textView.setText("" + person.getCurrentEvent().getNumDrinks());
	}

	public void updateNumDrinksShot(View view){
		person.getCurrentEvent().addDrink("Shot", 1.0);
		TextView textView = (TextView) findViewById(R.id.textView1);
		textView.setText("" + person.getCurrentEvent().getNumDrinks());
	}

	public void updateNumDrinksCup(View view){
		person.getCurrentEvent().addDrink("Jungle", 1.5);
		TextView textView = (TextView) findViewById(R.id.textView1);
		textView.setText("" + person.getCurrentEvent().getNumDrinks());
	}

	public void updateNumDrinksWine(View view){
		person.getCurrentEvent().addDrink("Wine", 1.0);
		TextView textView = (TextView) findViewById(R.id.textView1);
		textView.setText(""+person.getCurrentEvent().getNumDrinks());
	}

	/*
	 * When the user touch the setting it shows the profile
	 */
	public boolean onOptionsItemSelected(MenuItem item){
		setContentView(R.layout.make_a_person);
		
		EditText name = (EditText) findViewById(R.id.editText1);
		name.setText(person.getName());
		EditText feet = (EditText) findViewById(R.id.editText3);
		feet.setText(""+person.getHeight().getFt());
		EditText inch = (EditText) findViewById(R.id.editText4);
		inch.setText(""+person.getHeight().getIn());
		EditText weight = (EditText) findViewById(R.id.editText2);
		weight.setText(""+person.getWeight());
		ToggleButton gender = (ToggleButton)findViewById(R.id.toggleButton1);
		if(person.getGender() == "Female"){
			gender.setChecked(true);
		}else{
			gender.setChecked(false);
		}
	
		 return super.onOptionsItemSelected(item);
	}
}
