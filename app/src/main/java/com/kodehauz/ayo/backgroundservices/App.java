package com.kodehauz.ayo.backgroundservices;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class App extends Application {
    public static final String CHANNEL_ID = "exampleServiceChannel";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotification();
    }

    private void createNotification() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            //first create notification channel
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    "ExampleServiceChannel", NotificationManager.IMPORTANCE_DEFAULT);
            //then we use notification manager to create the notification channel
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
    }


}
