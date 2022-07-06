package com.example.workshop4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityShowQuote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_quote);

        Button okButton = findViewById(R.id.ok_button);
        TextView lastQuote = findViewById(R.id.quote);

        Intent intent = getIntent();
        String quote = intent.getStringExtra("quote");
        if (quote != null) {
            lastQuote.setText(quote);
        }

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // indicate end of activity
                finish();
            }
        });
    }
}
