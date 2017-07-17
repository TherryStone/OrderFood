package com.truongtd.orderfood.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;

import com.truongtd.orderfood.R;

import java.util.Calendar;

/**
 * Created by Truong_it on 7/10/2017.
 */

public class FragmentBirthDay extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getContext(), this, day, month, year);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        EditText edtBirthDay = (EditText) getActivity().findViewById(R.id.edt_birth_day);
        String birthDay = dayOfMonth + " / " +( month + 1) + " / " + year;
        edtBirthDay.setText(birthDay);
    }
}
