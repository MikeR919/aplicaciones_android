package com.example.office_city;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databasehelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="office_city";
    public static final String TABLE_NAME="productos";
    public static final String COL_1="idproducto";
    public static final String COL_2="nombre";
    public static final String COL_3="cantidad";

    public databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+"(idproducto integer primary Key,nombre text,cantidad integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertdata(String idproducto, String nombre, String cantidad){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,idproducto);
        contentValues.put(COL_2,nombre);
        contentValues.put(COL_3,cantidad);
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("Select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean actualizar(String idproducto, String nombre, String cantidad){
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(COL_1,idproducto);
        contentValues.put(COL_2,nombre);
        contentValues.put(COL_3,cantidad);
        sqLiteDatabase.update(TABLE_NAME,contentValues,"idproducto=?",new String[]{idproducto});
        return true;
    }
}
