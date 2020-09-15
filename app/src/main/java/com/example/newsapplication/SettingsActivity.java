package com.example.newsapplication;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Toast;


public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.darktheme);
        }
        else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        Preference swtch = (Preference) findPreference("notifications_new_message");
        swtch.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean isOn = (boolean) newValue;
                if (isOn) {
                   // OneSignal.setSubscription(true);
                    Toast.makeText(getApplicationContext(), "Thank You for subscribing to notifications", Toast.LENGTH_LONG).show();

                } else {
                 //   OneSignal.setSubscription(false);
                    Toast.makeText(getApplicationContext(), "You are successfully unsubscribed from notifications", Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });
        Preference night=(Preference)findPreference("night");
        night.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean ison=(boolean) newValue;
                if (ison){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    //setTheme(R.style.darktheme);
                    //restartApp();
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                   // setTheme(R.style.AppTheme);
                   // restartApp();
                }
                return true;
            }
        });
    }

}


    /*    mNotification = (CheckBox) findViewById(R.id.notification);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = preferences.edit();
        if (preferences.contains("checked") && preferences.getBoolean("checked", false) == true) {
            mNotification.setChecked(true);
        } else {
            mNotification.setChecked(false);
        }

        mNotification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mNotification.isChecked()) {
                    OneSignal.setSubscription(false);
                    Toast.makeText(SettingsActivity.this, "You are successfully unsubscribed from notifications", Toast.LENGTH_LONG).show();
                    mNotification.setChecked(true);
                    editor.apply();
                } else {
                    OneSignal.setSubscription(true);
                    Toast.makeText(SettingsActivity.this, "Thank You for subscribing to notifications", Toast.LENGTH_LONG).show();
                    mNotification.setChecked(false);
                    editor.apply();
                }
            }

        });
*/

