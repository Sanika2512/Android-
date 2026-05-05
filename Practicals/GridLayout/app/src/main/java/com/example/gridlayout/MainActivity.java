package com.example.gridlayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] ids = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4};

        for (int id : ids) {
            Button button = findViewById(id);
            button.setOnClickListener(v ->
                    Toast.makeText(this,
                            ((Button) v).getText() + " Clicked",
                            Toast.LENGTH_SHORT).show());
        }
    }
}