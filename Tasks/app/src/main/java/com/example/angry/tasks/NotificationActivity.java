package com.example.angry.tasks;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.AlarmManagerCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotificationActivity extends AppCompatActivity {

    private NotificationManager notificationManager;
    private static final int NOTIFICATION_ID = 0;
    private static final String ACTION_UPDATE_NOTIFICATION="com.example.angry.tasks.ACTION_UPDATE_NOTIFICATION";
    //private NotificationReceiverClass notificationReceiverClass;
    private AlarmReceiverNotification alarmReceiverNotification;
    private AlarmManager alarmManager;
    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        //Intent intent=new Intent(ACTION_UPDATE_NOTIFICATION);
        Intent intent=new Intent(this,AlarmReceiverNotification.class);
        final PendingIntent pendingIntent=PendingIntent.getBroadcast(this,NOTIFICATION_ID,intent,PendingIntent.FLAG_ONE_SHOT);
        findViewById(R.id.notify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long triggerTime = SystemClock.elapsedRealtime()+300;
                        //+ AlarmManager.INTERVAL_FIFTEEN_MINUTES;

                long repeatInterval = AlarmManager.INTERVAL_FIFTEEN_MINUTES;

////If the Toggle is turned on, set the repeating alarm with a 15 minute interval
                alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        triggerTime, repeatInterval, pendingIntent);
//                sendNotification();
            }
        });
//        findViewById(R.id.updateNotify).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                updateNotification();
//            }
//        });
        //notificationReceiverClass=new NotificationReceiverClass();
        //alarmReceiverNotification=new AlarmReceiverNotification();
        //registerReceiver(alarmReceiverNotification,)
        //registerReceiver(notificationReceiverClass,new IntentFilter(ACTION_UPDATE_NOTIFICATION));
    }

    private void updateNotification() {
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.starter_image);
        Intent intent=new Intent(this,NotificationActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,NOTIFICATION_ID,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setContentTitle("Notify")
                .setContentText("New Notification")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setStyle(new NotificationCompat.BigPictureStyle()
                    .bigPicture(bitmap)
                    .setBigContentTitle("Updated!!"))
                .setContentIntent(pendingIntent);
        notificationManager.notify(NOTIFICATION_ID,builder.build());
    }

    private void sendNotification() {

        //Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/design/patterns/notifications.html."));
        //PendingIntent pendingIntent=PendingIntent.getActivity(this,NOTIFICATION_ID,intent,PendingIntent.FLAG_ONE_SHOT);
        Intent intent=new Intent(ACTION_UPDATE_NOTIFICATION);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,NOTIFICATION_ID,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setContentTitle("Notify")
                .setContentText("New Notification")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .addAction(R.drawable.action_alert,"CLick",pendingIntent);
        Notification notification=builder.build();
        notificationManager.notify(NOTIFICATION_ID,notification);

    }
//    public class NotificationReceiverClass extends BroadcastReceiver{
//        NotificationReceiverClass(){}
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            updateNotification();
//        }
//    }

    @Override
    protected void onDestroy() {
       // unregisterReceiver(notificationReceiverClass);
        super.onDestroy();
    }
}