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

    /**
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
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