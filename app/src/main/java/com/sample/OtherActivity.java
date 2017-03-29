package com.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by User on 2/14/2017.
 */

public class OtherActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_others);
    ButterKnife.bind(this);
  }
  @OnClick(R.id.btn_search_hospitals) public void searHospital() {
    Intent intent = new Intent(this, SearchHospitalActivity.class);
    startActivity(intent);
  }
  @OnClick(R.id.btn_search_doctors) public void searDoctor() {
    Intent intent = new Intent(this, SearchHospitalDoctorActivity.class);
    startActivity(intent);
  }
  @OnClick(R.id.btn_others_ovulation_planner) public void ovulation() {
    Intent intent = new Intent(this, OvulationActivity.class);
    startActivity(intent);
  }
  @OnClick(R.id.btn_others_all_week_tips) public void allWeek() {
    Intent intent = new Intent(this, AllWeekTipsActivity.class);
    startActivity(intent);
  }
  @OnClick(R.id.btn_others_child_care) public void childCare() {
    Intent intent = new Intent(this, ChildCareActivity.class);
    startActivity(intent);
  }
  @OnClick(R.id.btn_others_change_data) public void changeData() {
    Intent intent = new Intent(this, WomanRegistrationActivity.class);
    intent.putExtra("key",true);
    startActivity(intent);
  }
  @OnClick(R.id.btn_others_help) public void others() {
    Intent intent = new Intent(this, HelpActivity.class);
    startActivity(intent);
  }
}
