package com.example.checkboxradiobutton;


import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox c1, c2, c3;
    RadioGroup rg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        rg = findViewById(R.id.radioGroup);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {

            String hobbies = "";

            if (c1.isChecked()) hobbies += "Reading ";
            if (c2.isChecked()) hobbies += "Music ";
            if (c3.isChecked()) hobbies += "Sports ";

            int selectedId = rg.getCheckedRadioButtonId();
            RadioButton rb = findViewById(selectedId);

            String gender = (rb != null) ? rb.getText().toString() : "Not Selected";

            Toast.makeText(this,
                    "Hobbies: " + hobbies + "\nGender: " + gender,
                    Toast.LENGTH_LONG).show();
        });
    }
}