package com.example.workshop4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityResultLauncher<Intent> rlActivityWriteQuote;
    private String lastQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpButtons();
        registerForResult();
    }

    protected void setUpButtons() {
        int[] ids = { R.id.write_button, R.id.show_button };
        for (int id : ids) {
            Button button = findViewById(id);
            button.setOnClickListener(this);
        }
    }

    protected void registerForResult() {
        rlActivityWriteQuote = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == AppCompatActivity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String quote = data.getStringExtra("quote");
                            if (quote != null) {
                                lastQuote = quote;
                            }
                        }
                    }
                }
        );
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.write_button) {
            Intent intent = new Intent(this, ActivityWriteQuote.class);
            rlActivityWriteQuote.launch(intent);
        } else {
            Intent intent = new Intent(this, ActivityShowQuote.class);
            intent.putExtra("quote", lastQuote);
        }
    }

}