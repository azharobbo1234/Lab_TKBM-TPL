package com.example.labpertama;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private int x = 100;
    private TextView calculationTextView;
    private TextView resultTextView;
    private Button buttonZero;
    private Button plusButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculationTextView = (TextView) findViewById(R.id.calculationTextView);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
    }

    // number input method
    public void addZero(View view) {
        String currentCalculation = calculationTextView.getText().toString();
        calculationTextView.setText(currentCalculation + "0");
    }
    public void addOne(View view) {
        String currentCalculation = calculationTextView.getText().toString();
        calculationTextView.setText(currentCalculation + "1");
    }
    public void addTwo(View view) {
        String currentCalculation = calculationTextView.getText().toString();
        calculationTextView.setText(currentCalculation + "2");
    }
    public void addThree(View view) {
        String currentCalculation = calculationTextView.getText().toString();
        calculationTextView.setText(currentCalculation + "3");
    }
    public void addFour(View view) {
        String currentCalculation = calculationTextView.getText().toString();
        calculationTextView.setText(currentCalculation + "4");
    }
    public void addFive(View view) {
        String currentCalculation = calculationTextView.getText().toString();
        calculationTextView.setText(currentCalculation + "5");
    }
    public void addSix(View view) {
        String currentCalculation = calculationTextView.getText().toString();
        calculationTextView.setText(currentCalculation + "6");
    }
    public void addSeven(View view) {
        String currentCalculation = calculationTextView.getText().toString();
        calculationTextView.setText(currentCalculation + "7");
    }
    public void addEight(View view) {
        String currentCalculation = calculationTextView.getText().toString();
        calculationTextView.setText(currentCalculation + "8");
    }
    public void addNine(View view) {
        String currentCalculation = calculationTextView.getText().toString();
        calculationTextView.setText(currentCalculation + "9");
    }

    // operation input method
    public void addPlus(View view) {
        String currentCalculation = calculationTextView.getText().toString();
        calculationTextView.setText(currentCalculation + "+");
    }
    public void addSubtract(View view) {
        String currentCalculation = calculationTextView.getText().toString();
        calculationTextView.setText(currentCalculation + "-");
    }
    public void calculateResult(View view) {
        int result;
        String currentCalculation = calculationTextView.getText().toString();
        calculationTextView.setText("");

        Calculator calculator = new Calculator();
        boolean calculationIsValid = calculator.validateCalculation(currentCalculation);
        if (calculationIsValid) {
            result = calculator.calculate(currentCalculation);
            resultTextView.setText(Integer.toString(result));
        } else {
            resultTextView.setText("err");
        }
    }

    // other input method
    public void resetCalculation(View view) {
        calculationTextView.setText("");
        resultTextView.setText("0");
    }
    public void deleteCalculation(View view) {
        String result;
        String currentCalculation = calculationTextView.getText().toString();
        result = currentCalculation.substring(0, currentCalculation.length() - 1);
        calculationTextView.setText(result);
    }
}