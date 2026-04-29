package com.example.contextmenue;


import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);

        // Register TextView for context menu
        registerForContextMenu(txt);
    }

    // Create menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Select Option");
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    // Handle click
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