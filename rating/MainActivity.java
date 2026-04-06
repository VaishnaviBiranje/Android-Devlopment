package com.example.rating;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    ProgressBar progressBar;
    Button btnReset;
    TextView txtRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        progressBar = findViewById(R.id.progressBar);
        btnReset = findViewById(R.id.btnReset);
        txtRating = findViewById(R.id.txtRating);

        // Rating change event
        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                        // Update TextView
                        txtRating.setText("Rating: " + rating);

                        // Update ProgressBar
                        progressBar.setProgress((int) rating);
                    }
                }
        );

        // Reset button
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ratingBar.setRating(0);
                progressBar.setProgress(0);
                txtRating.setText("Rating: 0");
            }
        });
    }
}