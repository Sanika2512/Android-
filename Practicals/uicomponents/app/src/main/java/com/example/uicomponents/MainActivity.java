package com.example.uicomponents;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    RadioGroup radioGroup;
    CheckBox checkBox;
    ToggleButton toggleButton;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        radioGroup = findViewById(R.id.radioGroup);
        checkBox = findViewById(R.id.checkBoxAgree);
        toggleButton = findViewById(R.id.toggleButton);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {

            String name = editTextName.getText().toString().trim();

            int selectedId = radioGroup.getCheckedRadioButtonId();
            String gender = "Not Selected";

            if (selectedId != -1) {
                RadioButton selectedRadio = findViewById(selectedId);
                gender = selectedRadio.getText().toString();
            }

            String agree = checkBox.isChecked() ? "Agreed" : "Not Agreed";
            String toggleStatus = toggleButton.isChecked() ? "ON" : "OFF";

            String result = "Name: " + name +
                    "\nGender: " + gender +
                    "\nCheckbox: " + agree +
                    "\nToggle: " + toggleStatus;

            Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
        });

        checkBox.setOnClickListener(v -> {
            if (checkBox.isChecked()) {
                Toast.makeText(MainActivity.this, "Checkbox Checked", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Checkbox Unchecked", Toast.LENGTH_SHORT).show();
            }
        });

        toggleButton.setOnClickListener(v -> {
            if (toggleButton.isChecked()) {
                Toast.makeText(MainActivity.this, "Toggle ON", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Toggle OFF", Toast.LENGTH_SHORT).show();
            }
        });
    }
}