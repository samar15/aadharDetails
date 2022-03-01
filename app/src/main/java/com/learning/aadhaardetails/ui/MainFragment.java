package com.learning.aadhaardetails.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.learning.myapplication.R;
import com.learning.aadhaardetails.data.User;
import com.learning.aadhaardetails.data.UserDatabase;
import com.learning.aadhaardetails.data.daos.UserDao;


public class MainFragment extends Fragment {

    EditText input;
    private final String USER_DETAILS = "USER_DETAILS";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        input = requireActivity().findViewById(R.id.user_input);
        Button searchButton = requireActivity().findViewById(R.id.btn_search);
        Button addUserButton = requireActivity().findViewById(R.id.btn_add_user);
        Button logout = requireActivity().findViewById(R.id.btn_logout);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = input.getText().toString();
                if(!("".equals(id))){
                    new dbThread().start();
                    }
            }
        });

        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity) requireActivity()).replaceFragment(new AddUserFragment(), R.id.fragment_container);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    class dbThread extends Thread {
        public void run() {
            super.run();
            UserDatabase db = Room.databaseBuilder(requireActivity().getApplicationContext(),
                    UserDatabase.class,
                    "room_db").build();
            UserDao userDao = db.userDao();
            Long userInput = Long.parseLong(input.getText().toString());
            User user = userDao.getUserById(userInput);
            Bundle arguments = new Bundle();
            arguments.putSerializable(USER_DETAILS, user);
            UserDetailsFragment userDetailsFragment = new UserDetailsFragment();
            userDetailsFragment.setArguments(arguments);
            if (null != user) {
                ((MainActivity) requireActivity()).replaceFragment(userDetailsFragment, R.id.fragment_container);
            }
        }
    }
}

