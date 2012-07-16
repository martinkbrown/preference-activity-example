package edu.fsu.cs.mobile.example.preferenceactivity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;

public class Preferences extends PreferenceActivity implements OnSharedPreferenceChangeListener{

	CheckBoxPreference spamPref;
	EditTextPreference usernamePref;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    addPreferencesFromResource(R.xml.preferences);
	    
	    spamPref = (CheckBoxPreference) getPreferenceScreen().findPreference("spam");
	    usernamePref = (EditTextPreference) getPreferenceScreen().findPreference("username");
	}

	private void updateSummaries() {

        usernamePref.setSummary("Username currently set to " + usernamePref.getText());
		
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateSummaries();
    }

    @Override
    protected void onPause() {
        super.onPause();
        updateSummaries();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        updateSummaries();
    }
}
