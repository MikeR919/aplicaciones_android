package com.example.actividad11;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSqLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSqLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase act11) {
        act11.execSQL("CREATE TABLE usuarios(numero INT primary key,nombre VARCHAR(45),direccion VARCHAR(45),telefono bigint,correo VARCHAR(45))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
