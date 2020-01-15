package com.example.instagarmreplica.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.instagarmreplica.Login;
import com.example.instagarmreplica.R;
import com.example.instagarmreplica.Register;
import com.example.instagarmreplica.Signup;

import java.util.regex.Pattern;

import static androidx.core.content.ContextCompat.getColor;
import static androidx.core.content.ContextCompat.getDrawable;

public class Phone_reg_frag extends Fragment implements View.OnClickListener {
    EditText txtregPhone;
    Button btnNextPhone;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_phone_reg_frag, container, false);
        txtregPhone = view.findViewById(R.id.et_reg_phone);
        btnNextPhone = view.findViewById(R.id.btnnextPhonereg);

        btnNextPhone.setOnClickListener(this);

        return view;
    }


    public boolean Validate(){
        if (txtregPhone.getText().toString().trim().isEmpty()) {
            txtregPhone.setError("Empty Fields");
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnnextPhonereg:
//            if(Validate()){
                Intent signupIntent = new Intent(getContext(), Signup.class);
                signupIntent.putExtra("phone", txtregPhone.getText().toString());

                startActivity(signupIntent);
//            }
            break;
        }
    }
}
