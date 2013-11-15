package com.mds.app.util;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

@SuppressLint("ValidFragment")
public class DatePicker extends FragmentActivity implements OnDateSetListener {

	public DatePicker(){}
	
	public void showDateDialog(){

        FragmentManager fm = getFragmentManager();
        TimePickerFragment newFragment = new TimePickerFragment(this);
        newFragment.show(fm, "date_picker");

    }

	
	public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {

    }
	
	public static class TimePickerFragment extends DialogFragment {

		public OnDateSetListener listener;
		
		public TimePickerFragment(OnDateSetListener listener) {
	        this.listener=listener;
	    }

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current time as the default values for the picker
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);

			// Create a new instance of TimePickerDialog and return it
			return new DatePickerDialog(getActivity(), listener, year, month, day);
		}

	}

	@Override
	public void onDateSet(android.widget.DatePicker view, int year, int monthOfYear, int dayOfMonth) {
		// TODO Auto-generated method stub
		
	}
}
