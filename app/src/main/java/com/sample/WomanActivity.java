package com.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.sample.db.DatabaseHelper;

/**
 * Created by User on 1/30/2017.
 */

public class WomanActivity extends AppCompatActivity {
  @BindView(R.id.txt_registration) TextView mRegistration;
  @BindView(R.id.txt_weight_status) TextView mWeight;
  @BindView(R.id.txt_date_status) TextView mDueStatus;
  @BindView(R.id.txt_week_info) TextView mWeek;
  @BindView(R.id.txt_baby_this_week) TextView mThisWeek;
  @BindView(R.id.txt_daily_tips) TextView mDailyTips;
  @BindView(R.id.txt_set_reminder) TextView mReminder;
  @BindView(R.id.txt_others) TextView mOthers;
  DatabaseHelper databaseHelper = null;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_woman);
    ButterKnife.bind(this);
    databaseHelper=new DatabaseHelper(getApplicationContext());
    checkRegistration();
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
    checkRegistration();
  }

  @Override protected void onResume() {
    super.onResume();
    checkRegistration();
  }

  private void checkRegistration() {

    int count = databaseHelper.getRegistrationCount();
    if (count > 0) {
      mRegistration.setVisibility(View.GONE);
    } else {
      enable(false);
    }
  }

  @OnClick(R.id.txt_registration) public void womanReg() {
    Intent intent = new Intent(this, WomanRegistrationActivity.class);
    startActivity(intent);
  }

  @OnClick(R.id.txt_date_status) public void dateStatus() {
    Intent intent = new Intent(this, DateStatusActivity.class);
    startActivity(intent);
  }

  @OnClick(R.id.txt_weight_status) public void weightStatus() {
    Intent intent = new Intent(this, WeightStatusActivity.class);
    startActivity(intent);
  }

  @OnClick(R.id.txt_week_info) public void weekInfo() {
    Intent intent = new Intent(this, WeekInfoActivity.class);
    startActivity(intent);
  }

  @OnClick(R.id.txt_baby_this_week) public void babyThisWeek() {
    Intent intent = new Intent(this, ThisWeekActivity.class);
    startActivity(intent);
  }

  @OnClick(R.id.txt_daily_tips) public void dailyTips() {
    Intent intent = new Intent(this, DailyTipsActivity.class);
    startActivity(intent);
  }

  @OnClick(R.id.txt_set_reminder) public void reminder() {
    Intent intent = new Intent(this, NotificationActivity.class);
    startActivity(intent);
  }

  @OnClick(R.id.txt_others) public void other() {
    Intent intent = new Intent(this, OtherActivity.class);
    startActivity(intent);
  }

  private void enable(boolean isEnable) {
    mWeight.setVisibility(View.GONE);
    mDueStatus.setVisibility(View.GONE);
    mWeek.setVisibility(View.GONE);
    mThisWeek.setVisibility(View.GONE);
    mOthers.setVisibility(View.GONE);
    mDailyTips.setVisibility(View.GONE);
    mReminder.setVisibility(View.GONE);
  }
}
