package com.example.menu;

import android.widget.Button;
import android.widget.EditText;

public class CalculatorLogic
{
    EditText mSimpleEditText;

    double mValueOne, mValueTwo;
    boolean mAddition, mSubtraction, mDivision, mMultilpication, mIsFloat;

    CalculatorLogic(EditText simpleEditText)
    {
        mSimpleEditText = simpleEditText;
        mSimpleEditText.setText("");
        mValueOne = 0;
        mValueTwo = 0;
        mAddition = false;
        mSubtraction = false;
        mDivision = false;
        mMultilpication = false;
        mIsFloat = false;
    }

    Double factorial(int fact)
    {
        double result = 1;
        if (fact == 0)
            return result;

        for (int i = 1; i <= fact; ++i)
            result *= i;

        return result;
    }

    void mathOperatorLogic(String operator)
    {
        if (mAddition || mSubtraction || mMultilpication|| mDivision)
        {
            equalLogic();
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
            if (mSimpleEditText.getText()!=null)
                mValueOne = Float.parseFloat(mSimpleEditText.getText().toString());
        }
        mSimpleEditText.setText(null);
        mIsFloat = false;
    }

    void equalLogic()
    {
        mValueTwo = Float.parseFloat(mSimpleEditText.getText().toString());
        if (mAddition)
        {
            mValueOne = mValueOne + mValueTwo;
            mAddition = false;
        }
        else if (mSubtraction)
        {
            mValueOne = mValueOne - mValueTwo;
            mSubtraction = false;
        }
        else if (mMultilpication)
        {
            mValueOne = mValueOne * mValueTwo;
            mMultilpication = false;
        }
        else if (mDivision)
        {
            mValueOne = mValueOne / mValueTwo;
            mDivision = false;
        }
    }

    void buttonClickLogic(String number)
    {
        mSimpleEditText.setText(mSimpleEditText.getText() + number);
    }

    String buttonZeroClick()
    {
        return "0";
    }
    String buttonOneClick()
    {
        return "1";
    }
    String buttonTwoClick()
    {
        return "2";
    }
    String buttonThreeClick()
    {
        return "3";
    }
    String buttonFourClick()
    {
        return "4";
    }
    String buttonFiveClick()
    {
        return "5";
    }
    String buttonSixClick()
    {
        return "6";
    }
    String buttonSevenClick()
    {
        return "7";
    }
    String buttonEightClick()
    {
        return "8";
    }
    String buttonNineClick()
    {
        return "9";
    }
    String buttonAddClick()
    {
        return "+";
    }
    String buttonSubClick()
    {
        return "-";
    }
    String buttonMulClick()
    {
        return "*";
    }
    String buttonDivClick()
    {
        return "/";
    }

    void buttonSinClick()
    {
        if (mValueOne == 0)
        {
            if (mSimpleEditText.getText()!=null)
                mValueOne = Math.sin(Math.toRadians(Double.parseDouble(mSimpleEditText.getText().toString())));
        }
        mIsFloat = true;
        mSimpleEditText.setText(String.valueOf(mValueOne));
    }

    void buttonCosClick()
    {
        if (mValueOne == 0)
        {
            if (mSimpleEditText.getText()!=null)
                mValueOne = Math.cos(Math.toRadians(Double.parseDouble(mSimpleEditText.getText().toString())));
        }
        mIsFloat = true;
        mSimpleEditText.setText(String.valueOf(mValueOne));
    }

    void buttonTanClick()
    {
        if (mValueOne == 0)
        {
            if (mSimpleEditText.getText()!=null)
                mValueOne = Math.tan(Math.toRadians(Double.parseDouble(mSimpleEditText.getText().toString())));
        }
        mIsFloat = true;
        mSimpleEditText.setText(String.valueOf(mValueOne));
    }

    void buttonCotClick()
    {
        if (mValueOne == 0)
        {
            if (mSimpleEditText.getText()!=null)
                mValueOne = 1 / Math.tan(Math.toRadians(Double.parseDouble(mSimpleEditText.getText().toString())));
        }
        mIsFloat = true;
        mSimpleEditText.setText(String.valueOf(mValueOne));
    }

    void buttonFactorialClick()
    {
        if (mValueOne == 0)
        {
            if (mSimpleEditText.getText()!=null)
                mValueOne = factorial(Integer.parseInt(mSimpleEditText.getText().toString()));
        }
        mIsFloat = true;
        mSimpleEditText.setText(String.valueOf(mValueOne));
    }

    void buttonExpClick()
    {
        if (mValueOne == 0)
        {
            if (mSimpleEditText.getText()!=null)
                mValueOne = Math.exp(Double.parseDouble(mSimpleEditText.getText().toString()));
        }
        mIsFloat = true;
        mSimpleEditText.setText(String.valueOf(mValueOne));
    }

    void buttonLnClick()
    {
        if (mValueOne == 0)
        {
            if (mSimpleEditText.getText()!=null)
                mValueOne = Math.log(Double.parseDouble(mSimpleEditText.getText().toString()));
        }
        mIsFloat = true;
        mSimpleEditText.setText(String.valueOf(mValueOne));
    }

    void buttonSquareClick()
    {
        if (mValueOne == 0)
        {
            if (mSimpleEditText.getText()!=null)
                mValueOne = Math.pow(Double.parseDouble(mSimpleEditText.getText().toString()), 2);
        }
        mIsFloat = true;
        mSimpleEditText.setText(String.valueOf(mValueOne));
    }

    void buttonCClick()
    {
        mValueOne = 0;
        mValueTwo = 0;
        mAddition = false;
        mSubtraction = false;
        mDivision = false;
        mMultilpication = false;
        mIsFloat = false;
        mSimpleEditText.setText("");
    }

    void buttonDotClick()
    {
        if (!mIsFloat)
        {
            mSimpleEditText.setText(mSimpleEditText.getText() + ".");
            mIsFloat = true;
        }
    }

    void buttonEqualClick()
    {
        if(mValueOne!=0)
        {
            equalLogic();
            mSimpleEditText.setText(String.valueOf(mValueOne));
        }
    }
}
