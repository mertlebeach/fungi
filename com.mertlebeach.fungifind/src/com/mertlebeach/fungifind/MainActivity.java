package com.mertlebeach.fungifind;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Parse.initialize(this, "f9nuFRqE5CjHeXL5DxtKourEaDLM62sDkiYGjLzV", "JSCyGA0ovUs894LhEnqEijDCZgK2kgezoWLghk4T");
	      ParseFacebookUtils.initialize("166475660199140");
	     
		
	    try {

	    PackageInfo info = getPackageManager().getPackageInfo(

	   "com.mertlebeach.fungifind",

	    PackageManager.GET_SIGNATURES);

	    for (Signature signature : info.signatures) {

	    MessageDigest md = MessageDigest.getInstance("SHA");

	    md.update(signature.toByteArray());

	    Log.d("KeyHash:", Base64.encodeToString(md.digest(),

	    Base64.DEFAULT));

	    }

	    } catch (NameNotFoundException e) {

	   //

	   } catch (NoSuchAlgorithmException e) {

	   //

	   }


	}
	
	
	/** Called when the user clicks the Send button */
	public void toLogIn(View view) {
	    // Do something in response to button
		  ParseFacebookUtils.logIn(this, new LogInCallback() {
	    	  @Override
	    	  public void done(ParseUser user, ParseException err) {
	    	    if (user == null) {
	    	      Log.d("MyApp", "Uh oh. The user cancelled the Facebook login.");
	    	    } else if (user.isNew()) {
	    	      Log.d("MyApp", "User signed up and logged in through Facebook!");
	    	      navigatetoLoggedIn();
	    	    } else {
	    	      Log.d("MyApp", "User logged in through Facebook!");
	    	      navigatetoLoggedIn();
	    	    }
	    	  }
	    	});
//		

	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		 ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	  super.onActivityResult(requestCode, resultCode, data);
	 
	}
	public void navigatetoLoggedIn()
	{
		Intent intent = new Intent(this, LogInActivity.class);
	    startActivity(intent);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
