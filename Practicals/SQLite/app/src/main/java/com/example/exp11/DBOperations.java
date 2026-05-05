package com.example.exp11;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBOperations {

    DBHelper dbHelper;

    public DBOperations(Context context) {
        dbHelper = new DBHelper(context);
    }

    // INSERT
    public boolean insertData(String name, int marks) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("marks", marks);

        long result = db.insert("students", null, values);
        return result != -1;
    }

    // READ
    public Cursor getData() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM students", null);
    }

    // UPDATE
    public boolean updateData(int id, String name, int marks) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("marks", marks);

        int result = db.update("students", values, "id=?", new String[]{String.valueOf(id)});
        return result > 0;
    }

    // DELETE
    public boolean deleteData(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int result = db.delete("students", "id=?", new String[]{String.valueOf(id)});
        return result > 0;
    }
}