package com.example.angry.testreminder;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Created by Angry on 6/5/2018.
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener  {
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        ((TextView)getActivity().findViewById(R.id.alertTime)).setText(hourOfDay+":"+minute);
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c=Calendar.getInstance();
        int hour=c.get(Calendar.HOUR_OF_DAY);
        int minute=c.get(Calendar.MINUTE);
        return  new TimePickerDialog(getActivity(),this,hour,minute, DateFormat.is24HourFormat(getActivity()));
    }
}
