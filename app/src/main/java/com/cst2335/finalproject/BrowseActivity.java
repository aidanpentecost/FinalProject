package com.cst2335.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class BrowseActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private String username;

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
        setContentView(R.layout.activity_browse);
        FragmentList fragmentList = new FragmentList();
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ListView comicListView = findViewById(R.id.comicList);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView2, fragmentList, "Comic List");
        transaction.commit();

        Intent fromMain = getIntent();
        username = fromMain.getStringExtra("username");

        drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);

        //Lambda to deal with every NavigationDrawer item
        navigationView.setNavigationItemSelectedListener(item -> {

            int itemId = item.getItemId();

            if (itemId == R.id.drawerAbout) {
                showSnackbar("Captain Comic Version 0.1");
            } else if (itemId == R.id.drawerLanguage) {
                showSnackbar("We only read in english SORRY");
            } else if (itemId == R.id.drawerHelp) {
                showSnackbar("Figure out your own issues");
            } else if (itemId == R.id.drawerHome) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else if(itemId == R.id.drawerSettings){
                //Moves to SettingsActivity
                Intent settings = new Intent(
                        BrowseActivity.this,
                        SettingsActivity.class);
                startActivity(settings);
            } else if(itemId == R.id.navPreferences){
                //Moves to PreferencesActivity
                Intent preferences = new Intent(
                        BrowseActivity.this,
                        PreferencesActivity.class);
                preferences.putExtra("username", username);
                startActivity(preferences);
            }

            return true;
        });

        ImageButton navButton = findViewById(R.id.navButton);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Opens or closes the drawer on click
                if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleBottomNavigationItemClick(item);
                return false;
            }
        });

        //Used to sho user that the data is loading
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
            }
        }, 2000);
        new FetchMarvelDataTask().execute("https://gateway.marvel.com/v1/public/characters?ts=1&apikey=2128c69ab35fbae8654e56eb850f2ad1&hash=b2df92dad305b151b2bdccf3c25ae28b");
    }

    /**
     * @param item
     */
    private void handleBottomNavigationItemClick(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.Manga) {
            showMangaAlertDialog();
        }
    }

    //Shows alertDialog when clicking Manga button
    private void showMangaAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Go Back To Comics")
                .setMessage("We Don't Read Manga, You Are A Dweeb")
                .setPositiveButton("OK", null)
                .show();
    }

    /**
     * @param message
     */
    private void showSnackbar(String message) {
        //makes and fills the text of a snackbar
        View parentLayout = findViewById(android.R.id.content);
        Snackbar.make(parentLayout, message, Snackbar.LENGTH_SHORT).show();
    }


    private class FetchMarvelDataTask extends AsyncTask<String, Void, String> {
        //fetches API results in a background thread
        @Override
        protected String doInBackground(String... urls) {
            StringBuilder result = new StringBuilder();
            HttpsURLConnection urlConnection = null;
            try {
                URL url = new URL(urls[0].replace("http://", "https://"));
                urlConnection = (HttpsURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1) {
                    char current = (char) data;
                    result.append(current);
                    data = reader.read();
                }
                return result.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "Failed to Fetch Data";
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
        }

        /**
         * @param result The result of the operation computed by {@link #doInBackground}.
         */
        @Override
        protected void onPostExecute(String result) {

            //Logs JSON response in logcat for debugging
            Log.d("MarvelData", "JSON Response: " + result);

            try {
                JSONObject jsonObject = new JSONObject(result);
                int code = jsonObject.getInt("code");
                String status = jsonObject.getString("status");

                //Checks that the request is valid code == 200
                if (code == 200 && "Ok".equals(status)) {
                    JSONArray resultsArray = jsonObject.getJSONObject("data")
                            .getJSONArray("results");

                    List<ComicItem> comicItems = new ArrayList<>();

                    //fills arrayList with JSONObjects
                    for (int i = 0; i < resultsArray.length(); i++) {
                        JSONObject comicObject = resultsArray.getJSONObject(i);
                        String id = comicObject.getString("id");
                        String name = comicObject.getString("name");
                        String description = comicObject.getString("description");

                        JSONObject thumbnailObject = comicObject.getJSONObject("thumbnail");
                        String thumbnailPath = thumbnailObject.getString("path");
                        String thumbnailExtension = thumbnailObject.getString("extension");

                        //Constructs the ComicItem for each entry
                        ComicItem comicItem = new ComicItem(
                                id,
                                name,
                                description,
                                thumbnailPath,
                                thumbnailExtension);

                        comicItems.add(comicItem);
                    }

                    //Adapts the arrayList into the listView
                    ComicListAdapter adapter = new ComicListAdapter(
                            BrowseActivity.this,
                            comicItems);

                    ListView comicListView = findViewById(R.id.comicList);
                    comicListView.setAdapter(adapter);

                } else {
                    //Generic error message
                    showSnackbar("Marvel API request failed with code: "
                            + code +
                            ", Status: "
                            + status);
                }
            } catch (Exception e) {
                e.printStackTrace();
                showSnackbar("Failed to parse Marvel data");
            }
        }
    }
}