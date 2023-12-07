package com.cst2335.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
// TODO: add code so actiivty main can function
 @Override
    protected void onCreate(Bundle savedInstanceState){

     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     FragmentHeader fragmentHeader = new FragmentHeader();
     FragmentList fragmentList = new FragmentList();
     @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ListView comicListView = findViewById(R.id.comicList);

 }
}