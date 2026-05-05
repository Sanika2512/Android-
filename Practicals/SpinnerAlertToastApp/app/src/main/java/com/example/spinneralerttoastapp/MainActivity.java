package com.example.spinneralerttoastapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button btnAlert, btnPopup, btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        btnAlert = findViewById(R.id.btnAlert);
        btnPopup = findViewById(R.id.btnPopup);
        btnToast = findViewById(R.id.btnToast);

        // Spinner Data
        final String[] items = {"Java", "Python", "C++", "Kotlin"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                items
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Spinner Event
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Selected: " + items[position],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // ALERT DIALOG
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exit");
                builder.setMessage("Are you sure you want to exit?");

                builder.setPositiveButton("Yes", (dialog, which) ->
                        Toast.makeText(MainActivity.this, "Exited", Toast.LENGTH_SHORT).show()
                );

                builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());

                builder.show();
            }
        });

        // POPUP MENU
        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnPopup);

                popupMenu.getMenu().add("Edit");
                popupMenu.getMenu().add("Delete");

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Toast.makeText(MainActivity.this,
                                item.getTitle() + " clicked",
                                Toast.LENGTH_SHORT).show();

                        return true;
                    }
                });

                popupMenu.show();
            }
        });

        // TOAST
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,
                        "This is a Toast Message",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}