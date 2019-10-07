package com.example.awageeh.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by a.wageeh on 1/23/2018.
 */

public class mysqelLiteOpenHelper{

    public static String DATABASE_NAME = "product";
    public static String DATABASE_TABLE = "table";
    public final int VERSION = 1;
    public final String KEY_ID = "id";
    public final String key_NAME = "name";
    public final String key_price = "price";
    private final Context context;

    SQLiteDatabase sqLiteDatabase;
    DBhelper dBhelper;

    public mysqelLiteOpenHelper( Context context){
        this.context = context;

    }

    public class DBhelper extends SQLiteOpenHelper{

        public DBhelper(Context context) {
            super(context, DATABASE_NAME,null ,VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE "+ DATABASE_TABLE + "(" + KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT" + key_NAME + "TEXT NOT NULL" + key_price +
            "TEXT NOT NULL");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXCITE my table");
            onCreate(db);

        }

    }
    public void open(){
         dBhelper =new DBhelper(context);
         sqLiteDatabase =dBhelper.getWritableDatabase();
    }

    public void insert(product p){

        ContentValues contentValues = new ContentValues();
        contentValues.put(key_NAME,p.getName());
        contentValues.put(key_price,p.getPrice());
        sqLiteDatabase.insert(DATABASE_TABLE,null,contentValues);

    }

    public ArrayList<product> getData(){

        ArrayList<product> pro = new ArrayList<>();
        String[] colum = {key_NAME ,key_price };
        Cursor cursor = sqLiteDatabase.query(DATABASE_TABLE,colum,null,null,null,null,null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            product product = new product();
            product.setName(cursor.getString(cursor.getColumnIndex(key_NAME)));
            product.setPrice(cursor.getString(cursor.getColumnIndex(key_price)));
            pro.add(product);

        }
        return pro;

    }
}