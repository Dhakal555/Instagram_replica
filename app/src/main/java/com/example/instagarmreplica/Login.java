package com.example.instagarmreplica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instagarmreplica.Apis.Userapi;
import com.example.instagarmreplica.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText etUname, etPassword;
    TextView tvSignup;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hide();
        setContentView(R.layout.activity_login);

        etUname = findViewById(R.id.et_uname);
        etPassword = findViewById(R.id.et_password);

        tvSignup = findViewById(R.id.tv_gotosignup);

        btnLogin = findViewById(R.id.btnLogin);

        tvSignup.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        etUname.addTextChangedListener(textWatcherLogin);
        etPassword.addTextChangedListener(textWatcherLogin);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_gotosignup:
                Intent signupIntent = new Intent(Login.this, Register.class);
                startActivity(signupIntent);
                break;
            case R.id.btnLogin:
                startLogin();
                break;
        }
    }

    private void startLogin() {
        if (CheckValid()) {
            User login_user = new User(etUname.getText().toString(), etPassword.getText().toString());

            Userapi usrApi = Url.getInstance().create(Userapi.class);
            Call<Void> callUser = usrApi.login(login_user);

            callUser.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(Login.this, "Cannot login!!!!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Intent intentOpenDashboard = new Intent(Login.this, Bottom_nav.class);
                    startActivity(intentOpenDashboard);
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(Login.this, "Error!! login failure" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    public boolean CheckValid(){
        if (etUname.getText().toString().trim().isEmpty()) {
            etUname.setError("Empty Fields");
            return false;
        } if (etPassword.getText().toString().trim().isEmpty()){
            etPassword.setError("Empty fields");
            return false;
        }
        return true;
    }

    private TextWatcher textWatcherLogin = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            String unameInput = etUname.getText().toString().trim();
//            String passwordinput = etPassword.getText().toString().trim();
//
//            btnLogin.setEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void hide(){
        //hiding the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        //making full screen
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //hiding the navigation bar
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}
