package com.sample;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import com.sample.db.DatabaseHelper;
import com.sample.models.WomanRegistration;
import java.util.Calendar;

/**
 * Created by User on 1/30/2017.
 */

public class WomanRegistrationActivity extends AppCompatActivity {

  @BindView(R.id.txt_woman_fullname) EditText mFullName;
  @BindView(R.id.spn_woman_district) Spinner mDistrict;
  @BindView(R.id.spn_woman_division) Spinner mDivision;


  @BindView(R.id.layout_woman) LinearLayout mLayoutWoman;
  @BindView(R.id.radio_woman) RadioButton mWoman;
  @BindView(R.id.radio_other) RadioButton mOther;


  @BindView(R.id.txt_woman_upazila) EditText mOpazilla;
  @BindView(R.id.txt_woman_union) EditText mUnion;
  @BindView(R.id.txt_woman_mobile) EditText mMobile;
  static Button mLmpDate;
  static Button mDueDate;
  @BindView(R.id.txt_woman_cycle_time) EditText mCycleDay;
  @BindView(R.id.txt_woman_ovulation) EditText mOvulationDay;
  @BindView(R.id.txt_woman_prepregnancy) EditText mWeight;
  @BindView(R.id.txt_woman_prepregnancy_height) EditText mHeight;
  @BindArray(R.array.division) String[] mDivisions;
  @BindArray(R.array.dhaka_district) String[] mDhakaDistricts;
  @BindArray(R.array.ctg_distric) String[] mCtgDistricts;
  private DatabaseHelper db;
  boolean isEdit = false;
  private WomanRegistration womanRegistration = null;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_woman_registration);
    ButterKnife.bind(this);
    mLmpDate = (Button) findViewById(R.id.btn_woman_lmp_date);
    mDueDate = (Button) findViewById(R.id.btn_woman_due_date);
    mOther.setSelected(true);
    db = new DatabaseHelper(this);
    extractBundle();
  }

  private void extractBundle() {
    if (getIntent().getExtras() != null) {
      isEdit = getIntent().getExtras().getBoolean("key");
      if (isEdit) {
        womanRegistration = db.getRegistration();
        mFullName.setText(womanRegistration.getFullName());
        mDivision.setSelection(0);
        mDistrict.setSelection(0);
        mUnion.setText(womanRegistration.getUnion());
        mOpazilla.setText(womanRegistration.getOpazila());
        mMobile.setText(womanRegistration.getMobile());
        mLmpDate.setText(womanRegistration.getLmpDate());
        mDueDate.setText(womanRegistration.getDueDate());
        mWeight.setText(String.valueOf(womanRegistration.getPrePregnancyWeight()));
        mHeight.setText(String.valueOf(womanRegistration.getPrePregnancyHeight()));
      }
    }else {
      womanRegistration = new WomanRegistration();
    }
  }

  @Override protected void onStart() {
    super.onStart();
    mLayoutWoman.setVisibility(View.GONE);
  }

  @OnItemSelected(R.id.spn_woman_division)
  public void spinnerItemSelected(Spinner spinner, int position) {
    Toast.makeText(this, position + " ", Toast.LENGTH_LONG).show();
    ArrayAdapter<String> adapter = null;
    switch (position) {
      case 0:
        adapter =
            new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mDhakaDistricts);
        mDistrict.setAdapter(adapter);
        break;
      case 1:
        adapter =
            new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mCtgDistricts);
        mDistrict.setAdapter(adapter);
        break;
      default:
        break;
    }
  }

  @OnClick(R.id.radio_woman) public void woman() {
    if (mOther.isChecked()) {
      mOther.setChecked(false);
      mLayoutWoman.setVisibility(View.VISIBLE);
    }
  }

  @OnClick(R.id.radio_other) public void other() {
    if (mWoman.isChecked()) {
      mWoman.setChecked(false);
      mLayoutWoman.setVisibility(View.GONE);
    }
  }

  @OnClick(R.id.btn_woman_due_date) public void setmDueDate() {
    DialogFragment newFragment = new DueDatePickerFragment();
    newFragment.show(getSupportFragmentManager(), "datePicker");
  }

  @OnClick(R.id.btn_woman_lmp_date) public void setmLmpDateDate() {
    DialogFragment newFragment = new LmpDatePickerFragment();
    newFragment.show(getSupportFragmentManager(), "datePicker");
  }

  @OnClick(R.id.btn_woman_save) public void save() {

    womanRegistration.setFullName(mFullName.getText().toString());
    womanRegistration.setDivision(mDivision.getSelectedItem().toString());
    womanRegistration.setDistrict(mDistrict.getSelectedItem().toString());
    womanRegistration.setUnion(mUnion.getText().toString());
    womanRegistration.setOpazila(mOpazilla.getText().toString());
    womanRegistration.setMobile(mMobile.getText().toString());
    womanRegistration.setLmpDate(mLmpDate.getText().toString());
    womanRegistration.setDueDate(mDueDate.getText().toString());
    womanRegistration.setPrePregnancyWeight(Float.parseFloat(
        mWeight.getText().toString().equals("") ? "0" : mWeight.getText().toString()));
    womanRegistration.setPrePregnancyHeight(Integer.parseInt(
        mHeight.getText().toString().equals("") ? "0" : mHeight.getText().toString()));
    if (isEdit) {
      db.updateWoman(womanRegistration);
    } else {
      db.addWoman(womanRegistration);
    }

    Intent intent = new Intent(getApplicationContext(), WomanActivity.class);
    startActivity(intent);
  }

  public static class LmpDatePickerFragment extends DialogFragment
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
      mLmpDate.setText(day + "/" + (month + 1) + "/" + year);
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
      mDueDate.setText(day + "/" + (month + 1) + "/" + year);
    }
  }
}