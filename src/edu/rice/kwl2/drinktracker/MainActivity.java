package edu.rice.kwl2.drinktracker;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.view.MenuInflater;
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
    	
    	person = new Person(name, weight, height, gender);
    	
    
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
   
    
    // push notifications require registration; we can potentially deal with this later
//    /**
//     * Send push notifications with BAC-related warnings
//     */
//    @SuppressWarnings("deprecation")
//	public void pushNotification() {
//    	String title = "title", subject = "subject", body = "body";
//    	
//    	NotificationManager NM;
//    	NM = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//    	
//    	Notification notify = new Notification(android.R.drawable.stat_notify_more, title ,System.currentTimeMillis());
//    
//    	PendingIntent pending = PendingIntent.getActivity(getApplicationContext(), 0, new Intent(),0);
//    	notify.setLatestEventInfo(getApplicationContext(), subject, body,pending);
//    	NM.notify(0, notify);
//    }
    
}
