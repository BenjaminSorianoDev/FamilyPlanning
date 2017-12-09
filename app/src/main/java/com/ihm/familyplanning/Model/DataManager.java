package com.ihm.familyplanning.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by benja on 04/12/2017.
 */

public class DataManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Planning.db";
    private static final int DATABASE_VERSION = 1;

    public DataManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String strSQL = "create table T_group ("
                + "idGroup integer primary key autoincrement,"
                + "nameGroup text not null,"
                + "passwordGroup text not null )";

        sqLiteDatabase.execSQL( strSQL );
        Log.i("DATABASE", "onCreate invoked");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("DATABASE", "onUpgrade invoked");
    }

    public void createGroup(String name, String password ){
        String strSQL = "insert into T_group (namGroup, passwordGroup) values ('"
                + name + "', " + password + " )";
        this.getWritableDatabase().execSQL(strSQL);
        Log.i("DATABASE", "createGroup invoked");
    }
}
