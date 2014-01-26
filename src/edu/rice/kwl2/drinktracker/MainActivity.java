package edu.rice.kwl2.drinktracker;

import android.os.Bundle;
import android.app.ActionBar;
import android.view.MenuInflater;
import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) { //main function
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //for the options menu in the corner
        // Inflate the menu; this adds items to the action bar if it is present.
    	getActionBar().setDisplayShowTitleEnabled(false);
    	getMenuInflater().inflate(R.menu.main, menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    public void sendBeer(View view) { //test to see if button pushes register
        System.out.println("Beer added");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }
    
}
