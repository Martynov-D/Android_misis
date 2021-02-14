package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonDot, buttonAdd, buttonSub, buttonDiv, buttonMul, buttonEqual, buttonC;
    EditText simpleEditText;

    float mValueOne, mValueTwo;

    boolean mAddition, mSubtraction, mDivision, mMultilpication;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonC = (Button) findViewById(R.id.buttonC);
        simpleEditText = (EditText) findViewById(R.id.edt1);

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                simpleEditText.setText(simpleEditText.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                simpleEditText.setText(simpleEditText.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                simpleEditText.setText(simpleEditText.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                simpleEditText.setText(simpleEditText.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                simpleEditText.setText(simpleEditText.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                simpleEditText.setText(simpleEditText.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                simpleEditText.setText(simpleEditText.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                simpleEditText.setText(simpleEditText.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                simpleEditText.setText(simpleEditText.getText() + "9");
            }
        });
        button0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                simpleEditText.setText(simpleEditText.getText() + "0");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                simpleEditText.setText(simpleEditText.getText() + ".");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (simpleEditText == null)
                    simpleEditText.setText("");
                else
                {
                    mValueOne = Float.parseFloat(simpleEditText.getText() + "");
                    mAddition = true;
                    simpleEditText.setText(null);
                }
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mValueOne = Float.parseFloat(simpleEditText.getText() + "");
                mSubtraction = true;
                simpleEditText.setText(null);

            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mValueOne = Float.parseFloat(simpleEditText.getText() + "");
                mMultilpication = true;
                simpleEditText.setText(null);

            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mValueOne = Float.parseFloat(simpleEditText.getText() + "");
                mDivision = true;
                simpleEditText.setText(null);

            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mValueTwo = Float.parseFloat(simpleEditText.getText() + "");
                if(mAddition == true)
                {
                    simpleEditText.setText(mValueOne + mValueTwo + "");
                    mAddition = false;
                }
                if(mSubtraction == true)
                {
                    simpleEditText.setText(mValueOne - mValueTwo + "");
                    mSubtraction = false;
                }
                if(mMultilpication == true)
                {
                    simpleEditText.setText(mValueOne*mValueTwo + "");
                    mMultilpication = false;
                }
                if(mDivision == true)
                {
                    simpleEditText.setText(mValueOne/mValueTwo + "");
                    mDivision = false;
                }
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                simpleEditText.setText("");
            }
        });
    }
}