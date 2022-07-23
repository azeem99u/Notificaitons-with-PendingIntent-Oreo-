package com.example.android.notificationwith80oreo;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myTag";
    public static final String MESSAGE_KEY ="MESSAGE_KEY" ;
    NotificationManager manager;
    EditText etTitle;
    EditText etDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTitle = findViewById(R.id.et1);
        etDesc = findViewById(R.id.et2);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        findViewById(R.id.button).setOnClickListener(view -> {
            String title = etTitle.getText().toString();
            String desc = etDesc.getText().toString();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, App.CHANNEL_ONE_ID);
            builder.setContentTitle(title);
            builder.setContentText(desc);
            builder.setSmallIcon(R.drawable.ic_baseline_video_library_24);
            builder.setPriority(NotificationCompat.PRIORITY_HIGH);
            Notification notification = builder.build();
            manager.notify(1, notification);
        });
        findViewById(R.id.button2).setOnClickListener(view -> {
            String title = etTitle.getText().toString();
            String desc = etDesc.getText().toString();


            Intent intent = new Intent(this,MainActivity.class);
            PendingIntent pendingIntent  = PendingIntent.getActivity(this,2,intent,0);


            Intent intentSecondActivity = new Intent(this,SecondActivity.class);
            intentSecondActivity.putExtra(MESSAGE_KEY,desc);
            PendingIntent pendingIntentSecondActivity  = PendingIntent.getActivity(this,3,intentSecondActivity,PendingIntent.FLAG_UPDATE_CURRENT);

            Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_TWO_ID)
                    .setContentTitle(title)
                    .setContentIntent(pendingIntent)
                    .setContentText(desc)
                    .addAction(new NotificationCompat.Action(R.drawable.ic_baseline_video_library_24,"action 1",pendingIntentSecondActivity))
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .setAutoCancel(true)
                    .setColor(Color.YELLOW)
                    .setCategory(Notification.CATEGORY_MESSAGE)
                    .setOnlyAlertOnce(true)
                    .setDefaults(NotificationCompat.DEFAULT_ALL)
                    .setSmallIcon(R.drawable.ic_baseline_library_music_24)
                    .build();
            manager.notify(2, notification);
        });

    }
}