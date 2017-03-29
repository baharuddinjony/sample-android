package com.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.sample.db.DatabaseHelper;
import com.sample.models.WomanRegistration;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 2/14/2017.
 */

public class WeightStatusActivity extends AppCompatActivity {

  @BindView(R.id.txt_weight_input) EditText mWeightInput;
  @BindView(R.id.txt_weight_status) TextView mWeightStatus;
  private DatabaseHelper db;
  private WomanRegistration reg = null;
  private SimpleDateFormat dateFormat = null;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weight_status);
    ButterKnife.bind(this);
    db = new DatabaseHelper(this);
    dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    reg = db.getRegistration();
  }

  @OnClick(R.id.btn_weight_calculate) public void calculateWeight() {
    if (mWeightInput.getText().toString().equals("")) {
      Toast.makeText(this, "Enter Weight", Toast.LENGTH_LONG).show();
    } else {

      long diff=0,diffRemaining=0;

      try {
        diff=new Date().getTime() - dateFormat.parse(reg.getLmpDate()).getTime();
        long days=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        int week=(int)days/7;
        //now assume from weight table , weight range  will increase 2 kg after every five weeks
        float weight=reg.getPrePregnancyWeight()+ week/5 +2;
        float currentWeight=Float.parseFloat(mWeightInput.getText().toString());
        if(weight>currentWeight){
          mWeightStatus.setText("You are over weight for "+ (currentWeight-weight) +" Kg");
        }else {
          mWeightStatus.setText("You are under weight for "+ (weight- currentWeight) +" Kg");
        }

      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}



