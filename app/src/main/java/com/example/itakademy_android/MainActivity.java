package com.example.itakademy_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.title);
        textView.setText(R.string.app_name);
    }

    public void foo(View view) {
        Button leftButton = findViewById(R.id.homeButton1);
        Button rightButton = findViewById(R.id.homeButton2);

        leftButton.setText(R.string.tada);
        rightButton.setText(R.string.tada);

         Toast.makeText(this, "🎊", Toast.LENGTH_SHORT).show();
    }
}