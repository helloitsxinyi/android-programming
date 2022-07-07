package iss.workshop.workshop5savedinstancestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    Button btnScore;

    TextView txtScore;
    // put txtTime here also no use, will stay as 0 after rotation

    int mSeconds;
    int mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScore = findViewById(R.id.btnScore);
        btnStart = findViewById(R.id.btnStart);

        txtScore = findViewById(R.id.txtScore);

        mSeconds = 0;
        mScore = 0;

        txtScore.setText("Your score: " + mScore);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSeconds = 30;
                mScore = 0;

                txtScore.setText("Your score: " + mScore);
                btnScore.setEnabled(true);

            }
        });

        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore++;
                txtScore.setText("Your score: " + mScore);
            }
        });

        runTimer();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("score", mScore);
        outState.putInt("time", mSeconds);
        // put runTimer here does not work hmm
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mScore = savedInstanceState.getInt("score");
        mSeconds = savedInstanceState.getInt("seconds");
        txtScore.setText("Your score: " + mScore);
        // put runTimer here does not work hmm
    }

    private void runTimer() {
        final TextView txtTime = findViewById(R.id.txtTime);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                txtTime.setText("Time left: " + mSeconds);

                if (mSeconds > 0) {
                    btnScore.setEnabled(true);
                    mSeconds--;
                } else {
                    btnScore.setEnabled(false);
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}