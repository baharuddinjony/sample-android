package com.sample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.sample.adapters.ReminderAdapter_doctor;
import com.sample.db.DatabaseHelper_Doctor;
import com.sample.models.Reminder;

import java.util.List;

/**
 * Created by User on 2/14/2017.
 */

public class NotificationActivity_doctor extends AppCompatActivity {

    @BindView(R.id.list_reminder_doctor) ListView mDoctorRemiders;
    private DatabaseHelper_Doctor databaseHelper_Doctor = null;
    private ReminderAdapter_doctor reminderAdapter_doctor = null;
    private List<Reminder> reminders2=null;

    public static final int REMIDER_REQUEST_CODE = 0x01;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_doctors);
        ButterKnife.bind(this);
        databaseHelper_Doctor = new DatabaseHelper_Doctor(this);
        showReminders();
        registerListener();
    }

    @OnClick(R.id.btn_set_reminder_doctor) public void reminder() {
        Intent intent = new Intent(this, DialogeDoctorReminderActivity.class);
        startActivityForResult(intent, REMIDER_REQUEST_CODE);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REMIDER_REQUEST_CODE) {
            showReminders();
        }
    }

    private void showReminders() {
        reminders2 = databaseHelper_Doctor.getAllReminders();
        reminderAdapter_doctor = new ReminderAdapter_doctor(this, reminders2);
        mDoctorRemiders.setAdapter(reminderAdapter_doctor);
    }
    private void registerListener(){
        mDoctorRemiders.setOnItemLongClickListener (new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView parent, final View view, final int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(
                       NotificationActivity_doctor.this);
                alert.setTitle("Alert!!");
                alert.setMessage("Are you sure to delete record");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TextView id=(TextView)view.findViewById(R.id.txt_reminderid_doctor);
                        reminders2.remove(position);
                        databaseHelper_Doctor.deleteDoctorReminder(Integer.parseInt(id.getText().toString()));
                        reminderAdapter_doctor.notifyDataSetChanged();
                        dialog.dismiss();

                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

                alert.show();
                return true;
            }
        });
    }

}
