package com.cst2335.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.w3c.dom.Entity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
 private List<Entity> comicList;

// TODO: add code so activity main can function
     @Override
     protected void onCreate(Bundle savedInstanceState){

          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          FragmentList fragmentList = new FragmentList();
          @SuppressLint({"MissingInflatedId", "LocalSuppress"})
          ListView comicListView = findViewById(R.id.comicList);

          FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
          transaction.replace(R.id.fragmentContainerView2, fragmentList, "Comic List");
          transaction.commit();

     }
}