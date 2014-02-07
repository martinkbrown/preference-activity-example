package edu.fsu.cs.mobile.example.preferenceactivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

public class SecurityPreferences extends PreferenceActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    getFragmentManager().beginTransaction()
	    	.replace(android.R.id.content, new SecurityPreferenceFragment())
	    	.commit();
	}
	
	public static class SecurityPreferenceFragment extends PreferenceFragment {
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.other_prefs);
		}
	}
}
