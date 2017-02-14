package com.sample;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by User on 2/14/2017.
 */

public class NotificationActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_remainder);
    ButterKnife.bind(this);
  }
  @OnClick(R.id.btn_reminder) public void reminder() {
    Intent intent = new Intent(this, DialogeReminderActivity.class);
    startActivity(intent);
  }

}
