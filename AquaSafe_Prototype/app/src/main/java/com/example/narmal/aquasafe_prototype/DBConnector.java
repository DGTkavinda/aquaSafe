package com.example.narmal.aquasafe_prototype;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by narmal on 5/19/2017.
 */
public class DBConnector {

    public static String DATABASE_NAME = "aquasafelogin.db";
    public static int DATABASE_VERSION = 1;
   // public static final int NAME_COLUMN = 1;
    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    public static String CREATE_DB = "create table "+"LOGIN"+
            "( " +"COL_ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text); ";
    // Variable to hold the database instance
    public  SQLiteDatabase liteDataBase;
    // Context of the application using the database.
    public final Context context;
    // Database open/upgrade helper
    public DBHelper Helper;
    public DBConnector(Context _context)
    {
        context = _context;
        Helper = new DBHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public DBConnector open() throws SQLException
    {
        liteDataBase = Helper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        liteDataBase.close();
    }

   /** public SQLiteDatabase getDatabaseInstance()
    {
        return liteDataBase;
    }**/

    public void insertValues(String userName,String password)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD",password);

        // Insert the row into your table
        liteDataBase.insert("LOGIN", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public int deleteValues(String UserName)
    {
        //String id=String.valueOf(ID);
        String where="USERNAME=?";
        int deletedAmount= liteDataBase.delete("LOGIN", where, new String[]{UserName}) ;
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return deletedAmount;
    }
    public String SelectedEntry(String userName)
    {
        Cursor function=liteDataBase.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(function.getCount()<1) // UserName Not Exist
        {
            function.close();
            return "There are no inputs in the db";
        }
        function.moveToFirst();
        String password= function.getString(function.getColumnIndex("PASSWORD"));
        function.close();
        return password;
    }
    public void  updateEntry(String userName,String password)
    {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD",password);

        String where="USERNAME = ?";
        liteDataBase.update("LOGIN",updatedValues, where, new String[]{userName});
    }
}
