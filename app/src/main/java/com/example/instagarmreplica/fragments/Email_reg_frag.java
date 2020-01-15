package com.example.instagarmreplica.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.instagarmreplica.R;
import com.example.instagarmreplica.Register;
import com.example.instagarmreplica.Signup;

public class Email_reg_frag extends Fragment implements View.OnClickListener {
    EditText et_reg_email;
    Button btnnextEmailreg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_email_reg_frag, container, false);
        et_reg_email = view.findViewById(R.id.et_reg_email);
        btnnextEmailreg = view.findViewById(R.id.btnnextEmailreg);

        btnnextEmailreg.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnnextEmailreg:
//            if(Validate()){
                Intent signupIntent = new Intent(getContext(), Signup.class);
                signupIntent.putExtra("email", et_reg_email.getText().toString());
                startActivity(signupIntent);
//            }
            break;
        }
    }

    public boolean Validate(){
        if (et_reg_email.getText().toString().trim().isEmpty()) {
            et_reg_email.setError("Empty Fields");
            return false;
        }
        return true;
    }
}
