package com.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by TEST_GAME on 3/19/2017.
 */

public class Other_doctorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others_doctors);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_set_reminder_doctor) public void reminder() {
        Intent intent = new Intent(this, NotificationActivity_doctor.class);
        startActivity(intent);
    }

}

