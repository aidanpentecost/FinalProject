package com.cst2335.finalproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.shadow.ShadowRenderer;


public class MainActivity extends AppCompatActivity
        implements LoginButtonFragment.OnLoginButtonClickListener{

     private EditText username;
     private EditText password;

// TODO: add code so activity main can function
     @Override
     protected void onCreate(Bundle savedInstanceState){

          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          username = findViewById(R.id.username);
          password = findViewById(R.id.password);
          LoginButtonFragment login = new LoginButtonFragment();

          FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
          transaction.add(R.id.loginFragmentContainer, login, "LoginButtonFragment");
          transaction.commit();
     }

     @Override
     protected void onPause() {
          super.onPause();
          SharedPreferences sharedPreferences = getSharedPreferences("LoginInfo", MODE_PRIVATE);
          SharedPreferences.Editor editor = sharedPreferences.edit();

          editor.putString("username", username.getText().toString());
          editor.putString("password", password.getText().toString());
          editor.apply();
     }

     @Override
     public void onLoginButtonClick() {
          Intent login = new Intent(MainActivity.this, BrowseActivity.class);
          Toast.makeText(
                  MainActivity.this,
                  getResources().getString(R.string.toast_message),
                  Toast.LENGTH_LONG).show();
          startActivity(login);
     }
}