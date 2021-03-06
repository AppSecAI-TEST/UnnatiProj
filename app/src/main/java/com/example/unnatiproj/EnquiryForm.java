package com.example.unnatiproj;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EnquiryForm extends Fragment {

    MaterialBetterSpinner b_sp;
    MaterialAutoCompleteTextView c_sp;
    EditText t1;
    ArrayAdapter aa;
    FragmentManager manager;
    String[] branches = {"CIDCO, N-7", "Shahanoormia DARGAH"};
    String[] courses = {"RHCSA","RHCE","Amazon Web Services","Red Hat CL110","Red Hat CL110 + Amazon Web Services","Red Hat CL210","Red Hat CL310",
            "Python Programming(Beginners)","Python Advanced","Python + Linux Automation using Python","Red Hat Server Hardening",
            "Red Hat Linux Diagnostics and Troubleshooting","Ansible Automation","Docker","Red Hat Virtualization Administrator"};
    public EnquiryForm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        HomePage.actionBar.setTitle("Enquiry Form");
        HomePage.navigationBarMenu.findItem(R.id.enquiry_form).setChecked(true);

        View view=  inflater.inflate(R.layout.fragment_enquiry_form, container, false);
        b_sp = (MaterialBetterSpinner) view.findViewById(R.id.eqbranch_spn);
        aa = new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, branches);
        b_sp.setAdapter(aa);
        manager = getFragmentManager();

        c_sp = (MaterialAutoCompleteTextView) view.findViewById(R.id.eqcourse_spn);
        aa = new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, courses);
        c_sp.setAdapter(aa);
        manager = getFragmentManager();

        t1=(EditText) view.findViewById(R.id.cdate);
        Calendar c=Calendar.getInstance();
        SimpleDateFormat d= new SimpleDateFormat("dd-MM-yyyy");
        t1.setText(d.format(c.getTime()));
        t1.setKeyListener(null);
        return  view;
    }

}
