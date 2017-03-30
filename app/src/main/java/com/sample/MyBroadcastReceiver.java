package com.sample;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by User on 3/30/2017.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
  MediaPlayer mp;
  @Override
  public void onReceive(Context context, Intent intent) {
    mp=MediaPlayer.create(context,R.raw.alarm);
    mp.start();
    NotificationCompat.Builder mBuilder =
        new NotificationCompat.Builder(context)
            .setSmallIcon(R.drawable.down_arrow)
            .setContentTitle("Reminder")
            .setContentText("Reminder Details");

    NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    mNotificationManager.notify(1, mBuilder.build());

  }
}