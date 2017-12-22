package com.example.fiza1.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static  final int id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification=new NotificationCompat.Builder(this); //updated with channel. channel gives number of notifications app gives
        notification.setAutoCancel(true);
    }

    public void Button_Clicked(View view){
        notification.setSmallIcon(R.drawable.insta);

        notification.setTicker("Notifications");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Instagram");
        notification.setContentTitle("Sarah posted new picture on Instagram");

        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //builds notification and issues it
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(id,notification.build()); //notify function
    }
}
