package com.cst2335.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ComicAdapter.OnItemClickListener{

    private RecyclerView recyclerView;
    private ComicAdapter comicAdapter;
    private List<Comic> comicList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        comicList = new ArrayList<Comic>();

        comicAdapter = new ComicAdapter(comicList, this);
        recyclerView.setAdapter(comicAdapter);

        fetchComics();
    }

    @Override
    public void onItemClick(int position){
        Comic selectedComic = comicList.get(position);
        //Add code to view the selected comic page by page
    }

    public void fetchComics(){
        long timestamp = System.currentTimeMillis();
        String hash = MarvelApiClient.generateHash(timestamp);

        Call<ComicDataWrapper> call = MarvelApiClient.getMarvelApiService()
                .getComics(MarvelApiClient.API_KEY, timestamp, hash);

        call.enqueue(new Callback<ComicDataWrapper>() {
            @Override
            public void onResponse(Call<ComicDataWrapper> call, Response<ComicDataWrapper> response) {
                if(response.isSuccessful()){
                    List<Comic> comics = response.body().data.results;
                    comicList.addAll(comics);
                    comicAdapter.notifyDataSetChanged();
                }else{
                    //handle error
                }
            }

            @Override
            public void onFailure(Call<ComicDataWrapper> call, Throwable t) {
                //handle failure
            }
        });
    }
}