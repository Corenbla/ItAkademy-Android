package com.example.itakademy_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itakademy_android.adapter.EmployeeRecyclerViewAdapter;
import com.example.itakademy_android.entity.Employee;
import com.example.itakademy_android.helper.DatabaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements EmployeeRecyclerViewAdapter.ItemClickListener {

    EmployeeRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Hello les its");

        RecyclerView recyclerView = findViewById(R.id.employeeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        ArrayList<Employee> employees = new ArrayList<>();

        Cursor cursor = db.query("employee", null, null, null, null, null, null, null);

        while(cursor.moveToNext()) {
            Employee tempEmployee = new Employee();
            tempEmployee.setId(cursor.getInt(cursor.getColumnIndex("id")));
            tempEmployee.setFirstName(cursor.getString(cursor.getColumnIndex("firstName")));
            tempEmployee.setLastName(cursor.getString(cursor.getColumnIndex("lastName")));
            tempEmployee.setAge(cursor.getInt(cursor.getColumnIndex("age")));
            tempEmployee.setSalary(cursor.getInt(cursor.getColumnIndex("salary")));
            employees.add(tempEmployee);
        }

        cursor.close();

        adapter = new EmployeeRecyclerViewAdapter(this, employees);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    public void onBtn1Click(View view){
        Intent i = new Intent(this, SecondaryActivity.class);
        i.putExtra("data", "Depuis la main Activity");
        startActivity(i);
    }

    public void onBtn2Click(View view){
        TextView textView = findViewById(R.id.textView);
        textView.setText("Hello personne");

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("Android power");

        Log.e("DEBUG", "TEST");

        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You cliked : " + String.valueOf(adapter.getItem(position)), Toast.LENGTH_SHORT).show();
    }


}