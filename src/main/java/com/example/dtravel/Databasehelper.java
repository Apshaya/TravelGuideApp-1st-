package com.example.dtravel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.os.IResultReceiver;

import androidx.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Guider.db";
    public static final String TABLE_NAME = "Guider_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "Details";
    public static final String COL_4 = "Age";

    public Databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " NAME TEXT, Details TEXT,Age INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String Details, String Age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, Details);
        contentValues.put(COL_4, Age);
        long results = db.insert(TABLE_NAME, null, contentValues);
        if (results == -1)
            return false;
        else
            return true;

    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor results = db.rawQuery("select * from " + TABLE_NAME,null);
        return results;

    }
    public boolean updateData(String id, String name, String Details,String Age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,Details);
        contentValues.put(COL_4,Age);
        db.update(TABLE_NAME, contentValues, "id = ?", new String[] {id});
        return true;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }
}
