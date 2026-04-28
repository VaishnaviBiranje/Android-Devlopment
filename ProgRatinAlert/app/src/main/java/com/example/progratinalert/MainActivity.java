package com.example.progratinalert;   // use your package name

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    ProgressBar progressBar;
    Button btnProgress, btnAlert;
    TextView textView;

    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        progressBar = findViewById(R.id.progressBar);
        btnProgress = findViewById(R.id.btnProgress);
        btnAlert = findViewById(R.id.btnAlert);
        textView = findViewById(R.id.textView);

        // Rating Bar Listener
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            textView.setText("Rating: " + rating);
        });

        // Progress Bar Button
        btnProgress.setOnClickListener(v -> {
            progress += 10;
            if (progress > 100) progress = 0;
            progressBar.setProgress(progress);
        });

        // Alert Dialog Button
        btnAlert.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Alert");
            builder.setMessage("Do you want to continue?");

            builder.setPositiveButton("Yes", (dialog, which) ->
                    Toast.makeText(this, "You clicked YES", Toast.LENGTH_SHORT).show());

            builder.setNegativeButton("No", (dialog, which) ->
                    Toast.makeText(this, "You clicked NO", Toast.LENGTH_SHORT).show());

            builder.show();
        });
    }
}