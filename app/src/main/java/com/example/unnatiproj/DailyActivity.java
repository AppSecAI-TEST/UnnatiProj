package com.example.unnatiproj;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DailyActivity extends Fragment {

    EditText t1;
    String[] branches = {"CIDCO, N-7", "Shahanoormia DARGAH"};
    MaterialBetterSpinner l_sp;
    ArrayAdapter aa;
    FragmentManager manager;

    public DailyActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        HomePage.actionBar.setTitle("Daily Activity");
        HomePage.navigationBarMenu.findItem(R.id.daily_act).setChecked(true);

        View view = inflater.inflate(R.layout.fragment_daily, container, false);
        t1 = (EditText) view.findViewById(R.id.daily_date);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
        t1.setText(d.format(c.getTime()));
        t1.setKeyListener(null);

        l_sp = (MaterialBetterSpinner) view.findViewById(R.id.loc_spinner);
        aa = new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, branches);
        l_sp.setAdapter(aa);
        manager = getFragmentManager();
        return view;
    }

}
