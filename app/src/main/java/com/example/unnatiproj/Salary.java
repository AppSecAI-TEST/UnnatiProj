package com.example.unnatiproj;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Salary extends Fragment {


    public Salary() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        HomePage.actionBar.setTitle("Salary");
        HomePage.navigationBarMenu.findItem(R.id.salary).setChecked(true);

        return inflater.inflate(R.layout.fragment_salary, container, false);
    }

}
