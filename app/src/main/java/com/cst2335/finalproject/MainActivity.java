package com.cst2335.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ComicAdapter.OnItemClickListener{

    private RecyclerView recyclerView;
    private ComicAdapter comicAdapter;
    private List<Comic> comicList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        comicList = new ArrayList<Comic>();

        comicAdapter = new ComicAdapter(comicList, this);
        recyclerView.setAdapter(comicAdapter);
    }

    @Override
    public void onItemClick(int position){
        Comic selectedComic = comicList.get(position);
        //Add code to view the selected comic page by page
    }
}