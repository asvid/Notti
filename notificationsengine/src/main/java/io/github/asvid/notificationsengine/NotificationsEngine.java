package io.github.asvid.notificationsengine;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

/**
 * Created by adam on 14.06.16.
 */
public class NotificationsEngine {

    private Context context;
    private NotificationConf notificationConf;
    private NotificationManager notificationManager;

    public NotificationsEngine(Context context, NotificationConf notificationConf) {
        this.context = context;
        this.notificationConf = notificationConf;
        this.notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void show(CustomNotification customNotification) {
        Notification.Builder mBuilder = new Notification.Builder(context)
                .setSmallIcon(provideIcon(customNotification.getIcon()))
                .setAutoCancel(true)
                .setContentTitle(customNotification.getTitle())
                .setContentText(customNotification.getTxt());
        setActionsForNotification(mBuilder, customNotification);
        notificationManager.notify(0, mBuilder.build());
    }

    private int provideIcon(Integer icon) {
        if (null == icon) {
            return notificationConf.getDefaultActionImage();
        }
        return icon;
    }

    private void setActionsForNotification(Notification.Builder builder, CustomNotification customNotification) {
        if (customNotification.getActions() != null) {
            for (NotificationAction notificationAction : customNotification.getActions()) {
                builder.addAction(provideIcon(notificationAction.getImage()), notificationAction.getText(), notificationAction.getPendingIntent());
            }
        }
    }
}
