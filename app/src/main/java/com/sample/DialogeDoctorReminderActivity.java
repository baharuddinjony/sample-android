package com.sample;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by TEST_GAME on 3/21/2017.
 */
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.sample.db.DatabaseHelper_Doctor;
import com.sample.models.Reminder;

import java.util.Calendar;

public class DialogeDoctorReminderActivity extends AppCompatActivity {
    @BindView(R.id.txt_doctor_reminder_name) EditText mDoctorReminderTitle;
    @BindView(R.id.txt_doctor_reminder_details) EditText mDoctorReminderDetails;
    private static Button mDoctorReminderDate;
    private static Button mDoctorReminderTime;
    @BindView(R.id.btn_reminder_save_doctor) Button mDoctorReminderSave;
    private DatabaseHelper_Doctor databaseHelper_Doctor = null;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialoge_reminder_doctor);
        ButterKnife.bind(this);
        mDoctorReminderDate = (Button) findViewById(R.id.btn_reminder_date_doctor);
        mDoctorReminderTime = (Button) findViewById(R.id.btn_reminder_time_doctor);
        databaseHelper_Doctor = new DatabaseHelper_Doctor(this);
    }

   @OnClick(R.id.btn_reminder_date_doctor) public void doctorreminderDate(){
       DialogFragment newFragment=new DialogeDoctorReminderActivity.ReminderDatePickerFragment();
       newFragment.show(getSupportFragmentManager(),"datePicker");
   }

    @OnClick(R.id.btn_reminder_time_doctor) public void doctorreminderTime()
    {
        DialogFragment newFragment=new DialogeDoctorReminderActivity.TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),"timePicker");
    }

    @OnClick(R.id.btn_reminder_save_doctor) public void setmdoctorReminderSave() {
        Reminder reminder2 = new Reminder();
        reminder2.setDoctorTitle(mDoctorReminderTitle.getText().toString());
        reminder2.setDoctorMessage(mDoctorReminderDetails.getText().toString());
        reminder2.setDoctorDate(mDoctorReminderDate.getText().toString());
        reminder2.setDoctorTime(mDoctorReminderTime.getText().toString());
        databaseHelper_Doctor.addDoctorReminder(reminder2);
        Intent intent = new Intent();
        setResult(NotificationActivity_doctor.REMIDER_REQUEST_CODE, intent);
        finish();
    }
    public static class ReminderDatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            mDoctorReminderDate.setText(day + "/" + (month + 1) + "/" + year);
        }
    }
    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mDoctorReminderTime.setText(hourOfDay+":"+minute);
        }
    }

}
