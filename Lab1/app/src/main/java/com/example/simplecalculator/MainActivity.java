package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.Math;


public class MainActivity extends AppCompatActivity
{
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonDot, buttonAdd, buttonSub, buttonDiv, buttonMul, buttonEqual, buttonC, buttonSquare, buttonSin;
    EditText simpleEditText;

    double mValueOne, mValueTwo;

    boolean mAddition, mSubtraction, mDivision, mMultilpication, mIsFloat;

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
        buttonSquare = (Button) findViewById(R.id.buttonSquare);
        buttonSin = (Button) findViewById(R.id.buttonSin);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonC = (Button) findViewById(R.id.buttonC);
        simpleEditText = (EditText) findViewById(R.id.edt1);
        simpleEditText.setText("");

        mValueOne = 0;
        mValueTwo = 0;
        mAddition = false;
        mSubtraction = false;
        mDivision = false;
        mMultilpication = false;

        mIsFloat = false;

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buttonClickLogic(v, "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buttonClickLogic(v, "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buttonClickLogic(v, "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buttonClickLogic(v, "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buttonClickLogic(v, "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buttonClickLogic(v, "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buttonClickLogic(v, "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buttonClickLogic(v, "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buttonClickLogic(v, "9");
            }
        });
        button0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buttonClickLogic(v, "0");
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!mIsFloat)
                {
                    simpleEditText.setText(simpleEditText.getText() + ".");
                    mIsFloat = true;
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mathOperatorLogic(v, "+");
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mathOperatorLogic(v, "-");
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mathOperatorLogic(v, "*");
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mathOperatorLogic(v, "/");
            }
        });
        buttonSin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mValueOne == 0)
                {
                    if (simpleEditText.getText()!=null)
                        mValueOne = Math.sin(Math.toRadians(Double.parseDouble(simpleEditText.getText().toString())));
                }
                mIsFloat = true;
                simpleEditText.setText(String.valueOf(mValueOne));
            }
        });
        buttonSquare.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mValueOne == 0)
                {
                    if (simpleEditText.getText()!=null)
                        mValueOne = Math.pow(Double.parseDouble(simpleEditText.getText().toString()), 2);
                }
                mIsFloat = true;
                simpleEditText.setText(String.valueOf(mValueOne));
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mValueOne!=0)
                {
                    equalLogic(v);
                    simpleEditText.setText(String.valueOf(mValueOne));
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mValueOne = 0;
                mValueTwo = 0;
                mAddition = false;
                mSubtraction = false;
                mDivision = false;
                mMultilpication = false;
                mIsFloat = false;
                simpleEditText.setText("");
            }
        });
    }

    void equalLogic(View v)
    {
        if (mAddition)
        {
            mValueTwo = Float.parseFloat(simpleEditText.getText().toString());
            mValueOne = mValueOne + mValueTwo;
            mAddition = false;
        }
        else if (mSubtraction)
        {
            mValueTwo = Float.parseFloat(simpleEditText.getText().toString());
            mValueOne = mValueOne - mValueTwo;
            mSubtraction = false;
        }
        else if (mMultilpication)
        {
            mValueTwo = Float.parseFloat(simpleEditText.getText().toString());
            mValueOne = mValueOne * mValueTwo;
            mMultilpication = false;
        }
        else if (mDivision)
        {
            mValueTwo = Float.parseFloat(simpleEditText.getText().toString());
            mValueOne = mValueOne / mValueTwo;
            mDivision = false;
        }

    }

    void buttonClickLogic(View v, String number)
    {
        simpleEditText.setText(simpleEditText.getText() + number);
    }

    void mathOperatorLogic(View v, String operator)
    {
        if (mAddition || mSubtraction || mMultilpication|| mDivision)
        {
            mValueTwo = Float.parseFloat(simpleEditText.getText().toString());
            equalLogic(v);
            mAddition = false;
            mSubtraction = false;
            mDivision = false;
            mMultilpication = false;
        }
        switch(operator)
        {
            case("+"): mAddition = true; break;
            case("-"): mSubtraction = true; break;
            case("*"): mMultilpication = true; break;
            case("/"): mDivision= true; break;
        }

        if (mValueOne == 0)
        {
            if (simpleEditText.getText()!=null)
                mValueOne = Float.parseFloat(simpleEditText.getText().toString());
        }
        simpleEditText.setText(null);
        mIsFloat = false;
    }
}