package com.example.unnatiproj;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TaskTab extends Fragment {


    public TaskTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        HomePage.actionBar.setTitle("Task Tab");
        HomePage.navigationBarMenu.findItem(R.id.task_tab).setChecked(true);

        return inflater.inflate(R.layout.fragment_task_tab, container, false);
    }

}
