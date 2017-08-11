package com.example.unnatiproj;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static com.example.unnatiproj.HomePage.navigationView;


public class SignIn extends Fragment {

    private ViewPager viewPager;
    Button log, signup;
    FragmentManager fragmentManager;
    static String title;

    public SignIn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        HomePage.actionBar.setTitle("Sign In");
        HomePage.actionBarMenu.findItem(R.id.sign_in).setChecked(true);

        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        log = (Button) view.findViewById(R.id.btnsignin);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
                        .replace(R.id.login, new StudentList())
                        .addToBackStack(null)
                        .commit();
            }
        });

        signup = (Button) view.findViewById(R.id.btnreg);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
                        .replace(R.id.login, new TeachersForm())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

}

