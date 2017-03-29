package com.sample;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.sample.db.DatabaseHelper;
import com.sample.models.WomanRegistration;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 2/14/2017.
 */

public class DateStatusActivity extends AppCompatActivity {

  @BindView(R.id.txt_date_due_date) TextView mDueDate;
  @BindView(R.id.txt_date_lmp) TextView mLmpDate;
  @BindView(R.id.txt_date_pregnant_for) TextView mPregnantDate;
  @BindView(R.id.txt_date_fetal_age) TextView mFataAge;
  @BindView(R.id.txt_date_remaining_time) TextView mRemainingTime;
  private DatabaseHelper db;
  private SimpleDateFormat dateFormat = null;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_date_status);
    ButterKnife.bind(this);
    db = new DatabaseHelper(this);
    dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    WomanRegistration reg = db.getRegistration();
    mDueDate.setText(mDueDate.getText() + reg.getDueDate());
    mLmpDate.setText(mLmpDate.getText() + reg.getLmpDate());
    //Date pDate=null;
    Date  remaining=null;
    long diff=0,diffRemaining=0;

    try {
      diff=new Date().getTime() - dateFormat.parse(reg.getLmpDate()).getTime();
      //pDate=new Date();
      diffRemaining =dateFormat.parse(reg.getDueDate()).getTime()-new Date().getTime();

    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    c.add(Calendar.DATE, -1 *((int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+14)); // Adding 14 days

    mPregnantDate.setText(mPregnantDate.getText() +dateFormat.format(c.getTime()) );
    mFataAge.setText(mFataAge.getText() + String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) ));

    mRemainingTime.setText(mRemainingTime.getText() + String.valueOf(TimeUnit.DAYS.convert(diffRemaining, TimeUnit.MILLISECONDS) ));
  }
}
