package com.jacksen.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jacksen on 2016/6/28.
 */

public class SQLDBHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "sqlite_demo.db";

    public static int DB_VERSION = 2;

    public static String TABLE_STUDENTS = "students";


    private static String CREATE_TABLE_STUDENTS = "create table " + TABLE_STUDENTS + " ( id integer primary key autoincrement,  " +
            "name varchar(20) not null, sex integer, class_id integer );";

    public SQLDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("alter table " + TABLE_STUDENTS + " add column age integer");
    }
}
