package com.example.moneymanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

public class Icondb extends SQLiteOpenHelper {
    public Icondb(Context context) {
        super(context,"image.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Icon(image blob);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists imagedata");
        onCreate(sqLiteDatabase);

    }

}
