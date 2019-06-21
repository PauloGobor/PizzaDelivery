package edu.up.pizzadelivery.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import java.util.Random;

import edu.up.pizzadelivery.R;
import edu.up.pizzadelivery.view.MainActivity;

public class notification {


    public static void enviarNotificacao(Context context, String titulo, String texto)
    {
//        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder notificacao = new NotificationCompat.Builder(context, "1")
//                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
//                .setContentTitle(titulo)
//                .setContentText(texto)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .setVibrate(new long[]{0, 250, 100, 250})
//                .setSound(defaultSoundUri);
//        Random rand = new Random();
//
//        NotificationManagerCompat manager = NotificationManagerCompat.from(context);
//        manager.notify(1, notificacao.build());

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        int NOTIFICATION_ID = 234;
        String CHANNEL_ID = "my_channel_01";
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle(titulo)
                .setContentText(texto)
                .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400})
                .setSound(defaultSoundUri);

        notificationManager.notify(NOTIFICATION_ID, builder.build());

    }
}
