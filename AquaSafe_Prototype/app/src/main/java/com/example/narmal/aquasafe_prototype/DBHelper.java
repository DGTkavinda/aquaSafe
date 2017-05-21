package com.example.narmal.aquasafe_prototype;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by narmal on 5/19/2017.
 */
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }
    // Called when no database exists in disk and the helper class needs
    // to create a new one.
    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(DBConnector.CREATE_DB);

    }
    // Called when there is a database version mismatch meaning that the version
    // of the database on disk needs to be upgraded to the current version.
    @Override
    public void onUpgrade(SQLiteDatabase database, int newDatabase,int olddatabase)
    {
        // Log the version upgrade.
      //  Log.w("TaskDBAdapter", "Upgrading from version " +olddatabase + " to " +newDatabase + ", Old data will br distroyed");


        // Upgrade the existing database to conform to the new version. Multiple
        // previous versions can be handled by comparing _oldVersion and _newVersion
        // values.
        // The simplest case is to drop the old table and create a new one.
        database.execSQL("DROP TABLE " + "TEMPLATE");
        // Create a new one.
        onCreate(database);
    }
}
