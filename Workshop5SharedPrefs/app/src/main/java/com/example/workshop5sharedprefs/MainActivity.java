package com.example.workshop5sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        SharedPreferences sharedPref = getSharedPreferences("user_credentials", Context.MODE_PRIVATE);
        String uname = sharedPref.getString("username", "user");

        // even if user reboot, data is still here
        if (sharedPref.contains("username") && sharedPref.contains("password")) {
            boolean loginOk = login(sharedPref.getString("username", ""),
                    sharedPref.getString("password", ""));

            if (loginOk) {
                startProtectedActivity();
            }
        }

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsernameTxt.getText().toString();
                String password = mPasswordTxt.getText().toString();
                boolean loginOk = login(username, password);
                if (loginOk) {
                    SharedPreferences sharedPref = getSharedPreferences("user_credentials", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.commit();

                    Toast.makeText(getApplicationContext(),"Login successful", Toast.LENGTH_SHORT).show();
                    startProtectedActivity();
                } else {
                Toast.makeText(getApplicationContext(),
                        "Credentials are not valid",Toast.LENGTH_SHORT).show();
            }
          }
        });
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