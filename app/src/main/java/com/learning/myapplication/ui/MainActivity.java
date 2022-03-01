package com.learning.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.os.Bundle;

import com.learning.myapplication.R;
import com.learning.myapplication.data.UserDatabase;
import com.learning.myapplication.data.daos.UserDao;

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