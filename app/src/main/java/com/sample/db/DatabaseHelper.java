package com.sample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sample.models.WomanRegistration;

/**
 * Created by User on 2/15/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

  // All Static variables
  // Database Version
  private static final int DATABASE_VERSION = 1;

  // Database Name
  private static final String DATABASE_NAME = "contactsManager";

  // Contacts table name
  private static final String TABLE_REGISTRATION = "registration";

  // Contacts Table Columns names
  private static final String KEY_ID = "id";
  private static final String KEY_NAME = "full_name";
  private static final String KEY_DIVISION = "divison";
  private static final String KEY_DISTRICT = "district";
  private static final String KEY_OPAZILA = "opazila";
  private static final String KEY_UNION = "uni";
  private static final String KEY_MOBILE = "mobile";
  private static final String KEY_LAP = "lmpDate";
  private static final String KEY_DUE = "dueDate";
  private static final String KEY_CYCLE = "cycleDays";
  private static final String KEY_OVULATION = "ovulationDays";
  private static final String KEY_WEIGHT = "prePregnancyWeight";
  private static final String KEY_HEIGHT = "prePregnancyHeight";
  public DatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  // Creating Tables
  @Override public void onCreate(SQLiteDatabase db) {
    String CREATE_REG_TABLE = "CREATE TABLE " + TABLE_REGISTRATION + "("
        + KEY_ID + " INTEGER PRIMARY KEY,"
        + KEY_NAME + " TEXT,"
        + KEY_DIVISION + " TEXT,"
        + KEY_DISTRICT + " TEXT,"
        + KEY_OPAZILA + " TEXT,"
        + KEY_UNION + " TEXT,"
        + KEY_MOBILE + " TEXT,"
        + KEY_LAP + " TEXT,"
        + KEY_DUE + " TEXT,"
        + KEY_CYCLE + " INTEGER,"
        + KEY_OVULATION + " INTEGER,"
        + KEY_WEIGHT + " REAL,"
        + KEY_HEIGHT + " INTEGER" + ")";
    db.execSQL(CREATE_REG_TABLE);
  }

  // Upgrading database
  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Drop older table if existed
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTRATION);

    // Create tables again
    onCreate(db);
  }
  public void addWoman(WomanRegistration womanRegistration){
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(KEY_ID, womanRegistration.getId());
    values.put(KEY_NAME, womanRegistration.getFullName());
    values.put(KEY_DIVISION, womanRegistration.getDivision());
    values.put(KEY_DISTRICT, womanRegistration.getDistrict());
    values.put(KEY_OPAZILA, womanRegistration.getOpazila());
    values.put(KEY_UNION, womanRegistration.getUnion());
    values.put(KEY_MOBILE, womanRegistration.getMobile());
    values.put(KEY_LAP, womanRegistration.getLmpDate());
    values.put(KEY_DUE, womanRegistration.getDueDate());
    values.put(KEY_CYCLE, womanRegistration.getCycleDays());
    values.put(KEY_OVULATION, womanRegistration.getOvulationDays());
    values.put(KEY_WEIGHT, womanRegistration.getPrePregnancyWeight());
    values.put(KEY_HEIGHT, womanRegistration.getPrePregnancyHeight());
    // Inserting Row
    db.insert(TABLE_REGISTRATION, null, values);
    db.close();
  }
  public int getRegistrationCount() {
    String countQuery = "SELECT  * FROM " + TABLE_REGISTRATION;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(countQuery, null);
    int count=cursor.getCount();
    cursor.close();
    // return count
    return count;
  }
}