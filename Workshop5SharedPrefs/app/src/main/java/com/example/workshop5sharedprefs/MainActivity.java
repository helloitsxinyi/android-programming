package com.example.workshop5sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mUsernameTxt;
    EditText mPasswordTxt;
    Button mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsernameTxt = findViewById(R.id.txtUsername);
        mPasswordTxt = findViewById(R.id.txtPassword);
        mLoginBtn = findViewById(R.id.btnLogin);

        mLoginBtn.setOnClickListener(new View.OnClickListener()) {
            @Override
            public void onClick(View v) {
            }
        }
    }

    private boolean login(String username, String password) {
        if (username.equals("DipSA") && password.equals("DipSA")) {
            return true;
        }
        return false;
    }

    public void startProtectedActivity() {
        Intent intent = new Intent(this, ProtectedActivity.class);
        startActivity(intent);
    }

}