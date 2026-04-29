package com.example.linearlayout;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {
            String user = name.getText().toString();
            Toast.makeText(this, "Hello " + user, Toast.LENGTH_SHORT).show();
        });
    }
}