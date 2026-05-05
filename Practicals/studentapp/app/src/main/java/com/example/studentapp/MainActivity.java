package com.example.studentapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name, email, phone;
    Button submit;
    ListView listView;

    ArrayList<String> students;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        submit = findViewById(R.id.submit);
        listView = findViewById(R.id.listView);

        students = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, students);

        listView.setAdapter(adapter);

        submit.setOnClickListener(v -> {

            String data = name.getText().toString() + " | " +
                    email.getText().toString() + " | " +
                    phone.getText().toString();

            students.add(data);
            adapter.notifyDataSetChanged();

            name.setText("");
            email.setText("");
            phone.setText("");
        });
    }
}