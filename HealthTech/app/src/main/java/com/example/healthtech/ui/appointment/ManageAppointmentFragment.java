package com.example.healthtech.ui.appointment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.healthtech.Account;
import com.example.healthtech.Appointment;
import com.example.healthtech.R;

import java.util.ArrayList;

public class ManageAppointmentFragment extends ListFragment {
    public static ManageAppointmentFragment newInstance(){ return new ManageAppointmentFragment(); }
    Button btnCancel;
    AppointmentAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_manage_appointments, container, false);
        btnCancel = root.findViewById(R.id.cancelButton);
        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new AppointmentAdapter(getActivity(), Account.active.getAppointments());
        this.setListAdapter(adapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceStates){
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setAllInactive(parent);
                View selected = (View) parent.getChildAt(position);
                adapter.handleSelection(position);
                if(position == adapter.getSelectedPosition()){
                    setInactive(selected);
                }
                else{
                    setActive(selected);
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter.selected()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Cancel Appointment");
                    builder.setMessage("Are you sure you want to cancel this appointment?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            adapter.deleteSelection();
                            adapter.notifyDataSetChanged();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            adapter.handleSelection(-1);
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    setAllInactive((AdapterView) getListView());
                }
            }
        });
    }
    private void setActive(View view){
        view.setBackgroundResource(R.color.colorHealthTech);
    }
    private void setInactive(View view){
        view.setBackgroundResource(R.color.white);
    }
    private void setAllInactive(AdapterView<?> parent){
        for(int i=0; i < parent.getChildCount(); i++){
            View child = (View) parent.getChildAt(i);
            setInactive(child);
        }
    }
}
