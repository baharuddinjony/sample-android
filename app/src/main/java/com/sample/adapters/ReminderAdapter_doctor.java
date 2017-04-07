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

public class ReminderAdapter_doctor extends ArrayAdapter<Reminder> {
    private final Context context2;
    private final List<Reminder> reminders2;

    public ReminderAdapter_doctor(Context context2, List<Reminder> reminders2) {
        super(context2,R.layout.item_reminder_doctors,reminders2);
        this.context2 = context2;
        this.reminders2 = reminders2;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =
                (LayoutInflater) context2.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_reminder_doctors, parent, false);
        TextView textTile = (TextView) rowView.findViewById(R.id.txt_reminder_title_doctor);
        TextView textMessage = (TextView) rowView.findViewById(R.id.txt_reminder_message_doctor);
        TextView textDate = (TextView) rowView.findViewById(R.id.txt_reminder_date_doctor);
        TextView textTime = (TextView) rowView.findViewById(R.id.txt_reminder_time_doctor);
        TextView textid = (TextView) rowView.findViewById(R.id.txt_reminderid_doctor);
        Reminder reminder2 = reminders2.get(position);
        /*textTile.setText("Tite : "+reminder2.getDoctorTitle());
        textMessage.setText("Message : "+reminder2.getDoctorMessage());
        textDate.setText("Date : "+reminder2.getDoctorDate());
        textTime.setText("Time : "+reminder2.getDoctorTime());
        textid.setText(String.valueOf(reminder2.getDoctorId()));*/
        return rowView;
    }
}