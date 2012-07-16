package edu.fsu.cs.mobile.example.preferenceactivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
    
	SharedPreferences mPrefs;
	private final String USERNAME = "username";
	private final String SPAM = "spam";
	
	private OnSharedPreferenceChangeListener mSharedPreferencesListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {

            getPrefs();
        }
    };
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getPrefs();
        mPrefs.registerOnSharedPreferenceChangeListener(mSharedPreferencesListener);
    }
    
    public void getPrefs() {
    	mPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
    	
    	String msg = "username = " + mPrefs.getString(USERNAME, "NULL") + ", spam = " 
    								+ mPrefs.getBoolean("spam", false) + ", self_destruct = " 
    								+ mPrefs.getBoolean("self_destruct", false);
    	
    	Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.options, menu);
    	return true;
    	
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	Intent intent = null;
    	switch(item.getItemId()) {
    	
    	case R.id.options:
    		intent = new Intent(this, Preferences.class);
    		break;
    		
    	case R.id.other_opts:
    		intent = new Intent(this, SecurityPreferences.class);
    		
    	case R.id.quit:
    		finish();
    		break;
    	
    	}
    	
    	startActivity(intent);
    	
    	return true;
    	
    }
}