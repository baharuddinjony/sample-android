package com.sample;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.sample.db.DatabaseHelper;
import com.sample.models.WomanRegistration;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 2/14/2017.
 */

public class OvulationActivity extends AppCompatActivity {
  static Button mSelectDate;
  @BindView(R.id.txt_reminder_details) EditText mCycleDays;
  @BindView(R.id.btn_ovulation_calculate) Button mCalculate;
  @BindView(R.id.txt_ovulation_status) TextView mStatusShow;
  private DatabaseHelper db;
  private WomanRegistration reg = null;
  private SimpleDateFormat dateFormat = null;
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ovulation);
    ButterKnife.bind(this);
    dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    mSelectDate = (Button) findViewById(R.id.btn_ovulation_select_date);
    db = new DatabaseHelper(this);
    reg = db.getRegistration();
  }

  @OnClick(R.id.btn_ovulation_select_date) public void setmSelectDate() {
    DialogFragment newFragment = new DueDatePickerFragment();
    newFragment.show(getSupportFragmentManager(), "datePicker");
  }

  @OnClick(R.id.btn_ovulation_calculate) public void setmCalculate() {
    try {
      int days=Integer.parseInt(mCycleDays.getText().toString());
      Date dt=dateFormat.parse(mSelectDate.getText().toString());
      Calendar c = Calendar.getInstance();
      c.setTime(dt);
      c.add(Calendar.DATE, days-19); // Adding 9 days
      mStatusShow.setText("Cycle 1 -> \n Fertile : "+dateFormat.format(c.getTime()));
      c.add(Calendar.DATE, 5); // Adding 5 days
      mStatusShow.setText(mStatusShow.getText()+" - "+dateFormat.format(c.getTime()));
      c.setTime(dt);
      c.add(Calendar.MONTH,9);
      c.add(Calendar.DATE,5);
      mStatusShow.setText(mStatusShow.getText()+"\n Due Date : "+dateFormat.format(c.getTime()));
      mStatusShow.setText(mStatusShow.getText()+"\n--------------------------------------------------------\n");
      c.setTime(dt);
      c.add(Calendar.DATE, days); // Adding 28 days
      c.add(Calendar.DATE, days-19); // Adding 9 days
      mStatusShow.setText(mStatusShow.getText()+"Cycle 2 -> \n Fertile : "+dateFormat.format(c.getTime()));
      c.add(Calendar.DATE, 5); // Adding 5 days
      mStatusShow.setText(mStatusShow.getText()+" - "+dateFormat.format(c.getTime()));
      c.add(Calendar.MONTH,9);
      c.add(Calendar.DATE,5);
      mStatusShow.setText(mStatusShow.getText()+"\n Due Date : "+dateFormat.format(c.getTime()));
    } catch (ParseException e) {
      e.printStackTrace();
    }

  }

  public static class DueDatePickerFragment extends DialogFragment
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
      mSelectDate.setText(day + "/" + (month + 1) + "/" + year);
    }
  }
}
