package com.example.rssparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    ListView mainListView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = findViewById(R.id.listView);
    }

    public void onClick(View view)
    {
        XmlPullParser parser = getResources().getXml(R.xml.simple_rss);
        ArrayList<String> a = new ArrayList<>();

        try
        {
//            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//            XmlPullParser parser = factory.newPullParser();

//            File file = new File(Environment.getExternalStorageState() + "/simple_xml.xml");

//            if(!file.exists())
//            {
//                Toast.makeText(this, "File doesn't exist", Toast.LENGTH_LONG);
//                return;
//            }

//            FileInputStream istream = new FileInputStream(file);
//            InputStreamReader reader = new InputStreamReader(istream);

//            parser.setInput(reader);

            String title = null;
            String link = null;
            String description= null;

            parser.next();
            while (parser.getEventType()!=XmlPullParser.END_DOCUMENT)
            {
                if (parser.getEventType() == XmlPullParser.START_TAG && parser.getName().equals("item"))
                {
                    parser.next();
                    parser.next();
                    title = parser.getText();
                    parser.next();
                    parser.next();
                    parser.next();
                    link = parser.getText();
                    parser.next();
                    parser.next();
                    parser.next();
                    parser.next();
                    parser.next();
                    parser.next();
                    description = parser.getText();
                    a.add(String.format(getResources().getString(R.string.rss_template), title, link, description));
                }
                parser.next();
            }
        }
        catch(XmlPullParserException e)
        {
            Toast.makeText(this, "XmlPullParserException was thrown", Toast.LENGTH_SHORT);
        }
        catch(IOException e)
        {

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, a);

        mainListView.setAdapter(adapter);
    }
}