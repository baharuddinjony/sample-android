package com.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.sample.adapters.ReminderAdapter;
import com.sample.db.DatabaseHelper;
import com.sample.models.Reminder;
import java.util.List;

/**
 * Created by User on 2/14/2017.
 */

public class NotificationActivity extends AppCompatActivity {

  @BindView(R.id.list_reminder) ListView mRemiders;
  private DatabaseHelper databaseHelper = null;
  private ReminderAdapter reminderAdapter = null;

  public static final int REMIDER_REQUEST_CODE = 0x010;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_remainder);
    ButterKnife.bind(this);
    databaseHelper = new DatabaseHelper(this);
    showReminders();
  }

  @OnClick(R.id.btn_reminder) public void reminder() {
    Intent intent = new Intent(this, DialogeReminderActivity.class);
    startActivityForResult(intent, REMIDER_REQUEST_CODE);
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REMIDER_REQUEST_CODE) {
      showReminders();
    }
  }

  private void showReminders() {
    List<Reminder> reminders = databaseHelper.getAllReminders();
    reminderAdapter = new ReminderAdapter(this, reminders);
    mRemiders.setAdapter(reminderAdapter);
  }

}
