package com.android.android_widgetes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class homeActivity3 extends AppCompatActivity {

    // Tab layout
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    SearchView searchView;
    private ListView listView;
    private ArrayList<String> list;
    ArrayAdapter<String> adapter;
    private ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);

        viewPager = findViewById(R.id.viewPager);
        ImageAdapter imageAdapter = new ImageAdapter(this);

        // tabLayout
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.tb_viewPager);


       // viewPager.setAdapter(imageAdapter);

        // SEARCH VIEW
        searchView = findViewById(R.id.SearchView);
        listView = findViewById(R.id.lv1);

        list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Pineapple");
        list.add("Orange");
        list.add("Lychee");
        list.add("Gavava");
        list.add("Peech");
        list.add("Melon");
        list.add("Watermelon");
        list.add("Papaya");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (list.contains(s)) {
                    adapter.getFilter().filter(s);
                } else {
                    Toast.makeText(homeActivity3.this, "No match found.", Toast.LENGTH_SHORT).show();
                }
                return false;
            }



            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView1 = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}