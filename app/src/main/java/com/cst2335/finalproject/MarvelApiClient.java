package com.cst2335.finalproject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarvelApiClient {
    public static MarvelApiService getMarvelApiService() {
        return marvelApiService;
    }

    private static final String BASE_URL = "https://gateway.marvel.com/";
    public static final String API_KEY = "2128c69ab35fbae8654e56eb850f2ad1";
    private static final String PRIVATE_KEY = "ffaeba31bf5c7339d8768fce859f045ef1bed980";

    private static MarvelApiService marvelApiService;


    public static MarvelApiService getMarveApiService(){
        if(marvelApiService == null){
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor())
                    .build();

            Retrofit retorfit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            marvelApiService = retorfit.create(MarvelApiService.class);
        }

        return marvelApiService;
    }

    public static String generateHash(long timestamp){
        return "";
    }
}