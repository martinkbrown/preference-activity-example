package edu.fsu.cs.mobile.example.preferenceactivity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

public class Preferences extends PreferenceActivity {

	CheckBoxPreference spamPref;
	EditTextPreference usernamePref;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    getFragmentManager().beginTransaction()
	    	.replace(android.R.id.content, new SpamPreferenceFragment())
	    	.commit();
	}
    
    public static class SpamPreferenceFragment extends PreferenceFragment 
    	implements OnSharedPreferenceChangeListener {
    	@Override
    	public void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		addPreferencesFromResource(R.xml.preferences);
    	}
    	
    	@Override
    	public void onResume() {
    		super.onResume();
    		updateSummaries();
    	}
    	
    	@Override
    	public void onPause() {
    		super.onPause();
    		updateSummaries();
    	}
    	
    	private void updateSummaries() {

    		getPreferenceScreen().findPreference("username").setSummary("Username currently set to " + 
    				((EditTextPreference)getPreferenceScreen().findPreference("username")).getText());
    		
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

        }
    	
    	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            updateSummaries();
        }
    }
}
