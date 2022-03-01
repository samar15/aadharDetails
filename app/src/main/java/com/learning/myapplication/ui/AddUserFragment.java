package com.learning.myapplication.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.learning.myapplication.R;
import com.learning.myapplication.data.User;
import com.learning.myapplication.data.UserDatabase;
import com.learning.myapplication.data.daos.UserDao;

public class AddUserFragment extends Fragment {
    protected EditText name;
    protected EditText contactNumber;
    protected EditText address;
    protected Button addUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name = getActivity().findViewById(R.id.input_name);
        contactNumber = getActivity().findViewById(R.id.input_contact_number);
        address = getActivity().findViewById(R.id.input_address);
        addUser = getActivity().findViewById(R.id.btn_final_add_user);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (contactNumber.length() < 10 || "".equals(name.getText().toString()) || "".equals(address.getText().toString())) {
                    Toast.makeText(getContext(), "Incomplete details", Toast.LENGTH_SHORT).show();
                    return;
                }
                new addUserThread().start();

            }
        });
    }

    class addUserThread extends Thread{
        public void run(){
            super.run();
            UserDatabase db = Room.databaseBuilder(requireActivity().getApplicationContext(),
                    UserDatabase.class,
                    "room_db").build();
            UserDao userDao = db.userDao();
            User user = new User(name.getText().toString(),contactNumber.getText().toString(),address.getText().toString());
            userDao.addUser(user);
            name.setText("");
            contactNumber.setText("");
            address.setText("");
        }
    }

}