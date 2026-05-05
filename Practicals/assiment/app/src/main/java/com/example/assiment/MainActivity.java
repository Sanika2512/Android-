package com.example.assiment;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnPopup = findViewById(R.id.btnPopup);

        // 🔹 Register Context Menu
        registerForContextMenu(textView);

        // 🔹 Popup Menu
        btnPopup.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnPopup);

            // Add items programmatically
            popupMenu.getMenu().add("Edit");
            popupMenu.getMenu().add("Delete");

            popupMenu.setOnMenuItemClickListener(item -> {
                Toast.makeText(MainActivity.this,
                        "Popup: " + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
                return true;
            });

            popupMenu.show();
        });
    }

    // 🔹 OPTION MENU (3 dots menu)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Settings");
        menu.add("About");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,
                "Option: " + item.getTitle(),
                Toast.LENGTH_SHORT).show();
        return true;
    }

    // 🔹 CONTEXT MENU (Long press)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Context Menu");
        menu.add("Copy");
        menu.add("Paste");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this,
                "Context: " + item.getTitle(),
                Toast.LENGTH_SHORT).show();
        return true;
    }
}