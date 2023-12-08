package com.cst2335.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import java.util.Map;

public class PreferencesActivity extends AppCompatActivity
        implements BackButtonFragment.OnBackButtonClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        TextView textView = findViewById(R.id.preferences);
        Intent fromMain = getIntent();

        String username = fromMain.getStringExtra("username");

        textView.setText(username);

        BackButtonFragment backButtonFragment = new BackButtonFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(
                R.id.backButtonFragmentContainer2,
                backButtonFragment,
                "BackButtonFragment");
        transaction.commit();
    }

    @Override
    public void onBackButtonCLick() {
        finish();
    }
}