package com.example.inputcontrol;


import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    RadioGroup radioGroup;
    CheckBox cbReading, cbSports;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        radioGroup = findViewById(R.id.radioGroup);
        cbReading = findViewById(R.id.cbReading);
        cbSports = findViewById(R.id.cbSports);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString();

            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton rb = findViewById(selectedId);
            String gender = (rb != null) ? rb.getText().toString() : "Not selected";

            String hobbies = "";
            if (cbReading.isChecked()) hobbies += "Reading ";
            if (cbSports.isChecked()) hobbies += "Sports ";

            String result = "Name: " + name +
                    "\nGender: " + gender +
                    "\nHobbies: " + hobbies;

            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        });
    }
}