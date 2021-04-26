package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private final static String TAG = "AppActivity";

    CalculatorLogic calculatorLogic;
    boolean simple;

    Button factorialExp, squareLn, divSin, mulCos, subTan, addCtan;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorLogic = new CalculatorLogic(findViewById(R.id.MainTextView));
        simple = true;

        factorialExp = findViewById(R.id.buttonFactorialExp);
        squareLn = findViewById(R.id.buttonSquareLn);
        divSin = findViewById(R.id.buttonDivSin);
        mulCos = findViewById(R.id.buttonMulCos);
        subTan = findViewById(R.id.buttonSubTan);
        addCtan = findViewById(R.id.buttonAddCot);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.item1:
            {
                simple = true;

                factorialExp.setText("!X");
                squareLn.setText("X^2");
                divSin.setText("/");
                mulCos.setText("*");
                subTan.setText("-");
                addCtan.setText("+");

                Log.d(TAG, String.format("item1 is selected, simple is %1$s", simple));
                break;
            }
            case R.id.item2:
            {
                simple = false;

                factorialExp.setText("Exp");
                squareLn.setText("Ln");
                divSin.setText("Sin");
                mulCos.setText("Cos");
                subTan.setText("Tan");
                addCtan.setText("Cot");

                Log.d(TAG, String.format("item2 is selected, simple is %1$s", simple));
                break;
            }
        }
        return true;
    }

    public void zeroOnClick(View view)
    {
        calculatorLogic.buttonClickLogic(calculatorLogic.buttonZeroClick());
    }
    public void oneOnClick(View view)
    {
        calculatorLogic.buttonClickLogic(calculatorLogic.buttonOneClick());
    }
    public void twoOnClick(View view)
    {
        calculatorLogic.buttonClickLogic(calculatorLogic.buttonTwoClick());
    }
    public void threeOnClick(View view)
    {
        calculatorLogic.buttonClickLogic(calculatorLogic.buttonThreeClick());
    }
    public void fourOnClick(View view)
    {
        calculatorLogic.buttonClickLogic(calculatorLogic.buttonFourClick());
    }
    public void fiveOnClick(View view)
    {
        calculatorLogic.buttonClickLogic(calculatorLogic.buttonFiveClick());
    }
    public void sixOnClick(View view)
    {
        calculatorLogic.buttonClickLogic(calculatorLogic.buttonSixClick());
    }
    public void sevenOnClick(View view)
    {
        calculatorLogic.buttonClickLogic(calculatorLogic.buttonSevenClick());
    }
    public void eightOnClick(View view)
    {
        calculatorLogic.buttonClickLogic(calculatorLogic.buttonEightClick());
    }
    public void nineOnClick(View view)
    {
        calculatorLogic.buttonClickLogic(calculatorLogic.buttonNineClick());
    }
    public void dotOnClick(View view)
    {
        calculatorLogic.buttonDotClick();
    }

    public void factorialExpOnClick(View view)
    {
        if (simple)
            calculatorLogic.buttonFactorialClick();
        else
            calculatorLogic.buttonExpClick();
    }
    public void squareLnOnClick(View view)
    {
        if (simple)
            calculatorLogic.buttonSquareClick();
        else
            calculatorLogic.buttonLnClick();
    }
    public void divSinOnClick(View view)
    {
        if (simple)
            calculatorLogic.mathOperatorLogic(calculatorLogic.buttonDivClick());
        else
            calculatorLogic.buttonSinClick();
    }
    public void mulCosOnClick(View view)
    {
        if (simple)
            calculatorLogic.mathOperatorLogic(calculatorLogic.buttonMulClick());
        else
            calculatorLogic.buttonCosClick();
    }
    public void subTanOnClick(View view)
    {
        if (simple)
            calculatorLogic.mathOperatorLogic(calculatorLogic.buttonSubClick());
        else
            calculatorLogic.buttonTanClick();
    }
    public void addCotOnClick(View view)
    {
        if (simple)
            calculatorLogic.mathOperatorLogic(calculatorLogic.buttonAddClick());
        else
            calculatorLogic.buttonCotClick();
    }

    public void cOnClick(View view)
    {
        calculatorLogic.buttonCClick();
    }
    public void equalOnClick(View view)
    {
        calculatorLogic.buttonEqualClick();
    }
}