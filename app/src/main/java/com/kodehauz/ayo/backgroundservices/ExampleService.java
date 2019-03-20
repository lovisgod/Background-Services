package com.kodehauz.ayo.backgroundservices;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

//this channel id is what we created in the app class and we added to the manifest as app
//and it will be accessible to all the activities in the application because we are extending application
import static com.kodehauz.ayo.backgroundservices.App.CHANNEL_ID;

public class ExampleService extends Service {

    //oncreate is called when the class is created

    //we must declare the service in the manifest file
    //stopSelf method can be used to stop the service when we have finished the  background service
    //this stopSelf triggers the onDestroy method which stops the services


    @Override
    public void onCreate() {
        super.onCreate();
    }

    //this method is called when we call the startservice
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //get string from the intent sent from the intent sent to this class
        String input = intent.getStringExtra("Intent");
        //create intent to handle click for the notification
        /* Creates an explicit intent for an Activity in your app */
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, 0);

    //here we create notification for our foregrpund service because to use foreground service we need
        //notification useing the pending intent we create to help take us to the activity

        //note that we can also create the notification in the onCreate method to create the notification once.
        //but we are creating it here because we are passing an intent to start the service
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Example Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(pendingIntent)
                .build();

        //then here we start the foregroung service
        //the id in the method is for the notification

        startForeground(1, notification);

        // we return start not sticky becuase we dont really care if the app is killed for now
        return START_NOT_STICKY;

    }

    //this method is called when the service is destroyed

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
