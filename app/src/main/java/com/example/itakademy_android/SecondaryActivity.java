package com.example.itakademy_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.itakademy_android.helper.DatabaseHelper;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Bundle extras = getIntent().getExtras();

        Toast.makeText(this, extras.getString("extra"), Toast.LENGTH_SHORT).show();
    }

    public void insertEmployee(View view) {
        DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext());
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        EditText firstNameInput = findViewById(R.id.editTextTextEmployeeFirstname);
        EditText lastNameInput = findViewById(R.id.editTextTextEmployeeLastname);
        EditText ageInput = findViewById(R.id.editTextTextEmployeeAge);
        EditText salaryInput = findViewById(R.id.editTextTextEmployeeSalary);

        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", firstNameInput.getText().toString());
        contentValues.put("lastName", lastNameInput.getText().toString());
        contentValues.put("age", ageInput.getText().toString());
        contentValues.put("salary", salaryInput.getText().toString());

        long thing = db.insert("employee", null, contentValues);
        Toast.makeText(getBaseContext(), Long.toString(thing), Toast.LENGTH_SHORT).show();
    }
}