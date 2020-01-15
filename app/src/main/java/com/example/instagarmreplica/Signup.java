package com.example.instagarmreplica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.instagarmreplica.Apis.Userapi;
import com.example.instagarmreplica.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends AppCompatActivity {
    EditText etFullname, etUname, etPassword;
    Button btnSignup;
    public static int email_phone = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etFullname = findViewById(R.id.et_signup_fullname);
        etUname = findViewById(R.id.et_signup_uname);
        etPassword = findViewById(R.id.et_signup_password_);

        btnSignup = findViewById(R.id.btnsignup);

        Bundle bundle = getIntent().getExtras();
        final String accessedPhone = bundle.getString("phone");
        final String accessedEmail = bundle.getString("email");


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User register_user;
                if(email_phone == 1){
                    register_user = new User(etFullname.getText().toString(), accessedPhone, etUname.getText().toString(), etPassword.getText().toString());
                } else {
                    register_user = new User(etFullname.getText().toString(), accessedEmail,  etUname.getText().toString(), etPassword.getText().toString());
                }

                Userapi userapiRegister = Url.getInstance().create(Userapi.class);
                Call<Void> callRegister = userapiRegister.register(register_user);

                callRegister.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(Signup.this, "Cannot Register!!!!" + response.body(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(Signup.this, "Successful", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(Signup.this, "Error!! Register failure" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
