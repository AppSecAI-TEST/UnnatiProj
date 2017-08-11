package com.example.unnatiproj;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AddTask extends Fragment {

    EditText t1;

    public AddTask() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        HomePage.actionBar.setTitle("Add Task");
//        HomePage.navigationBarMenu.findItem(R.id.daily_act).setChecked(true);

        View view= inflater.inflate(R.layout.fragment_add_task, container, false);
        t1 = (EditText) view.findViewById(R.id.task_date);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
        t1.setText(d.format(c.getTime()));
        t1.setKeyListener(null);

        return view;

    }

}
