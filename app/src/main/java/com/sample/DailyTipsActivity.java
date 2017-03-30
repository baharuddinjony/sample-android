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

public class DailyTipsActivity extends AppCompatActivity {
  @BindView(R.id.txt_weekly_tips) TextView mThisWeek;
  @BindView(R.id.txt_weekly_tips_details) TextView mThisWeekDetails;
  private DatabaseHelper db;
  private SimpleDateFormat dateFormat = null;
  private WomanRegistration reg = null;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_daily_tips);
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
    int week = ((int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)) / 7;
    showData(week);
  }

  private void showData(int counter) {
    switch (counter) {
      case 1:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwone));
        break;
      case 2:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwtwo));
        break;
      case 3:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwthree));
        break;
      case 4:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwfour));
        break;
      case 5:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwfive));
        break;
      case 6:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwsix));
        break;
      case 7:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwseven));
        break;
      case 8:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iweight));
        break;
      case 9:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwnine));
        break;
      case 10:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwten));
        break;
      case 11:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iweleven));
        break;
      case 12:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwtwelve));
        break;
      case 13:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwthirteen));
        break;
      case 14:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwfourteen));
        break;
      case 15:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwfifteen));
        break;
      case 16:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwsixteen));
        break;
      case 17:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwseventeen));
        break;
      case 18:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iweightteen));
        break;
      case 19:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwnineteen));
        break;
      case 20:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwtwenty));
        break;
      case 21:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwtwenty_one));
        break;
      case 22:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwtwenty_two));
        break;
      case 23:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwtwenty_three));
        break;
      case 24:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwtwenty_four));
        break;
      case 25:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwtwenty_five));
        break;
      case 26:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwtwenty_six));
        break;
      case 27:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwtwenty_seven));
        break;
      case 28:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwtwenty_eight));
        break;
      case 29:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwtwenty_nine));
        break;
      case 30:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwthirty));
        break;
      case 31:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwthirty_one));
        break;
      case 32:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwthirty_two));
        break;
      case 33:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwthirty_three));
        break;
      case 34:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwthirty_four));
        break;
      case 35:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwthirty_five));
        break;
      case 36:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwthirty_six));
        break;
      case 37:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwthirty_seven));
        break;
      case 38:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwthirty_eight));
        break;
      case 39:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwthirty_nine));
        break;
      case 40:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwfourty));
        break;
      case 41:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.iwfourty_one));
        break;
      case 42:
        mThisWeek.setText("This is week "+counter);
        mThisWeekDetails.setText(getResources().getString(R.string.wfourty_two));
        break;
      default:
        mThisWeek.setText("This is first week ");
        mThisWeekDetails.setText(getResources().getString(R.string.iwone));
        break;
    }
  }
}
