package com.example.labpertama;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int timerValue = 0;
    private Handler mHandler = new Handler();

    private TextView timerTextView;
    private Button toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        toggleButton = (Button)findViewById(R.id.toggleButton);
        timerTextView = (TextView)findViewById(R.id.timerTextView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                showAlertDialog();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        showAlertDialog();
    }

    public void toggleStopwatch(View view) {
        String currentState = toggleButton.getText().toString();
        Log.i("MainActivity", currentState);
        if (currentState.equals("stop")) {
            stopStopWatch();
            toggleButton.setText("start");

        } else if (currentState.equals("start")) {
            startStopWatch();
            toggleButton.setText("stop");
        }
    }

    public void startStopWatch() {
        mToastRunnable.run();
    }

    public void stopStopWatch() {
        mHandler.removeCallbacks(mToastRunnable);
    }

    public void resetStopWatch(View view) {
        timerValue = 0;
        timerTextView.setText(Integer.toString(timerValue));
        mHandler.removeCallbacks(mToastRunnable);
        toggleButton.setText("start");
    }

    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {
            timerValue += 1;
            timerTextView.setText(Integer.toString(timerValue));
            mHandler.postDelayed(this, 1000);
        }
    };

    public void showAlertDialog() {
        Log.i("MainActivity", "show alert dialog");
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Anda yakin ingin keluar?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i("MainActivity", "cancel exit");
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}