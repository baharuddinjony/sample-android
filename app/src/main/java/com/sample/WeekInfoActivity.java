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
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 2/14/2017.
 */

public class WeekInfoActivity extends AppCompatActivity {
  @BindView(R.id.txt_this_week) TextView mThisWeek;
  @BindView(R.id.txt_this_week_details) TextView mThisWeekDetails;
  private DatabaseHelper db;
  private SimpleDateFormat dateFormat = null;
  private WomanRegistration reg = null;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_week_info);
    ButterKnife.bind(this);
    db = new DatabaseHelper(this);
    dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    reg = db.getRegistration();
    long diff = 0;

    try {
      diff = new Date().getTime() - dateFormat.parse(reg.getLmpDate()).getTime();
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    int week = ((int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS))/7;
    showData(week);
  }

  private void showData(int counter) {
    switch (counter) {
      case 1:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wone));
        break;
      case 2:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wtwo));
        break;
      case 3:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wthree));
        break;
      case 4:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wfour));
        break;
      case 5:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wfive));
        break;
      case 6:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wsix));
        break;
      case 7:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wseven));
        break;
      case 8:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.weight));
        break;
      case 9:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wnine));
        break;
      case 10:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wten));
        break;
      case 11:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.weleven));
        break;
      case 12:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wtwelve));
        break;
      case 13:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wthirteen));
        break;
      case 14:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wfourteen));
        break;
      case 15:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wfifteen));
        break;
      case 16:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wsixteen));
        break;
      case 17:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wseventeen));
        break;
      case 18:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.weightteen));
        break;
      case 19:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wnineteen));
        break;
      case 20:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wtwenty));
        break;
      case 21:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wtwenty_one));
        break;
      case 22:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wtwenty_two));
        break;
      case 23:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wtwenty_three));
        break;
      case 24:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wtwenty_four));
        break;
      case 25:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wtwenty_five));
        break;
      case 26:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wtwenty_six));
        break;
      case 27:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wtwenty_seven));
        break;
      case 28:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wtwenty_eight));
        break;
      case 29:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wtwenty_nine));
        break;
      case 30:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wthirty));
        break;
      case 31:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wthirty_one));
        break;
      case 32:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wthirty_two));
        break;
      case 33:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wthirty_three));
        break;
      case 34:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wthirty_four));
        break;
      case 35:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wthirty_five));
        break;
      case 36:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wthirty_six));
        break;
      case 37:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wthirty_seven));
        break;
      case 38:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wthirty_eight));
        break;
      case 39:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wthirty_nine));
        break;
      case 40:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wfourty));
        break;
      case 41:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wfourty_one));
        break;
      case 42:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wfourty_two));
        break;
      default:
        mThisWeek.setText("This is first week");
        mThisWeekDetails.setText(getResources().getString(R.string.wone));
        break;
    }
  }
}
