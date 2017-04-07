package com.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;


import com.sample.db.DatabaseHelper_Doctor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by User on 1/30/2017.
 */

public class DoctorActivity extends AppCompatActivity {

  @BindView(R.id.tex_registration_doctor)
  TextView mRegistration2;
  @BindView(R.id.Appointment_req) TextView mappointment_req;
  @BindView(R.id.Appointment_list) TextView mappointment_list;
  @BindView(R.id.others_doctor) TextView mother_doctor;
   DatabaseHelper_Doctor databaseHelper_doctor=null;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_doctor);
    ButterKnife.bind(this);
    databaseHelper_doctor=new DatabaseHelper_Doctor(getApplicationContext());
    checkRegistration2();
  }


  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.options_menu, menu);

    // Associate searchable configuration with the SearchView
    /*SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));*/

    return true;
  }

  @Override protected void onRestart() {
    super.onRestart();
    checkRegistration2();
  }

  @Override protected void onResume() {
    super.onResume();
    checkRegistration2();
  }

  private void checkRegistration2() {

    int count2 = databaseHelper_doctor.getRegistrationCount2();
    if (count2 > 0) {
      mRegistration2.setVisibility(View.GONE);

    } else {
      enable(false);
    }
  }


  @OnClick(R.id.tex_registration_doctor)
  public void doctorReg() {
    Intent intent = new Intent(this, DoctorRegistrationActivity.class);
    startActivity(intent);
  }

  @OnClick(R.id.Appointment_req)
  public void app_req() {
    Intent intent = new Intent(this, Appointment_reguestActivity.class);
    startActivity(intent);
  }

  @OnClick(R.id.Appointment_list)
  public void app_list() {
    Intent intent = new Intent(this, Appointment_listActivity.class);
    startActivity(intent);
  }
    @OnClick(R.id.others_doctor)
    public void other_doctor() {
        Intent intent = new Intent(this, Other_doctorActivity.class);
        startActivity(intent);
    }

  private void enable(boolean isEnable) {
    mappointment_req.setVisibility(View.GONE);
    mappointment_list.setVisibility(View.GONE);
    mother_doctor.setVisibility(View.GONE);

  }
}

