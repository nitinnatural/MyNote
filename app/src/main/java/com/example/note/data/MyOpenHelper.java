package com.example.note.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyOpenHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "note.db";
	private static final int DATABASE_VERSION = 1;
	
	public static final String TABLE_NAME = "MyNote" ;

	public static final String COLUMN_ID = "_id" ;
	public static final String COLUMN_TITLE = "title" ;
	public static final String COLUMN_CREATED_AT = "createdAt" ;
	public static final String COLUMN_CONTENT = "content" ;
	public static final String COLUMN_COLOR = "color";
	
	// create query to create table
	private static final String SQL_QUERY = "CREATE TABLE "
		      + TABLE_NAME + "(" + COLUMN_ID
		      + " TEXT PRIMARY KEY, " + COLUMN_TITLE + " TEXT, "
				+ COLUMN_COLOR + " INTEGER, "
				+ COLUMN_CREATED_AT + " DATETIME, " + COLUMN_CONTENT + " TEXT);";
	
	
	public MyOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// code to execute SQL_QUERY to create table
		db.execSQL(SQL_QUERY);		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// code to upgrade database
		Log.d(MyOpenHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);		
	}
	
	// method to create a TO-DO
	public long addNewTodo(Note note){
	    SQLiteDatabase dbWriteAccess = this.getWritableDatabase();	    
	    ContentValues values = new ContentValues();
	    values.put(COLUMN_CONTENT, note.getContent());
		values.put(COLUMN_TITLE, note.getTitle());
		values.put(COLUMN_ID, note.getId().toString());
		values.put(COLUMN_CREATED_AT, note.getCreatedAt().toString());
		values.put(COLUMN_COLOR, note.getColor());

	    long rowId = dbWriteAccess.insert(TABLE_NAME, null, values); // if row not added rowId equal -1
	    if(rowId != -1){
	    	Log.d("noteDebug", "row inserted successfully "+rowId);
	    }
	    return rowId;
	}
	
	// query to get all notes
	public List<Note> readAllTodo(){
		List<Note> notes = new ArrayList<Note>();
	    String selectQuery = "SELECT  * FROM " + TABLE_NAME;
	    SQLiteDatabase dbReadAccess = this.getReadableDatabase();
	    Cursor c = dbReadAccess.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (c.moveToFirst()) {
	        do {
	        	Note note = new Note();
				note.setId(c.getString((c.getColumnIndex(COLUMN_ID))));
				note.setTitle(c.getString(c.getColumnIndex(COLUMN_TITLE)));
				note.setContent(c.getString(c.getColumnIndex(COLUMN_CONTENT)));
				note.setCreatedAt(new Date(c.getString(c.getColumnIndex(COLUMN_CREATED_AT))));
				note.setColor(c.getInt(c.getColumnIndex(COLUMN_COLOR)));

	        	notes.add(note);
	        } while (c.moveToNext());
	    }	 
	    return notes;
	}
	
	/*
	 * Updating a note
	 */
	public int updateTodo(Note note) {
	    SQLiteDatabase dbWriteAccess = this.getWritableDatabase();	 
	    ContentValues values = new ContentValues();
	    values.put(COLUMN_CONTENT, note.getContent());
		values.put(COLUMN_TITLE, note.getTitle());
		values.put(COLUMN_CREATED_AT, note.getCreatedAt().toString());
	    // updating row
	    return dbWriteAccess.update(TABLE_NAME, values, COLUMN_ID + " = ?",
	            new String[] { note.getId()});
	}
	
	
	/*
	 * Deleting a TO-DO
	 */
	public void deleteTodo(String id) {
	    SQLiteDatabase dbWriteAccess = this.getWritableDatabase();
	    dbWriteAccess.delete(TABLE_NAME, COLUMN_ID + " = ?",
	            new String[] { id });
	}	
	
	// closing database
    public void closeDB() {
        SQLiteDatabase dbReadAccess = this.getReadableDatabase(); 
        if (dbReadAccess != null && dbReadAccess.isOpen())
        	dbReadAccess.close();
    }
    


}