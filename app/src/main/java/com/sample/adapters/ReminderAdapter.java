package com.sample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.sample.R;
import com.sample.models.Reminder;
import java.util.List;

/**
 * Created by User on 2/17/2017.
 */

public class ReminderAdapter extends ArrayAdapter<Reminder> {
  private final Context context;
  private final List<Reminder> reminders;

  public ReminderAdapter(Context context, List<Reminder> reminders) {
    super(context, R.layout.item_reminder, reminders);
    this.context = context;
    this.reminders = reminders;
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater =
        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.item_reminder, parent, false);
    TextView textTile = (TextView) rowView.findViewById(R.id.txt_reminder_title);
    TextView textMessage = (TextView) rowView.findViewById(R.id.txt_reminder_message);
    TextView textDate = (TextView) rowView.findViewById(R.id.txt_reminder_date);
    TextView textTime = (TextView) rowView.findViewById(R.id.txt_reminder_time);
    TextView textid = (TextView) rowView.findViewById(R.id.txt_reminderid);
    Reminder reminder = reminders.get(position);
    textTile.setText("Tite : "+reminder.getTitle());
    textMessage.setText("Message : "+reminder.getMessage());
    textDate.setText("Date : "+reminder.getDate());
    textTime.setText("Time : "+reminder.getTime());
    textid.setText(String.valueOf(reminder.getId()));
    return rowView;
  }
}