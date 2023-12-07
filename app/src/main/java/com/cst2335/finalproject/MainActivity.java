package com.cst2335.finalproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

// TODO: add code so activity main can function

     private static final String MARVEL_API_BASE_URL = "https://gateway.marvel.com/v1/public/";
     private static final String API_KEY = "ffaeba31bf5c7339d8768fce859f045ef1bed980";


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