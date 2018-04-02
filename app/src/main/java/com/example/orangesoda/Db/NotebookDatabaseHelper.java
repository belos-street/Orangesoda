package com.example.orangesoda.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/3/2.
 */

public class NotebookDatabaseHelper extends SQLiteOpenHelper{

    public static  final  String CREATE_NOTEBOOK="create table notebook("+"name text"+"content text)";
    private  Context mContext;
    public NotebookDatabaseHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
        mContext=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NOTEBOOK);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
