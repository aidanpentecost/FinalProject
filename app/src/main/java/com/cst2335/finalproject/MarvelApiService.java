package com.cst2335.finalproject;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;
public interface MarvelApiService {
    @GET("v1/public/comics")
    Call<ComicDataWrapper> getComics(
            @Query("apikey") String apiKey,
            @Query("ts") long timestamp,
            @Query("hash") String hash
        );
    }


