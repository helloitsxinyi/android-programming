package iss.workshop.files;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final int APP_SPEC_INT = 1;
    private static final int APP_SPEC_EXT = 2;
    private static final int PUB_EXT = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}