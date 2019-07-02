package devrari.sandeep.googletraining;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.app.TimePickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import java.time.LocalDateTime;

/**
 * Created by user on 26/3/18.
 */

public class FragmentTimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Date_Time_PickerActivity dtp=(Date_Time_PickerActivity) getActivity();
        dtp.setTimeTost(hourOfDay,minute);
    }

   /* @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_time_picker,container,false);
    }*/

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LocalDateTime localDateTime=LocalDateTime.now();
        int hour=localDateTime.getHour();
        int minute=localDateTime.getMinute();
        return new TimePickerDialog(getActivity(),this,hour,minute,false);
    }
}
