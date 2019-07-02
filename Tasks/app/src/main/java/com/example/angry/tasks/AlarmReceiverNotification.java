package com.example.angry.tasks;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class AlarmReceiverNotification extends BroadcastReceiver {

    private static final int NOTIFICATION_ID = 0;
    @Override
    public void onReceive(Context context, Intent intent) {
        updateNotification(context);
    }
    private void updateNotification(Context context) {
        NotificationManager notificationManager= (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Bitmap bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.starter_image);
        Intent intent=new Intent(context,NotificationActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,NOTIFICATION_ID,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context)
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
}
