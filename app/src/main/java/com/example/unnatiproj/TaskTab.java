package com.example.unnatiproj;


import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TaskTab extends Fragment {

    FloatingActionButton floatingActionButton;

    public TaskTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        HomePage.actionBar.setTitle("Task Tab");
        HomePage.navigationBarMenu.findItem(R.id.task_tab).setChecked(true);

        View view = inflater.inflate(R.layout.fragment_task_tab, container, false);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
                        .replace(R.id.login, new AddTask())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;

    }

}
