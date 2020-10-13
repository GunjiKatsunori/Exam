package com.example.exam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

public class TestOpenHelper extends SQLiteOpenHelper {

    // DBの情報
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TestDB.db";
    private static String SQL_CREATE_ENTRIES = "CREATE TABLE test_table (_id INTEGER PRIMARY KEY, name TEXT, value INTEGER)";
    private static String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS Test.db";

    TestOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}