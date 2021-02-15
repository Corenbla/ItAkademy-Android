package com.example.itakademy_android.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL(SQL_CREATE_ENTRIES)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null) {
            db.execSQL(SQL_DELETE_ENTRIES)
        }
    }

    companion object {
        const val DATABASE_VERSION = 1;
        const val DATABASE_NAME = "itakademy_android.db";
        const val SQL_CREATE_ENTRIES = "CREATE TABLE employee (id INTEGER PRIMARY KEY, firstName TEXT, lastName TEXT, age INTEGER, salary INTEGER)";
        const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS employee"
    }
}