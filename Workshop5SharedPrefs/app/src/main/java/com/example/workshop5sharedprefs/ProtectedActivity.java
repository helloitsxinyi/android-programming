package com.example.workshop5sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

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

        mLogoutBtn.setOnClickListener(new View.OnClickListener());
            @Override
            public void onClick(View v) {
                finish();
        }
    }


}