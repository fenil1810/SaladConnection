package com.example.android.saladconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;
import static android.provider.Contacts.SettingsColumns.KEY;
import static com.example.android.saladconnection.R.id.name1;
import static com.example.android.saladconnection.R.id.price;
import static com.google.android.gms.internal.zzs.TAG;
import static java.sql.Types.INTEGER;
import static java.sql.Types.NULL;

public class DbHelper extends SQLiteOpenHelper {

    static final String dbName = "orderDB";
    static final String name = "name";
    static final String quantity = "quantity";
    static final String price = "price";
    static final String table_name = "order";
    public DbHelper(Context context)
    {
        super(context, dbName , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table order" + "( name text,quantity text,price text )" );
        Log.d(TAG,"database Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS"+ table_name);
        onCreate(db);
    }

    public boolean insertContact  (String name1, String quan,String price1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name1);
        contentValues.put("quantity", quan);
        contentValues.put("price", price1);
        db.insert(table_name, null, contentValues);
        return true;
    }
}
/*
public class DbHelper extends SQLiteOpenHelper {

    public static final String dbname = "Order.db";
    public static final String _id = "_id";
    public static final String name = "name";
    public static final String quantity = "quantity";
    public static final String price = "price";
    private HashMap hp;
    private SQLiteDatabase db;

    public DbHelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table Order"
                + "(_id integer primary key, name text,quantity integer,price integer)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS ");
        onCreate(db);
    }
    protected void insertIntoDB(String name,int quan){
        SQLiteDatabase db = this.getWritableDatabase();
        int price=quan*69;
        String query = "INSERT INTO Order (name,quantity,price) VALUES('"+name+"', '"+quan+"', '"+price+"');";
        db.execSQL(query);
       // Toast.makeText(getApplicationContext(),"Saved Successfully", Toast.LENGTH_LONG).show();
    }
    }
*/
/*public class DbHelper extends SQLiteOpenHelper {

    public static final String dbname = "MyNotes.db";
    public static final String _id = "_id";
    public static final String name = "name";
    public static final String remark = "quantity1";
    public static final String dates = "price";
    public static final String mynotes = "mynotes";
    private HashMap hp;
    SQLiteDatabase db;


    public DbHelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table mynotes"
                + "(_id integer primary key, name text,quantity1 integer,price integer)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + mynotes);
        onCreate(db);
    }

    public Cursor fetchAll() {
        db = this.getReadableDatabase();
        Cursor mCursor = db.query(mynotes, new String[] { "_id", "name",
                "quantity1", "price" }, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public boolean insertNotes(String name, int quan) {
        SQLiteDatabase db = this.getWritableDatabase();
        int price1;
        price1=quan*69;
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("quantity", quan);
        contentValues.put("price", price1);
        db.insert(mynotes, null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor z = db.rawQuery("select * from " + mynotes + " where _id=" + id
                + "", null);
        return z;
    }
    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, mynotes);
        return numRows;
    }

}*/
