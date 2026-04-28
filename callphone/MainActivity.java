package com.example.callphone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button call, sms, network;
    ListView listView;

    String items[] = {
            "Android",
            "Java",
            "Kotlin",
            "Python",
            "C++",
            "Machine Learning",
            "Artificial Intelligence",
            "Web Development",
            "Data Science"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        call = findViewById(R.id.btnCall);
        sms = findViewById(R.id.btnSms);
        network = findViewById(R.id.btnNetwork);
        listView = findViewById(R.id.listView);

        // CALL
        call.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:9876543210"));
            startActivity(i);
        });

        // SMS
        sms.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("sms:9876543210"));
            i.putExtra("sms_body","Hello from my Android App!");
            startActivity(i);
        });

        // NETWORK SETTINGS
        network.setOnClickListener(v -> {
            Intent i = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
            startActivity(i);
        });

        // LISTVIEW
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        items);

        listView.setAdapter(adapter);
    }
}
