package com.example.workshop3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // R.id are ints: 1000000, 1000001 etc. does not seem to be assigned in order...
        int[] btns = {R.id.visit, R.id.locate, R.id.call, R.id.email};

        for (int btnId: btns) {
            Button btn = findViewById(btnId);

            if (btn != null) {
                // need to cast this to View.OnClickListener if never implement above.
                btn.setOnClickListener( this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        Uri uri;

        int id = v.getId();

        switch (id) {
            case R.id.visit:
                uri = Uri.parse("https://www.nus.edu.sg/");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                break;
            case R.id.locate:
                uri = Uri.parse("geo:1.296643,103.776398");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                break;
            case R.id.call:
                uri = Uri.parse("tel:(+65) 6516 6666");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                break;
            case R.id.email:
                uri = Uri.parse("mailto:mail@nus.edu.sg");
                intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject));
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.content));
                break;
        }

        if (intent != null) {
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

    }
}