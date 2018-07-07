package playlagom.sharelocation.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import playlagom.sharelocation.R;

/**
 * Created by Sakib on 7/7/2018.
 */

public class MyNotificationManager {

    private Context context;
    public static final int NOTIFICATION_ID = 234;

    public MyNotificationManager(Context context) {
        this.context = context;
    }

    public void showNotification(String from, String notification, Intent intent) {
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                NOTIFICATION_ID,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        // Notification with Sound
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        // Notification with Vibration
        // todo: https://www.concretepage.com/android/android-notification-example-with-vibration-sound-action-and-big-view-styles
        long[] v = {500,1000};

        Notification notification1 = builder.setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentTitle("Notification: msg, nearby, tour, danger")
                .setContentText(notification)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setSound(uri)
                .setVibrate(v)
                .build();

        notification1.flags |= Notification.FLAG_AUTO_CANCEL;

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification1);
    }
}
