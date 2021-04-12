package com.example.multiwindowtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    public int userScore;
    public static DataBase db;

    public final int testRequestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataBase();
        userScore = 0;
    }

    public void onClick(View view)
    {
        Intent testIntent = new Intent();
        startActivityForResult(testIntent, testRequestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if (resultCode== Activity.RESULT_CANCELED)
            return;

        switch(requestCode)
        {
            case testRequestCode:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}