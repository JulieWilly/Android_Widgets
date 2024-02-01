package com.android.android_widgetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

public class HomeActivity extends AppCompatActivity {
    RatingBar ratingBar; // rating bar
    Button btnSubmit;
    WebView webView;
    
    // SeekBar
    private SeekBar seekBar;

    // DATE PICKER.
    private Date picker;
    private Button displayDate;
    private TextView textView;


    // TIME PICKER
    private TextView txt_timePicker;
    private Button bnt_showTime;
    private TimePicker timePicker;



    private ListView listView;
    private TextView txt_cities;
    String[] list_Items_cities;

    private AutoCompleteTextView autoCompleteTextView;
    String[] language = {"C", "C++", "Java", ".NET", "iPhone", "Android", "ASP.NET", "PHP"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        autoCompleteTextView = findViewById(R.id.autoCompleteTxt);

        // TIME PICKER
        txt_timePicker = findViewById(R.id.timePicker);
        bnt_showTime = findViewById(R.id.showTime);
        timePicker = findViewById(R.id.timePickerView);

        timePicker.setIs24HourView(true);
        txt_timePicker.setText(getCurrentTime());

        bnt_showTime.setOnClickListener(v-> {
            txt_timePicker.setText(getCurrentTime());
        });

        Button btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), home2Activity.class);
            startActivity(intent);
        });
        // list view items.
    listView = findViewById(R.id.listView);
    txt_cities = findViewById(R.id.txtCities);
    list_Items_cities = getResources().getStringArray(R.array.array_cities);

    // webView
        webView = findViewById(R.id.webView);
        webView.loadUrl("https://www.fiverr.com/users/eng_willy/manage_gigs?current_filter=active&days_for_stats=7");
        
        // seekbar
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(HomeActivity.this, "Seekbar progress: " + i, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(HomeActivity.this, "Seek bar touch started", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(HomeActivity.this, "Seek bar touch stopped.", Toast.LENGTH_SHORT).show();
            }
        });

        // DATE PICKER.
        textView = findViewById(R.id.txtDatePicker);
        displayDate = findViewById(R.id.btnDisplayDate);
        timePicker = findViewById(R.id.timePickerView);

        //textView.setText("Current Date: " + getCurrentDate());
        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Change Date: " + getCurrentDate());
            }
        });
    addListenerOnButtonClick();
    // create an adapter
        final ArrayAdapter<String> list_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, list_Items_cities);
        listView.setAdapter(list_adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = list_adapter.getItem(i);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            }
        });


        // create the instance of the ArrayAdapter containing the list of items.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, language);

        // implement auto completion
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter); // setting adapter
        autoCompleteTextView.setTextColor(Color.RED);

    }

    private String getCurrentTime() {
        String currentTime = "Current Time: " + timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
        return currentTime;
    }

    // date formating method
    private String getCurrentDate() {
        StringBuilder builder = new StringBuilder();
        builder.append((picker.getMonth() + 1) + "/");
        builder.append(picker.getDay() + "/");
        builder.append((picker.getYear()));
        return builder.toString();
    }

    private void addListenerOnButtonClick() {
        ratingBar = findViewById(R.id.ratingBar);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = String.valueOf(ratingBar.getRating());
                Toast.makeText(HomeActivity.this, rating, Toast.LENGTH_SHORT).show();
            }
        });
    }
}