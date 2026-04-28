package com.example.layout;   // ⚠️ change according to your project package

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    EditText name, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking XML IDs
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);

        // Button 1 (RelativeLayout)
        btn1.setOnClickListener(v -> {
            Toast.makeText(this, "Relative Button Clicked", Toast.LENGTH_SHORT).show();
        });

        // Button 2 (ConstraintLayout)
        btn2.setOnClickListener(v -> {
            Toast.makeText(this, "Constraint Button Clicked", Toast.LENGTH_SHORT).show();
        });

        // Button 3 (FrameLayout)
        btn3.setOnClickListener(v -> {
            String username = name.getText().toString();
            String password = pass.getText().toString();

            Toast.makeText(this,
                    "Name: " + username + " | Pass: " + password,
                    Toast.LENGTH_LONG).show();
        });
    }
}