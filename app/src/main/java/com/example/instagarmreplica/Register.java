package com.example.instagarmreplica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.instagarmreplica.adapter.ViewPageAdapter;
import com.example.instagarmreplica.fragments.Email_reg_frag;
import com.example.instagarmreplica.fragments.Phone_reg_frag;
import com.google.android.material.tabs.TabLayout;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView go_to_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tabLayout = findViewById(R.id.tab_register);
        viewPager = findViewById(R.id.viewpager);

        go_to_login = findViewById(R.id.tvLogingo);

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());

        viewPageAdapter.addFragment(new Phone_reg_frag(), "PHONE");
        viewPageAdapter.addFragment(new Email_reg_frag(), "EMAIL");

        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);

        go_to_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvLogingo:
                Intent go_login_intent = new Intent(Register.this, Login.class);
                startActivity(go_login_intent);
                break;
        }
    }
}
