package com.learning.aadhaardetails.ui;

import android.os.Bundle;

import com.learning.myapplication.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(new MainFragment(), R.id.fragment_container);
    }

    @Override
    public void onBackPressed() {
        replaceFragment(new MainFragment(),R.id.fragment_container);
    }
}