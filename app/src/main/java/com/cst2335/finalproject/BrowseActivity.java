package com.cst2335.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
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

        DrawerLayout drawer = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(item -> {

            int itemId = item.getItemId();

            if (itemId == R.id.drawerAbout) {
                showSnackbar("Captain Comic Version 0.1");
            } else if (itemId == R.id.drawerLanguage) {
                showSnackbar("We only read in english SORRY");
            } else if (itemId == R.id.drawerHelp) {
                showSnackbar("Figure out your own issues");
            } else if (itemId == R.id.drawerHome) {
                drawer.closeDrawer(GravityCompat.START);
            }

            return true;
        });
    }

    private void showSnackbar(String message) {
        View parentLayout = findViewById(android.R.id.content);
        Snackbar.make(parentLayout, message, Snackbar.LENGTH_SHORT).show();
    }
}