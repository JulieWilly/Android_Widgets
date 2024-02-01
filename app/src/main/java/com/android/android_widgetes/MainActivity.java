package com.android.android_widgetes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] country = {"Kenya", "South Africa", "Lesotho", "Burkinafaso", "Nigeria", "Ethiopia", "Tanzania"};

    private ToggleButton toggle1, toggle2;
    private CheckBox ck_pizza, ck_masala, ck_salsa, ck_hotDog;
    private RadioButton genderRadioButton;
    private RadioGroup genderRadioGroup;

    private Button btn, btnCheckBoxes, closeDialog, nxtActivity, submitGender;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genderRadioGroup = findViewById(R.id.radioGroup);
        Spinner spin = findViewById(R.id.spinCountries);
        spin.setOnItemSelectedListener(this);

        // creating the array adapter instance having the country items
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // setting the ArrayAdapter data on the spinner
        spin.setAdapter(adapter);

        addEventListener();
        addEventListenerBtnCheckBoxes();
        addEventListenerCheckGender();
        addEventListenerAlertDialog();
        activityNext();
    }

    private void activityNext() {
        nxtActivity = findViewById(R.id.nextActivity);
        Intent intent = new Intent(getApplicationContext(), homeActivity3.class);
        startActivity(intent);
    }

    private void addEventListenerAlertDialog() {
        closeDialog = findViewById(R.id.closeDialog);
        // create an object of the class first.
        builder = new AlertDialog.Builder(this);

        closeDialog.setOnClickListener(v -> {

            // set the dialog title and dialog message.
            builder.setTitle("Alert dialog").setMessage("Do you want to exit from this activity?");

            // set the message and the title manually.
            builder.setMessage("Do you want to close this application?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialogInterface, i) -> {
                        finish();
                        Toast.makeText(this, "You have chosen YES. To close the application completely.", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("No", (dialogInterface, i) -> {
                        dialogInterface.cancel();
                        Toast.makeText(this, "You have chosen no action. Not to close this activity.", Toast.LENGTH_SHORT).show();
                    });
            // create a dialog box
            AlertDialog alertDialog = builder.create();
            // set the title manually.
            alertDialog.setTitle("Alert Dialog example.");
            alertDialog.show();
        });
    }

    private void addEventListenerCheckGender() {
       int selectedID = genderRadioGroup.getCheckedRadioButtonId();
       genderRadioButton = findViewById(selectedID);

       // if nor view is selected
        if (selectedID == -1) {
            Toast.makeText(this, "No radio button has been checked yet!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, genderRadioButton.getText(), Toast.LENGTH_SHORT).show();
        }

    }

    private void addEventListenerBtnCheckBoxes() {
        ck_pizza = findViewById(R.id.ckPizza);
        ck_masala = findViewById(R.id.ckMasala);
        ck_salsa = findViewById(R.id.ckSalsa);
        ck_hotDog = findViewById(R.id.ckHotDog);
        btnCheckBoxes = findViewById(R.id.submitCheckBox);

        // add a functionality to the button
        btnCheckBoxes.setOnClickListener(v -> {
            int totalAmount = 0;

            StringBuilder result = new StringBuilder();
            result.append("Selected Items:");

            if (ck_pizza.isChecked()) {
                result.append("\n Pizza KSH 10000");
                totalAmount += 100;
            }
            if (ck_masala.isChecked()) {
                result.append("\n Masala KSH 700");
                totalAmount += 50;
            }

            if (ck_salsa.isChecked()) {
                result.append("\n Salsa KSH 600");
                totalAmount += 200;
            }

            if (ck_hotDog.isChecked()) {
                result.append("\n Hot dog KSH 500");
                totalAmount += 350;
            }

            // show the answers now.
            result.append("\n Total" + totalAmount + "KSH");
            Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show();
        });
    }

    private void addEventListener() {
        toggle1 = findViewById(R.id.toggle1);
        toggle2 = findViewById(R.id.toggle2);
        btn = findViewById(R.id.submit);

        // perform an action upon clicking the button
        btn.setOnClickListener(v -> {
            StringBuilder result = new StringBuilder();
            result.append("ToggleButton1:").append(toggle1.getText());
            result.append("\nToggleButton2:").append(toggle2.getText());

            Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, country[i], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // add other codes here respectively.
    }
}