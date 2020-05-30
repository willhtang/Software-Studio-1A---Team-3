package com.example.healthtech.ui.appointment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.healthtech.Account;
import com.example.healthtech.Appointment;
import com.example.healthtech.R;

import java.util.Calendar;

public class BookAppointmentFragment extends Fragment {
    public static BookAppointmentFragment newInstance(){ return new BookAppointmentFragment(); }
    private DatePicker datePicker;
    private NumberPicker hourPick, minutePick;
    private Button btnAdd;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_appointment, container, false);
        datePicker = root.findViewById(R.id.appointmentDatePick);
        datePicker.setMinDate(Calendar.getInstance().getTimeInMillis());
        Calendar maxDate = Calendar.getInstance();
        maxDate.add(Calendar.MONTH, 3);
        datePicker.setMaxDate(maxDate.getTimeInMillis());
        hourPick = root.findViewById(R.id.appointmentHourPicker);
        hourPick.setMinValue(9);
        hourPick.setMaxValue(16);
        hourPick.setWrapSelectorWheel(false);
        hourPick.setDisplayedValues(new String[] {"09", "10", "11", "12", "13", "14", "15", "16"});
        minutePick = root.findViewById(R.id.appointmentMinutePicker);
        minutePick.setMinValue(0);
        minutePick.setMaxValue(1);
        minutePick.setDisplayedValues(new String[] {"00", "30"});
        btnAdd = root.findViewById(R.id.appointmentAddButton);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        final Bundle bundle = this.getArguments();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment appointment = new Appointment(hourPick.getValue(), minutePick.getValue(), datePicker.getMonth() +1, datePicker.getDayOfMonth(), "With " + bundle.getString("doctorName"));
                boolean conflict = false;
                for(Appointment current:Account.active.getAppointments()){
                    if(current.getStartTime().compareTo(appointment.getStartTime()) == 0){
                        conflict = true;
                        break;
                    }
                }
                if(conflict){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("This appointment conflicts with your current appointments. Please select a new one.");
                    builder.setTitle("Can't add appointment");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else {
                    Account.active.addAppointment(appointment);
                }
            }
        });
    }
}
