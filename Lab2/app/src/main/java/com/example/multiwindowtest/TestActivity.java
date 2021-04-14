package com.example.multiwindowtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class TestActivity extends AppCompatActivity
{
    DataBase db;
    TextView question;
    Button[] buttons;
    int userScore = 0;
    int userAnswer = -1;
    String[] answers=null;
    int m_index;
    int nAnswers;
    Intent infoForMain;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        db = MainActivity.m_db;

        infoForMain = new Intent();

        buttons = new Button[4];
        question = findViewById(R.id.questionTextView);
        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        for (Button button : buttons)
            button.setEnabled(false);

        nAnswers = db.size()-1;
        m_index=0;
        switchText(m_index);
    }

    void switchText(int index)
    {
        answers = db.getQuestion(index).getAnswers();
        question.setText(db.getQuestion(index).getBody());
        for (int j = 0; j < buttons.length; ++j)
        {
            buttons[j].setText(answers[j]);
            buttons[j].setEnabled(true);
        }
    }

    void checkAnswers(int index)
    {
        if (userAnswer != db.getQuestion(index).getCorrectAnswerIndex())
            if(userScore>0)
                userScore -= 1;
            else
                return;
        else
            userScore += 2;
    }

    void sendResult(boolean buttonFlag)
    {
        if (buttonFlag)
        {
            infoForMain.putExtra(MainActivity.testActivityHash, userScore);
            setResult(Activity.RESULT_OK, infoForMain);
            finish();
        }
        else
        {
            setResult(Activity.RESULT_CANCELED, infoForMain);
            finish();
        }
    }

    public void b1onClick(View view)
    {
        userAnswer = 1;
        checkAnswers(m_index);
        if (m_index<nAnswers)
            switchText(++m_index);
        else
            sendResult(true);
    }

    public void b2onClick(View view)
    {
        userAnswer = 2;
        checkAnswers(m_index);
        if (m_index<nAnswers)
            switchText(++m_index);
        else
            sendResult(true);

    }

    public void b3onClick(View view)
    {
        userAnswer = 3;
        checkAnswers(m_index);
        if (m_index<nAnswers)
            switchText(++m_index);
        else
            sendResult(true);
    }

    public void b4onClick(View view)
    {
        userAnswer = 4;
        checkAnswers(m_index);
        if (m_index<nAnswers)
            switchText(++m_index);
        else
            sendResult(true);
    }

    public void backButtononClick(View view)
    {
        sendResult(false);
    }
}
