package com.cst2335.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        FragmentList fragmentList = new FragmentList();
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ListView comicListView = findViewById(R.id.comicList);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView2, fragmentList, "Comic List");
        transaction.commit();
    }
}