package com.example.calender;


import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        textView = findViewById(R.id.textView);

        datePicker.init(
                datePicker.getYear(),
                datePicker.getMonth(),
                datePicker.getDayOfMonth(),
                (view, year, monthOfYear, dayOfMonth) -> {

                    // Month starts from 0, so +1
                    String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                    textView.setText("Selected: " + date);
                }
        );
    }
}