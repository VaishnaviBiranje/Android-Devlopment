package com.example.popmenue;


import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Register for Context Menu
        registerForContextMenu(textView);
    }

    // Create Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Choose Option");
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    // Handle item click
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.edit) {
            Toast.makeText(this, "Edit Clicked", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.delete) {
            Toast.makeText(this, "Delete Clicked", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.share) {
            Toast.makeText(this, "Share Clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }
}