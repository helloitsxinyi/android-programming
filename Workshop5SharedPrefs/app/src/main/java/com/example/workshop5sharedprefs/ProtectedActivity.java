package com.example.workshop5sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProtectedActivity extends AppCompatActivity {
    TextView mInfoTxt;
    Button mLogoutBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protected);

        mInfoTxt = findViewById(R.id.txtInfo);
        mLogoutBtn = findViewById(R.id.btnLogout);

        SharedPreferences sharedPreferences = getSharedPreferences("user_credentials", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","");
        mInfoTxt.setText("Hi " + username + "! Welcome");

        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.remove("username");
                editor.clear();
                editor.commit();
                finish();
            }
        });
    }


}