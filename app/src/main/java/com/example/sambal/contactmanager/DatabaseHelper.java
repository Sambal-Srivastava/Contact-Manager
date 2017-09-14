package com.example.sambal.contactmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by sam on 3/25/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE " +  TABLE_NAME  + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT)");

        }
        catch (Exception e) {
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
            onCreate(db);


    }
    public boolean insertData(String name,int mobile_number,String email){
        SQLiteDatabase db = this.getWritableDatabase();



            ContentValues contentValues = new ContentValues();
            contentValues.put("NAME", name);
            contentValues.put("MOBILE_NUMBER", mobile_number);
            contentValues.put("EMAIL", email);

            long result = db.insert(TABLE_NAME, null, contentValues);
            db.close();
            if (result == -1)
                return false;
            else
                return true;

    }
     public Cursor getData(String mobile_number)
     {
         SQLiteDatabase db=this.getWritableDatabase();

         String query= "SELECT * FROM " + TABLE_NAME + " WHERE MOBILE_NUMBER = '" + mobile_number+"'";

         Cursor cursor=db.rawQuery(query, null);

         return cursor;

     }
     public void deleteData(String mobile_number)
     {
         SQLiteDatabase db=this.getWritableDatabase();

         db.delete(TABLE_NAME, "MOBILE_NUMBER = '"+mobile_number+"'",null);
         db.close();

     }

     public void updateData(String number,String name,String email){
         SQLiteDatabase db=this.getWritableDatabase();
         ContentValues contentValues=new ContentValues();
         contentValues.put("NAME",name);
         contentValues.put("EMAIL",email);
         db.update(TABLE_NAME,contentValues,"MOBILE_NUMBER = '"+number+"'",null);
         db.close();
     }

    }

