package com.learning.myapplication.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learning.myapplication.R;
import com.learning.myapplication.data.User;


public class UserDetailsFragment extends Fragment {

protected TextView name;
protected TextView contactNumber;
protected TextView address;
    private final String USER_DETAILS = "USER_DETAILS";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = requireActivity().findViewById(R.id.name);
        address = requireActivity().findViewById(R.id.address);
        contactNumber = requireActivity().findViewById(R.id.contact_number);
        User user =null;
        Bundle arguments = getArguments();
        if(null != arguments) {
             user = (User) arguments.getSerializable(USER_DETAILS);
        }
        if(null != user){
            name.setText(user.getName());
            address.setText(user.getAddress());
            contactNumber.setText(user.getContactNumber());
        }

    }


}