package com.sample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sample.models.DoctorRegistration;
import com.sample.models.Reminder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/15/2017.
 */

public class DatabaseHelper_Doctor extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager2";

    // Registration table name
     private static final String TABLE_REGISTRATION_DOCTOR = "registration2";
    private static final String TABLE_REMINDER_doctor = "reminder_doctor";

    // Registration Table Columns names
    private static final String KEY_ID2 = "id2";
    private static final String KEY_NAME2 = "mfull_name2";
    private static final String KEY_SPECIALIZATION = "mspecialization";
    private static final String KEY_AGE = "mage";
    private static final String KEY_GENDER = "mgender";

    private static final String KEY_MOBILE2 = "mobile2";

    private static final String KEY_HOSPITAL_NAME = "mhospital_name";
    private static final String KEY_HOSPITAL_NUMBER = "mhospital_number";
    private static final String KEY_HOSPITAL_CITY="mhospital_city";


    private static final String KEY_REM_ID_doctor = "id_doctor";
    private static final String KEY_REM_TITLE_doctor = "title_doctor";
    private static final String KEY_REM_MESSAGE_doctor = "message_doctor";
    private static final String KEY_REM_DATE_doctor = "rem_date_doctor";
    private static final String KEY_REM_TIME_doctor = "rem_time_doctor";

    public DatabaseHelper_Doctor(Context context2) {
        super(context2, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override public void onCreate(SQLiteDatabase db2) {
       String CREATE_REG_TABLE_DOCTOR = "CREATE TABLE " + TABLE_REGISTRATION_DOCTOR + "("
                + KEY_ID2 + " INTEGER PRIMARY KEY,"
                + KEY_NAME2 + " TEXT,"
                + KEY_SPECIALIZATION + " TEXT,"
                + KEY_AGE + " INTEGER,"
                + KEY_GENDER + " TEXT,"
                + KEY_MOBILE2 + " TEXT,"
                + KEY_HOSPITAL_NAME + " TEXT,"
                + KEY_HOSPITAL_NUMBER + " TEXT,"
                + KEY_HOSPITAL_CITY + " TEXT" + ")";
        String CREATE_doctor_REMINDER_TABLE = "CREATE TABLE " + TABLE_REMINDER_doctor + "("
                + KEY_REM_ID_doctor + " INTEGER PRIMARY KEY,"
                + KEY_REM_TITLE_doctor + " TEXT,"
                + KEY_REM_MESSAGE_doctor + " TEXT,"
                + KEY_REM_DATE_doctor + " TEXT,"
                + KEY_REM_TIME_doctor + " TEXT" + ")";
        db2.execSQL(CREATE_REG_TABLE_DOCTOR);
        db2.execSQL(CREATE_doctor_REMINDER_TABLE);
    }

    // Upgrading database
    @Override public void onUpgrade(SQLiteDatabase db2, int oldVersion, int newVersion) {
        // Drop older table if existed
        db2.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTRATION_DOCTOR);
        db2.execSQL("DROP TABLE IF EXISTS " + TABLE_REMINDER_doctor);
        // Create tables again
        onCreate(db2);
    }
    public void addDoctor(DoctorRegistration doctorRegistration){
        SQLiteDatabase db2 = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID2,doctorRegistration.getId2());
        values.put(KEY_NAME2,doctorRegistration.getFullName2());
        values.put(KEY_MOBILE2,doctorRegistration.getMobile2());
        values.put(KEY_HOSPITAL_NAME,doctorRegistration.getHospital_name2());
        values.put(KEY_HOSPITAL_CITY,doctorRegistration.getCity2());
        values.put(KEY_HOSPITAL_NUMBER,doctorRegistration.getHospital_mobile2());
        values.put(KEY_AGE,doctorRegistration.getAge());
        values.put(KEY_GENDER,doctorRegistration.getGender());
        values.put(KEY_SPECIALIZATION,doctorRegistration.getSpecialization());

        // Inserting Row
        try {
            db2.insert(TABLE_REGISTRATION_DOCTOR, null, values);
        }catch (Exception e){
        }
        db2.close();
    }


    public int getRegistrationCount2() {
        String countQuery = "SELECT  * FROM " + TABLE_REGISTRATION_DOCTOR;
        SQLiteDatabase db2 = this.getReadableDatabase();
        Cursor cursor = db2.rawQuery(countQuery, null);
        int count2=cursor.getCount();
        cursor.close();
        // return count
        return count2;
    }
    public void addDoctorReminder(Reminder reminder2){
        SQLiteDatabase db2 = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_REM_TITLE_doctor, reminder2.getDoctorTitle());
        values.put(KEY_REM_MESSAGE_doctor, reminder2.getDoctorMessage());
        values.put(KEY_REM_DATE_doctor, reminder2.getDoctorDate());
        values.put(KEY_REM_TIME_doctor, reminder2.getDoctorTime());
        // Inserting Row
        db2.insert(TABLE_REMINDER_doctor, null, values);
        db2.close();
    }
    public int getDoctorReminderCount() {
        String countQuery = "SELECT  * FROM " + TABLE_REMINDER_doctor;
        SQLiteDatabase db2 = this.getReadableDatabase();
        Cursor cursor = db2.rawQuery(countQuery, null);
        int count=cursor.getCount();
        cursor.close();
        // return count
        return count;
    }
    public void deleteDoctorReminder(int id2) {
        SQLiteDatabase db2 = this.getWritableDatabase();
       db2.delete(TABLE_REMINDER_doctor, KEY_ID2 + " = ?",
               new String[] { String.valueOf(id2) });
        db2.close();
    }
    public List<Reminder> getAllReminders() {
        List<Reminder> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_REMINDER_doctor;

        SQLiteDatabase db2 = this.getWritableDatabase();
        Cursor cursor = db2.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Reminder reminder2=new Reminder();
                reminder2.setDoctorId(Integer.parseInt(cursor.getString(0)));
                reminder2.setDoctorTitle(cursor.getString(1));
                reminder2.setDoctorMessage(cursor.getString(2));
                reminder2.setDoctorDate(cursor.getString(3));
                reminder2.setDoctorTime(cursor.getString(4));
                // Adding contact to list
                contactList.add(reminder2);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }



}