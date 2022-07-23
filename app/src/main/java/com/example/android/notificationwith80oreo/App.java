package com.example.android.notificationwith80oreo;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    public static final String CHANNEL_ONE_ID = "CHANNEL_ONE_ID" ;
    public static final String CHANNEL_TWO_ID = "CHANNEL_TWO_ID" ;


    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(CHANNEL_ONE_ID,"channel 1",NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("Video notifications");

            NotificationChannel channel2 = new NotificationChannel(CHANNEL_TWO_ID,"channel 2",NotificationManager.IMPORTANCE_DEFAULT);
            channel2.setDescription("Audio notifications");

            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            List<NotificationChannel> channelList = new ArrayList<>();
            channelList.add(channel1);
            channelList.add(channel2);
            manager.createNotificationChannels(channelList);
        }

    }
}
