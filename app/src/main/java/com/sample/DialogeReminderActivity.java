package com.sample;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.sample.db.DatabaseHelper;
import com.sample.models.Reminder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by User on 2/14/2017.
 */

public class DialogeReminderActivity extends AppCompatActivity {
  @BindView(R.id.txt_reminder_name) EditText mReminderTitle;
  @BindView(R.id.txt_reminder_details) EditText mReminderDetails;
  private static Button mReminderDate;
  private static Button mReminderTime;
  @BindView(R.id.btn_reminder_save) Button mReminderSave;

  private DatabaseHelper databaseHelper = null;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dialoge_reminder);
    ButterKnife.bind(this);
    mReminderDate = (Button) findViewById(R.id.btn_reminder_date);
    mReminderTime = (Button) findViewById(R.id.btn_reminder_time);
    databaseHelper = new DatabaseHelper(this);
  }

  @OnClick(R.id.btn_reminder_date) public void reminderDate() {
    DialogFragment newFragment = new ReminderDatePickerFragment();
    newFragment.show(getSupportFragmentManager(), "datePicker");
  }

  @OnClick(R.id.btn_reminder_time) public void reminderTime() {
    DialogFragment newFragment = new TimePickerFragment();
    newFragment.show(getSupportFragmentManager(), "timePicker");
  }

  @OnClick(R.id.btn_reminder_save) public void setmReminderSave() {
    Reminder reminder = new Reminder();
    reminder.setTitle(mReminderTitle.getText().toString());
    reminder.setMessage(mReminderDetails.getText().toString());
    reminder.setDate(mReminderDate.getText().toString());
    reminder.setTime(mReminderTime.getText().toString());
    databaseHelper.addReminder(reminder);
    setAlarm();
    Intent intent = new Intent();
    setResult(NotificationActivity.REMIDER_REQUEST_CODE, intent);
    finish();
  }

  private void setAlarm() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    Intent intent = new Intent(this, MyBroadcastReceiver.class);
    intent.putExtra("name",mReminderTitle.getText().toString());
    intent.putExtra("details",mReminderDetails.getText().toString());
    PendingIntent pendingIntent =
        PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
    String dateWithTime=mReminderDate.getText().toString()+" "+mReminderTime.getText().toString();
    Date d=null;
    try {
      d=dateFormat.parse(dateWithTime);

    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    alarmManager.set(AlarmManager.RTC_WAKEUP, d.getTime(),
        pendingIntent);

    Toast.makeText(this, "Alarm set in " + dateWithTime , Toast.LENGTH_LONG).show();
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
      mReminderDate.setText(day + "/" + (month + 1) + "/" + year);
    }
  }

  public static class TimePickerFragment extends DialogFragment
      implements TimePickerDialog.OnTimeSetListener {

    @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
      // Use the current time as the default values for the picker
      final Calendar c = Calendar.getInstance();
      int hour = c.get(Calendar.HOUR_OF_DAY);
      int minute = c.get(Calendar.MINUTE);

      // Create a new instance of TimePickerDialog and return it
      return new TimePickerDialog(getActivity(), this, hour, minute,
          DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
      mReminderTime.setText(hourOfDay + ":" + minute);
    }
  }
}