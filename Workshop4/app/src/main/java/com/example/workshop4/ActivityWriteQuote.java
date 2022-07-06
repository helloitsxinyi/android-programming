package com.example.workshop4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityWriteQuote extends AppCompatActivity implements View.OnClickListener {
    Button okButton = findViewById(R.id.ok_button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_quote);

        okButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText quoteInput = findViewById(R.id.text_quote);
        Intent response = new Intent();
        // must toString, otherwise type is wrong
        response.putExtra("quote", quoteInput.toString());
        setResult(RESULT_OK, response);
        finish();
    }

}
