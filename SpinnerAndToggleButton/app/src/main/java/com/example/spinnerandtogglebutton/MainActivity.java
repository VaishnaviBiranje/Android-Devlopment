package com.example.spinnerandtogglebutton;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ToggleButton toggle;
    Button btn;

    String[] cities = {"Pune", "Mumbai", "Delhi", "Chennai"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        toggle = findViewById(R.id.toggle);
        btn = findViewById(R.id.btn);

        // Spinner Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                cities
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Button Click
        btn.setOnClickListener(v -> {
            String city = spinner.getSelectedItem().toString();
            String status = toggle.isChecked() ? "ON" : "OFF";

            Toast.makeText(this,
                    "City: " + city + "\nStatus: " + status,
                    Toast.LENGTH_LONG).show();
        });
    }
}