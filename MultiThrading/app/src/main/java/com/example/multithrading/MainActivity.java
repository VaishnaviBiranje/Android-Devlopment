package com.example.multithrading;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(v -> {

            // Create new thread
            Thread thread = new Thread(() -> {

                for (int i = 1; i <= 10; i++) {
                    int finalI = i;

                    try {
                        Thread.sleep(1000); // delay 1 sec
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Update UI from main thread
                    runOnUiThread(() -> textView.setText(String.valueOf(finalI)));
                }
            });

            thread.start();
        });
    }
}