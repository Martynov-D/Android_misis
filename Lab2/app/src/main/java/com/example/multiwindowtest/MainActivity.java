package com.example.multiwindowtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    public int m_userScore;
    public static DataBase m_db = null;
    TextView textView;

    public final int testRequestCode = 1;
    public static final String testActivityHash = "testActivityHash";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.mainTextView);

        m_db = new DataBase();
        m_userScore = 0;
    }

    public void onClick(View view)
    {
        Intent testIntent = new Intent(this, TestActivity.class);
        startActivityForResult(testIntent, testRequestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode== Activity.RESULT_CANCELED)
            return;

        switch(requestCode)
        {
            case testRequestCode:
                textView.setText(String.format("User score: %d", data.getIntExtra(testActivityHash, 0)));
                break;
        }
    }
}