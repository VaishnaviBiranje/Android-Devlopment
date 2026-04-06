package com.example.dbprogram;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnSave, btnShow;

    DBHelper dbHelper;   // Database object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Edge-to-edge padding (your existing code)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 🔹 Initialize UI
        editText = findViewById(R.id.editText);
        btnSave = findViewById(R.id.btnSave);
        btnShow = findViewById(R.id.btnShow);

        // 🔹 Initialize DB
        dbHelper = new DBHelper(this);

        // 🔹 Save Button
        btnSave.setOnClickListener(v -> {
            String name = editText.getText().toString();
            dbHelper.insertUser(name);
        });

        // 🔹 Show Button
        btnShow.setOnClickListener(v -> {
            dbHelper.getUsers();
        });
    }
}