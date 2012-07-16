package edu.fsu.cs.mobile.example.preferenceactivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SecurityPreferences extends PreferenceActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    addPreferencesFromResource(R.xml.other_prefs);
	}

}
