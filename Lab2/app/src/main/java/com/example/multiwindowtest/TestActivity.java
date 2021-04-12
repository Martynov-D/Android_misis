package com.example.multiwindowtest;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class TestActivity extends AppCompatActivity
{
    DataBase db;
    TextView textView;
    Button[] buttons;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState)
    {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_test);

        db = MainActivity.db;
        textView = findViewById(R.id.questionTextView);
        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);

        runTest();
    }

    void runTest()
    {
        String[] answers;
        for (int i=0;i<db.size();++i)
        {
            answers = db.getQuestion(i).getAnswers();
            textView.setText(db.getQuestion(i).getBody());
            for (int j=0;j<buttons.length;++j)
            {
                buttons[j].setText(answers[j]);
            }
            
        }
    }
}
