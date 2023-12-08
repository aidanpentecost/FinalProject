package com.cst2335.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity
        implements DarkModeButtonFragment.OnDarkModeButtonClickListener,
        BackButtonFragment.OnBackButtonClickListener{

    private boolean darkMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        DarkModeButtonFragment button = new DarkModeButtonFragment();
        BackButtonFragment backButton = new BackButtonFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.lightButtonFragmentContainer, button, "DarkModeButtonFragment");
        transaction.add(R.id.backButtonFragmentContainer, backButton, "BackButtonFragment");
        transaction.commit();
    }

    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("LightMode", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("darkMode", darkMode);
    }

    @Override
    public void onDarkModeButtonClick() {
        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                // The default mode is light, so do nothing here.
                break;
        }
        darkMode = (darkMode) ? false: true;
        recreate();
    }

    @Override
    public void onBackButtonCLick() {
        finish();
    }
}