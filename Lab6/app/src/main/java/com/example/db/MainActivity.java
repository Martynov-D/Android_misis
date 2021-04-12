package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;

import com.example.db.data.DBHelper;
import com.example.db.data.StudentDBContract.*;

public class MainActivity extends AppCompatActivity
{

    private DBHelper dbHelper = null;
    private EditText surnameText = null;
    private EditText nameText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        surnameText = (EditText) findViewById(R.id.autoCompleteTextView_surname);
        nameText = (EditText) findViewById(R.id.autoCompleteTextView_name);
    }

    public void insertButtononClick(View view)
    {
        String sql = String.format(
                "INSERT INTO %s (%s, %s) VALUES ('%s', '%s');",
                Students.tableName,
                Students.columnSurname,
                Students.columnName,
                surnameText.getText().toString(),
                nameText.getText().toString()
        );
        try
        {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL(sql);
            surnameText.setText("");
            nameText.setText("");
        }
        catch(SQLException ex)
        {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
        }
    }

    public void deleteButtononClick(View view)
    {
        String sql = String.format(
                "DELETE FROM %s "
                        + "WHERE %s = '%s' "
                        + "AND %s = '%s';",
                Students.tableName,
                Students.columnSurname,
                surnameText.getText().toString(),
                Students.columnName,
                nameText.getText().toString()
        );
        try
        {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL(sql);
            surnameText.setText("");
            nameText.setText("");
            viewButtononClick(view);
        }
        catch(SQLException ex)
        {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
        }
    }

    public void viewButtononClick(View view)
    {
        TextView res = findViewById(R.id.textView);
        res.setText("");
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = String.format("SELECT * FROM %s;", Students.tableName);
        Cursor cursor = db.rawQuery(sql, null);
        try
        {
            String surname;
            String name;
            String info;
            int surnameIndex = cursor.getColumnIndex(Students.columnSurname);
            int nameIndex = cursor.getColumnIndex(Students.columnName);
            while (cursor.moveToNext())
            {
                surname = cursor.getString(surnameIndex);
                name = cursor.getString(nameIndex);
                info = String.format("Фамилия: %1$s\n Имя: %2$s\n", surname, name);
                res.append(info);
            }
        }
        finally
        {
            cursor.close();
        }
    }

    public void updadteButtononClick(View view)
    {

    }
}