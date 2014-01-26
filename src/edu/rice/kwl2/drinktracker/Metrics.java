package edu.rice.kwl2.drinktracker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Metrics extends Activity {

	//Person person = MainActivity. import the existing person
	Person person = Person.getInstance(); //test person for now, implement the existing person
    @Override
    protected void onCreate(Bundle savedInstanceState) 
	{
    	super.onCreate(savedInstanceState);
	 	setContentView(R.layout.activity_metrics);    
	 	displayMetrics(); //fuck this code
	 	
	    //compsci majors pls finish 
	}
    
    public void displayMetrics()
    {	
    	final TextView currentBAC = (TextView)findViewById(R.id.textView2);
    	currentBAC.setText(String.valueOf(person.getCurrentEvent().getBAC()));
    	final TextView timeSince = (TextView)findViewById(R.id.textView5);
    	timeSince.setText(String.valueOf(person.getCurrentEvent().getTimeElapsed()));
    	final TextView shotCounter = (TextView)findViewById(R.id.textView10);
    	timeSince.setText("2"); //replace with shotCounter
    	final TextView wineCounter = (TextView)findViewById(R.id.textView11);
    	timeSince.setText("1"); //replace with shotCounter
    	final TextView beerCounter = (TextView)findViewById(R.id.textView12);
    	timeSince.setText("0"); //replace with shotCounter
    	final TextView punchCounter = (TextView)findViewById(R.id.textView13);
    	timeSince.setText("4"); //replace with shotCounter
    	
    }
    
    public void calcDesiredBAC()
    {
		EditText setDesiredBAC = (EditText)findViewById(R.id.editText1);
		//new activity telling time until desired BAC is reached
    }
      
}

