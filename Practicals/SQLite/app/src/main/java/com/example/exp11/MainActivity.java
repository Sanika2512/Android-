package com.example.exp11;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DBOperations db;

    EditText etName, etMarks, etId;
    Button btnInsert, btnView, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBOperations(this);

        etName = findViewById(R.id.etName);
        etMarks = findViewById(R.id.etMarks);
        etId = findViewById(R.id.etId);

        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        // ✅ INSERT
        btnInsert.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String marksStr = etMarks.getText().toString();

            if (name.isEmpty() || marksStr.isEmpty()) {
                Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            int marks = Integer.parseInt(marksStr);

            boolean result = db.insertData(name, marks);
            Toast.makeText(this, result ? "Inserted" : "Failed", Toast.LENGTH_SHORT).show();
        });

        // ✅ VIEW
        btnView.setOnClickListener(v -> {
            Cursor cursor = db.getData();

            if (cursor.getCount() == 0) {
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuilder data = new StringBuilder();

            while (cursor.moveToNext()) {
                data.append("ID: ").append(cursor.getInt(0)).append("\n");
                data.append("Name: ").append(cursor.getString(1)).append("\n");
                data.append("Marks: ").append(cursor.getInt(2)).append("\n\n");
            }

            // Better display
            new android.app.AlertDialog.Builder(this)
                    .setTitle("Student Data")
                    .setMessage(data.toString())
                    .setPositiveButton("OK", null)
                    .show();
        });

        // ✅ UPDATE
        btnUpdate.setOnClickListener(v -> {
            String idStr = etId.getText().toString();
            String name = etName.getText().toString();
            String marksStr = etMarks.getText().toString();

            if (idStr.isEmpty() || name.isEmpty() || marksStr.isEmpty()) {
                Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            int id = Integer.parseInt(idStr);
            int marks = Integer.parseInt(marksStr);

            boolean result = db.updateData(id, name, marks);
            Toast.makeText(this, result ? "Updated" : "ID Not Found", Toast.LENGTH_SHORT).show();
        });

        // ✅ DELETE
        btnDelete.setOnClickListener(v -> {
            String idStr = etId.getText().toString();

            if (idStr.isEmpty()) {
                Toast.makeText(this, "Enter ID", Toast.LENGTH_SHORT).show();
                return;
            }

            int id = Integer.parseInt(idStr);

            boolean result = db.deleteData(id);
            Toast.makeText(this, result ? "Deleted" : "ID Not Found", Toast.LENGTH_SHORT).show();
        });
    }
}