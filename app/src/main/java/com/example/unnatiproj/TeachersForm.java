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

public class TeachersForm extends Fragment {

    String[] branches = {"CIDCO, N-7", "Shahanoormia DARGAH"};
    MaterialBetterSpinner b_sp;
    ArrayAdapter aa;
    FragmentManager manager;

    public TeachersForm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_teachers_form, container, false);
        b_sp = (MaterialBetterSpinner) view.findViewById(R.id.tbranch);
        aa = new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, branches);
        b_sp.setAdapter(aa);
        manager = getFragmentManager();

        return view;
    }

}
