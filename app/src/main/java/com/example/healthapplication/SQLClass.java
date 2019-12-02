package com.example.healthapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQLClass extends SQLiteOpenHelper {
    public static final String databaseName = "TestDB";
    public static final String mainTableName = "healthTable";
    public static final String col1 = "ID";
    public static final String col2 = "DATE";
    public static final String col3 = "CALORIES_BURNED";
    public static final String col4 = "STEPS";
    public static final String col5 = "DISTANCE";
    public static final String col6 = "FLOOR";
    public static final String col7 = "MIN_OF_SITTING";
    public static final String col8 = "MIN_OF_SLOW_ACTIVITY";
    public static final String col9 = "MIN_OF_MODERATE_ACTIVITY";
    public static final String col10 = "MIN_OF_INTENSE_ACTIVITY";
    public static final String col11 = "CALORIES_BURNED_DURING_ACTIVITY";
    public static final String col12 = "MINIMUM_HEARTBEAT";
    public static final String col13 = "MAXIMUM_HEARTBEAT";

    public static final String stepTableName = "stepTable";
    public static final String calorieTableName = "calorieTable";
    public static final String heartbeatTableName = "heartbeatTable";



    public SQLClass(@Nullable Context context) {
        super(context, databaseName, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + mainTableName + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, DATE TEXT, CALORIES_BURNED INTEGER, STEPS INTEGER, DISTANCE DOUBLE, FLOOR INTEGER, MIN_OF_SITTING INTEGER, MIN_OF_SLOW_ACTIVITY INTEGER, MIN_OF_MODERATE_ACTIVITY INTEGER, MIN_OF_INTENSE_ACTIVITY INTEGER, CALORIES_BURNED_DURING_ACTIVITY INTEGER, MINIMUM_HEARTBEAT INTEGER, MAXIMUM_HEARTBEAT INTEGER)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + mainTableName);
        onCreate(db);
    }

    //Insert data to main table.
    public boolean insertData(String date, int caloriesBurned, int steps, double distance, int floor, int minOfSitting, int minOfSlowActivity, int minOfModerateActivity, int minOfIntenseActivity, int caloriesActivity, int minHeartbeat, int maxHeartbeat) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, date);
        contentValues.put(col3, caloriesBurned);
        contentValues.put(col4, steps);
        contentValues.put(col5, distance);
        contentValues.put(col6, floor);
        contentValues.put(col7, minOfSitting);
        contentValues.put(col8, minOfSlowActivity);
        contentValues.put(col9, minOfModerateActivity);
        contentValues.put(col10, minOfIntenseActivity);
        contentValues.put(col11, caloriesActivity);
        contentValues.put(col12, minHeartbeat);
        contentValues.put(col13, maxHeartbeat);

        long result = db.insert(mainTableName, null, contentValues);

        if (result == -1){
           return false;
        }
        else {
            return true;
        }
    }

    public void clearTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + mainTableName);
        onCreate(db);
    }

    // Creates monthly subtables.
    public void createSubTables() {
        SQLiteDatabase db = this.getWritableDatabase();
        //Check if tables exist.
        db.execSQL("DROP TABLE IF EXISTS " + stepTableName);
        db.execSQL("DROP TABLE IF EXISTS " + calorieTableName);
        db.execSQL("DROP TABLE IF EXISTS " + heartbeatTableName);
        //Create subtables.
        db.execSQL("CREATE TABLE " + stepTableName + " AS SELECT ID, STEPS, DISTANCE, FLOOR FROM " + mainTableName + " ORDER BY ID DESC LIMIT 30");
        db.execSQL("CREATE TABLE " + calorieTableName + " AS SELECT ID, CALORIES_BURNED, CALORIES_BURNED_DURING_ACTIVITY FROM " + mainTableName + " ORDER BY ID DESC LIMIT 30");
        db.execSQL("CREATE TABLE " + heartbeatTableName + " AS SELECT ID, MINIMUM_HEARTBEAT, MAXIMUM_HEARTBEAT FROM " + mainTableName + " ORDER BY ID DESC LIMIT 30");
    }

}
