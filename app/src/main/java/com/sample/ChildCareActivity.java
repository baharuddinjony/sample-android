package com.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * Created by User on 2/14/2017.
 */

public class ChildCareActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_child_care);
    ButterKnife.bind(this);
  }
}
