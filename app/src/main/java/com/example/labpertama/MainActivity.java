package com.example.labpertama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public native int addFromJni(int num1, int num2);

    static {
        System.loadLibrary("ndktest");
    }

    private TextView textOutput;
    private EditText inputFirst;
    private EditText inputSecond;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textOutput = findViewById(R.id.text_output);
        inputFirst = findViewById(R.id.input_first);
        inputSecond = findViewById(R.id.input_second);
        buttonAdd = findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int inputFirstValue = Integer.parseInt(inputFirst.getText().toString());
                int inputSecondValue = Integer.parseInt(inputSecond.getText().toString());
                String textOutputValue = String.valueOf(addFromJni(inputFirstValue,
                        inputSecondValue));
                textOutput.setText(textOutputValue);
            }
        });
    }
}