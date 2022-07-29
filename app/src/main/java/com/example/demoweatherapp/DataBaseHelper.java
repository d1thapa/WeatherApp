package com.example.demoweatherapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String WEATHER_DATA_TABLE = "WEATHER_DATA_TABLE";
    public static final String COLUMN_CITY = "CITY";
    public static final String COLUMN_TEMPERATURE = "TEMPERATURE";
    public static final String COLUMN_PRESSURE = "PRESSURE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_HUMIDITY = "HUMIDITY";
    public static final String DESCRIPTION = "DESCRIPTION";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "weather.db", null, 1);
    }

    //code to create new database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + WEATHER_DATA_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CITY + " TEXT, " + COLUMN_TEMPERATURE + " REAL, " + COLUMN_PRESSURE + " INTEGER," + COLUMN_HUMIDITY + " INTEGER, " + DESCRIPTION + " STRING )";

        db.execSQL(createTableStatement);

    }

    //if database version number changes. prevents previous users app.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public boolean addToDatabase( String city, String temperature, int pressure, int humidity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CITY, city);
        cv.put(COLUMN_TEMPERATURE, temperature);
        cv.put(COLUMN_PRESSURE, pressure);
        cv.put(COLUMN_HUMIDITY, humidity);

        long insert = db.insert(WEATHER_DATA_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else
            return true;
    }

    public boolean addToDatabase(String temperature, int pressure, int humidity) {
        return false;
    }
}
