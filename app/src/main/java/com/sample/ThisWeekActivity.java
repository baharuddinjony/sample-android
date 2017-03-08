package com.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by User on 2/14/2017.
 */

public class ThisWeekActivity extends AppCompatActivity {

  @BindView(R.id.txt_weight_status) TextView mInfo;
  @BindView(R.id.img_week) ImageView mImage;
  @BindView(R.id.btn_previous) Button mPrevious;
  @BindView(R.id.btn_next) Button mNext;
  private int counter = 2;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_this_week);
    ButterKnife.bind(this);
    mPrevious.setEnabled(false);
    showData(2);
  }

  @OnClick(R.id.btn_previous) public void setPrevious() {
    if (counter >= 2) {
      mNext.setEnabled(true);
      mPrevious.setEnabled(true);
      showData(counter--);
    } else {
      mPrevious.setEnabled(false);
    }
  }

  @OnClick(R.id.btn_next) public void setNext() {
    if (counter >= 2 && counter <= 41) {
      mPrevious.setEnabled(true);
      mNext.setEnabled(true);
      showData(counter++);
    } else {
      mNext.setEnabled(false);
    }
  }

  private void showData(int counter) {
    switch (counter) {
      case 2:
        mInfo.setText("This is Week 2\n\n" + getResources().getString(R.string.two));
        mImage.setImageResource(R.drawable.two);
        break;
      case 3:
        mInfo.setText("This is  Week 3\n\n" + getResources().getString(R.string.three));
        mImage.setImageResource(R.drawable.three);
        break;
      case 4:
        mInfo.setText("This is  Week 4\n\n" + getResources().getString(R.string.four));
        mImage.setImageResource(R.drawable.four);
        break;
      case 5:
        mInfo.setText("This is  Week 5\n\n" + getResources().getString(R.string.five));
        mImage.setImageResource(R.drawable.five);
        break;
      case 6:
        mInfo.setText("This is  Week 6\n\n" + getResources().getString(R.string.six));
        mImage.setImageResource(R.drawable.six);
        break;
      case 7:
        mInfo.setText("This is  Week 7\n\n" + getResources().getString(R.string.seven));
        mImage.setImageResource(R.drawable.seven);
        break;
      case 8:
        mInfo.setText("This is  Week 8\n\n" + getResources().getString(R.string.eight));
        mImage.setImageResource(R.drawable.eight);
        break;
      case 9:
        mInfo.setText("This is  Week 9\n\n" + getResources().getString(R.string.nine));
        mImage.setImageResource(R.drawable.nine);
        break;
      case 10:
        mInfo.setText("This is  Week 10\n\n" + getResources().getString(R.string.ten));
        mImage.setImageResource(R.drawable.ten);
        break;
      case 11:
        mInfo.setText("This is  Week 11\n\n" + getResources().getString(R.string.eleven));
        mImage.setImageResource(R.drawable.eleven);
        break;
      case 12:
        mInfo.setText("This is  Week 12\n\n" + getResources().getString(R.string.twelve));
        mImage.setImageResource(R.drawable.twelve);
        break;
      case 13:
        mInfo.setText("This is  Week 13\n\n" + getResources().getString(R.string.thirteen));
        mImage.setImageResource(R.drawable.thirteen);
        break;
      case 14:
        mInfo.setText("This is  Week 14\n\n" + getResources().getString(R.string.fourteen));
        mImage.setImageResource(R.drawable.fourteen);
        break;
      case 15:
        mInfo.setText("This is  Week 15\n\n" + getResources().getString(R.string.fifteen));
        mImage.setImageResource(R.drawable.fifteen);
        break;
      case 16:
        mInfo.setText("This is  Week 16\n\n" + getResources().getString(R.string.sixteen));
        mImage.setImageResource(R.drawable.sixteen);
        break;
      case 17:
        mInfo.setText("This is  Week 17\n\n" + getResources().getString(R.string.seventeen));
        mImage.setImageResource(R.drawable.seventeen);
        break;
      case 18:
        mInfo.setText("This is  Week 18\n\n" + getResources().getString(R.string.eightteen));
        mImage.setImageResource(R.drawable.eighteen);
        break;
      case 19:
        mInfo.setText("This is  Week 19\n\n" + getResources().getString(R.string.nineteen));
        mImage.setImageResource(R.drawable.ninteen);
        break;
      case 20:
        mInfo.setText("This is  Week 20\n\n" + getResources().getString(R.string.twenty));
        mImage.setImageResource(R.drawable.twenty);
        break;
      case 21:
        mInfo.setText("This is  Week 21\n\n" + getResources().getString(R.string.twenty_one));
        mImage.setImageResource(R.drawable.twenty_one);
        break;
      case 22:
        mInfo.setText("This is  Week 22\n\n" + getResources().getString(R.string.twenty_two));
        mImage.setImageResource(R.drawable.twenty_two);
        break;
      case 23:
        mInfo.setText("This is  Week 23\n\n" + getResources().getString(R.string.twenty_three));
        mImage.setImageResource(R.drawable.twenty_three);
        break;
      case 24:
        mInfo.setText("This is  Week 24\n\n" + getResources().getString(R.string.twenty_four));
        mImage.setImageResource(R.drawable.twenty_three);
        break;
      case 25:
        mInfo.setText("This is  Week 25\n\n" + getResources().getString(R.string.twenty_five));
        mImage.setImageResource(R.drawable.twenty_five);
        break;
      case 26:
        mInfo.setText("This is  Week 26\n\n" + getResources().getString(R.string.twenty_six));
        mImage.setImageResource(R.drawable.twenty_six);
        break;
      case 27:
        mInfo.setText("This is  Week 27\n\n" + getResources().getString(R.string.twenty_seven));
        mImage.setImageResource(R.drawable.twenty_seven);
        break;
      case 28:
        mInfo.setText("This is  Week 28\n\n" + getResources().getString(R.string.twenty_eight));
        mImage.setImageResource(R.drawable.twenty_eight);
        break;
      case 29:
        mInfo.setText(
            "This is  Week 29\n\n" + getResources().getString(R.string.twenty_nine)); mImage.setImageResource(
          R.drawable.twenty_nine);
        break;
      case 30:
        mInfo.setText("This is  Week 30\n\n" + getResources().getString(R.string.thirty));
        mImage.setImageResource(R.drawable.thirty);
        break;
      case 31:
        mInfo.setText("This is  Week 31\n\n" + getResources().getString(R.string.thirty_one));
        mImage.setImageResource(R.drawable.thirty_one);
        break;
      case 32:
        mInfo.setText("This is  Week 32\n\n" + getResources().getString(R.string.thirty_two));
        mImage.setImageResource(R.drawable.thirty_two);
        break;
      case 33:
        mInfo.setText("This is  Week 33\n\n" + getResources().getString(R.string.thirty_three));
        mImage.setImageResource(R.drawable.thirty_three);
        break;
      case 34:
        mInfo.setText("This is  Week 34\n\n" + getResources().getString(R.string.thirty_four));
        mImage.setImageResource(R.drawable.thirty_four);
        break;
      case 35:
        mInfo.setText("This is  Week 35\n\n" + getResources().getString(R.string.thirty_five));
        mImage.setImageResource(R.drawable.thirty_five);
        break;
      case 36:
        mInfo.setText("This is  Week 36\n\n" + getResources().getString(R.string.thirty_six));
        mImage.setImageResource(R.drawable.thirty_six);
        break;
      case 37:
        mInfo.setText("This is  Week 37\n\n" + getResources().getString(R.string.thirty_seven));
        mImage.setImageResource(R.drawable.thirty_seven);
        break;
      case 38:
        mInfo.setText("This is  Week 38\n\n" + getResources().getString(R.string.thirty_eight));
        mImage.setImageResource(R.drawable.thirty_eight);
        break;
      case 39:
        mInfo.setText("This is  Week 39\n\n" + getResources().getString(R.string.thirty_nine));
        mImage.setImageResource(R.drawable.nine);
        break;
      case 40:
        mInfo.setText("This is  Week 40\n\n" + getResources().getString(R.string.fourty));
        mImage.setImageResource(R.drawable.fourty);
        break;
      case 41:
        mInfo.setText("This is  Week 41\n\n" + getResources().getString(R.string.fourty_one));
        mImage.setImageResource(R.drawable.fourty_one);
        break;
      default:
        mInfo.setText("This is  Week 2\n\n" + getResources().getString(R.string.two));
        mImage.setImageResource(R.drawable.two);
        break;
    }
  }
}