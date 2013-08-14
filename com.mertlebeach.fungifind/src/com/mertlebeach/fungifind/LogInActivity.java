package com.mertlebeach.fungifind;

import java.util.List;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class LogInActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);
		
		 
//	      ParseFacebookUtils.logIn(this, new LogInCallback() {
//	    	  @Override
//	    	  public void done(ParseUser user, ParseException err) {
//	    	    if (user == null) {
//	    	      Log.d("MyApp", "Uh oh. The user cancelled the Facebook login.");
//	    	    } else if (user.isNew()) {
//	    	      Log.d("MyApp", "User signed up and logged in through Facebook!");
//	    	    } else {
//	    	      Log.d("MyApp", "User logged in through Facebook!");
//	    	    }
//	    	  }
//	    	});
	      
	}
	
	
	/** Called when the user clicks the Send button */
	public void toCamara(View view) {
	    // Do something in response to button
		
		
		Intent intent = new Intent(this, CamaraActivity.class);
 	    startActivity(intent);
	}
	/** Called when the user clicks the Send button */
	public void toLogin(View view) {
	    // Do something in response to button
		ParseFacebookUtils.getSession().closeAndClearTokenInformation();
		ParseUser.logOut();
		Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
	}
	/** Called when the user clicks the Send button */
	public void toLeaderBoard(View view) {
	    // Do something in response to button
		
		
		Intent intent = new Intent(this, LeaderBoardActivity.class);
	    startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.log_in, menu);
		return true;
	}


}
