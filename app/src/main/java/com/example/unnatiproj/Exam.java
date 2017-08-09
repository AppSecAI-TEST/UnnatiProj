package com.example.unnatiproj;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Exam extends Fragment {

    EditText t1;
    public Exam() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_exam, container, false);
        t1=(EditText) view.findViewById(R.id.re_date);
        Calendar c=Calendar.getInstance();
        SimpleDateFormat d= new SimpleDateFormat("dd-MM-yyyy");
        t1.setText(d.format(c.getTime()));
        t1.setKeyListener(null);
        return view;
    }

}
