package com.misharuk05.samsungproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    // Данные базы данных и таблиц
    public static final String DATABASE_NAME = "myDB";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "words";
    // Название столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WORD = "Word";
    public static final String COLUMN_TRANSLATION = "Translation";
    // Номера столбцов
    //private static final int NUM_COLUMN_ID = 0;
    //private static final int NUM_COLUMN_WORD = 1;
    //private static final int NUM_COLUMN_TRANSLATION = 2;

    DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WORD + " TEXT, " +
                COLUMN_TRANSLATION + " TEXT); ";
        db.execSQL(query);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}