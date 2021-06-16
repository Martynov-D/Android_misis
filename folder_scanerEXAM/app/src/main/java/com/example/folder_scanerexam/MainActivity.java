package com.example.folder_scanerexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class MainActivity extends AppCompatActivity
{

    TextView m_listOfFiles_tv;
    Hashtable<String, File> m_listOfFiles_hash;
    String m_path;
    Vector<String> m_folders;

    NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_listOfFiles_tv = findViewById(R.id.listOfFiles_TV);
        m_listOfFiles_hash = new Hashtable<>();
        m_path = "folders.txt";
        m_folders = new Vector<String>();
        updateFoldersList();

        scaner();

        // выполнять каждые 2 минуты (в миллисекундах)
        timer.schedule(doAsynchronousTask, 0, 120000);
    }

    final Handler handler = new Handler();
    Timer timer = new Timer();
    TimerTask doAsynchronousTask = new TimerTask() {
        @Override
        public void run()
        {
            handler.post(new Runnable()
            {
                public void run()
                {
                    try
                    {
                        scaner();
                    }
                    catch (Exception e)
                    {
                    }
                }
            });
        }
    };


    // сканер папок, указанных в массиве 'folders'
    protected void scaner()
    {
        File a;
        Vector<String> newFiles = new Vector<>();
        String notificationText = "";
        for (String folder : m_folders)
        {
            a = new File(folder);
            for (File file : a.listFiles())
            {
                if (file.isFile())
                {
                    if (!m_listOfFiles_hash.containsKey(file.getName()))
                    {
                        newFiles.add(file.getName());
                        m_listOfFiles_hash.put(file.getName(), file);
                    }
                }
            }
        }
        if (newFiles.size() > 0)
        {
            if (newFiles.size() > 2)
            {
                for (String name : newFiles)
                {
                    m_listOfFiles_tv.append(name);
                    m_listOfFiles_tv.append("\n");
                    notificationText = notificationText + name + ", ";
                }
            }
            else
            {
                m_listOfFiles_tv.append(newFiles.get(0));
                notificationText = newFiles.get(0);
            }
            notification(notificationText);
        }
    }

    // метод, вызывающий пуш уведомление
    protected void notification(String text)
    {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", "My channel",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("My channel description");
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(false);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("New files were found")
                .setContentText(text);

        Notification notification = builder.build();
        notificationManager.notify(1, notification);
    }

    // читает .txt файл и заносит строки в массив 'folders'
    protected void updateFoldersList()
    {
        try
        {
            InputStream iS = getAssets().open(m_path);
            BufferedReader br = new BufferedReader(new InputStreamReader(iS));
            String line;

            while ((line = br.readLine()) != null)
                m_folders.add(line);

            br.close();
        }
        catch (IOException e)
        {
            Log.e("folder_scanner", "exception", e);
        }
    }

    // выводит список папок в text view
    protected void printFolders()
    {
        for (String i : m_folders)
        {
            m_listOfFiles_tv.append(i);
            m_listOfFiles_tv.append("\n");
        }
    }

    // ручное обновление
    public void updateOnClick(View view)
    {
        scaner();
    }
}