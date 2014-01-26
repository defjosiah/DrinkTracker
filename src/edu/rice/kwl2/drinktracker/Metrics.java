package edu.rice.kwl2.drinktracker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Metrics extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_metrics);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.metrics, menu);
		return true;
	}

}
