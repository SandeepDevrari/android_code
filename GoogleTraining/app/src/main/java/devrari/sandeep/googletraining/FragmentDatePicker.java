package devrari.sandeep.googletraining;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

/**
 * Created by user on 26/3/18.
 */

public class FragmentDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Date_Time_PickerActivity dtp=(Date_Time_PickerActivity) getActivity();
        dtp.setDateTost(year,month,dayOfMonth);
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){
        int year,month,day;
        LocalDateTime localDateTime=LocalDateTime.now();
        month=localDateTime.getMonthValue()-1;
        day=localDateTime.getDayOfMonth();
        year=localDateTime.getYear();
        return new DatePickerDialog(getActivity(),this,year,month,day);
    }

    /*@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_date_picker,container,false);
    }*/
}
