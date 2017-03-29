package com.sample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sample.models.Reminder;
import com.sample.models.WomanRegistration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/15/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

  // All Static variables
  // Database Version
  private static final int DATABASE_VERSION = 1;

  // Database Name
  private static final String DATABASE_NAME = "contactsManager";

  // Registration table name
  private static final String TABLE_REGISTRATION = "registration";
  private static final String TABLE_REMINDER = "reminder";

  // Registration Table Columns names
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

  private static final String KEY_REM_ID = "id";
  private static final String KEY_REM_TITLE = "title";
  private static final String KEY_REM_MESSAGE = "message";
  private static final String KEY_REM_DATE = "rem_date";
  private static final String KEY_REM_TIME = "rem_time";

  public DatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  // Creating Tables
  @Override public void onCreate(SQLiteDatabase db) {
    String CREATE_REG_TABLE = "CREATE TABLE "
        + TABLE_REGISTRATION
        + "("
        + KEY_ID
        + " INTEGER PRIMARY KEY,"
        + KEY_NAME
        + " TEXT,"
        + KEY_DIVISION
        + " TEXT,"
        + KEY_DISTRICT
        + " TEXT,"
        + KEY_OPAZILA
        + " TEXT,"
        + KEY_UNION
        + " TEXT,"
        + KEY_MOBILE
        + " TEXT,"
        + KEY_LAP
        + " TEXT,"
        + KEY_DUE
        + " TEXT,"
        + KEY_CYCLE
        + " INTEGER,"
        + KEY_OVULATION
        + " INTEGER,"
        + KEY_WEIGHT
        + " REAL,"
        + KEY_HEIGHT
        + " INTEGER"
        + ")";
    String CREATE_REMINDER_TABLE = "CREATE TABLE "
        + TABLE_REMINDER
        + "("
        + KEY_REM_ID
        + " INTEGER PRIMARY KEY,"
        + KEY_REM_TITLE
        + " TEXT,"
        + KEY_REM_MESSAGE
        + " TEXT,"
        + KEY_REM_DATE
        + " TEXT,"
        + KEY_REM_TIME
        + " TEXT"
        + ")";
    db.execSQL(CREATE_REG_TABLE);
    db.execSQL(CREATE_REMINDER_TABLE);
  }

  // Upgrading database
  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Drop older table if existed
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTRATION);
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_REMINDER);
    // Create tables again
    onCreate(db);
  }

  public void addWoman(WomanRegistration womanRegistration) {
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
  public void updateWoman(WomanRegistration womanRegistration) {
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
    db.update(TABLE_REGISTRATION,values,"id="+womanRegistration.getId(),null);
    db.close();
  }
  public int getRegistrationCount() {
    String countQuery = "SELECT  * FROM " + TABLE_REGISTRATION;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(countQuery, null);
    int count = cursor.getCount();
    cursor.close();
    // return count
    return count;
  }

  public WomanRegistration getRegistration() {
    String countQuery = "SELECT  * FROM " + TABLE_REGISTRATION ;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(countQuery, null);
    WomanRegistration registration = new WomanRegistration();
    if (cursor.moveToFirst()) {
      registration.setId(Integer.parseInt(cursor.getString(0)));
      registration.setFullName(cursor.getString(1));
      registration.setDivision(cursor.getString(2));
      registration.setDistrict(cursor.getString(3));
      registration.setOpazila(cursor.getString(4));
      registration.setUnion(cursor.getString(5));
      registration.setMobile(cursor.getString(6));
      registration.setLmpDate(cursor.getString(7));
      registration.setDueDate(cursor.getString(8));
      registration.setCycleDays(Integer.parseInt(cursor.getString(9)));
      registration.setOvulationDays(Integer.parseInt(cursor.getString(10)));
      registration.setPrePregnancyWeight(Float.parseFloat(cursor.getString(11)));
      registration.setPrePregnancyHeight(Integer.parseInt(cursor.getString(12)));
    }
    cursor.close();

    return registration;
  }

  public void addReminder(Reminder reminder) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();

    values.put(KEY_REM_TITLE, reminder.getTitle());
    values.put(KEY_REM_MESSAGE, reminder.getMessage());
    values.put(KEY_REM_DATE, reminder.getDate());
    values.put(KEY_REM_TIME, reminder.getTime());
    // Inserting Row
    db.insert(TABLE_REMINDER, null, values);
    db.close();
  }

  public int getReminderCount() {
    String countQuery = "SELECT  * FROM " + TABLE_REMINDER;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(countQuery, null);
    int count = cursor.getCount();
    cursor.close();
    // return count
    return count;
  }

  public void deleteReminder(int id) {
    SQLiteDatabase db = this.getWritableDatabase();
    db.delete(TABLE_REMINDER, KEY_ID + " = ?", new String[] { String.valueOf(id) });
    db.close();
  }

  public List<Reminder> getAllReminders() {
    List<Reminder> contactList = new ArrayList<>();
    // Select All Query
    String selectQuery = "SELECT  * FROM " + TABLE_REMINDER;

    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
      do {
        Reminder reminder = new Reminder();
        reminder.setId(Integer.parseInt(cursor.getString(0)));
        reminder.setTitle(cursor.getString(1));
        reminder.setMessage(cursor.getString(2));
        reminder.setDate(cursor.getString(3));
        reminder.setTime(cursor.getString(4));
        // Adding contact to list
        contactList.add(reminder);
      } while (cursor.moveToNext());
    }

    // return contact list
    return contactList;
  }
}