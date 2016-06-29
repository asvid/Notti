package io.github.asvid.notificationsengine;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import java.util.HashMap;
import java.util.Map;

import io.github.asvid.notificationsengine.notifications.CustomNotification;

/**
 * Created by adam on 14.06.16.
 */
public class NotificationsEngine {

    private Context context;
    private NotificationConf notificationConf;
    private NotificationManager notificationManager;
    private Map<String, Integer> ids = new HashMap<>();
    private int currentID = 0;

    public NotificationsEngine(Context context, NotificationConf notificationConf) {
        this.context = context;
        this.notificationConf = notificationConf;
        this.notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void show(CustomNotification customNotification) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        setBuilderWithConfig(builder);
        setActionsForNotification(customNotification.setBuilder(builder), customNotification);
        notificationManager.notify(getNotificationID(), builder.build());
    }

    private int provideIcon(Integer icon) {
        if (null == icon) {
            return notificationConf.getDefaultActionImage();
        }
        return icon;
    }

    private void setActionsForNotification(NotificationCompat.Builder builder, CustomNotification customNotification) {
        if (customNotification.getActions() != null) {
            for (NotificationAction notificationAction : customNotification.getActions()) {
                builder.addAction(provideIcon(notificationAction.getImage()), notificationAction.getText(), notificationAction.getPendingIntent());
            }
        }
    }

    public int getNotificationID() {
        if (!notificationConf.isSameID()) {
            return currentID++;
        }
        return 0;
    }

    public int getIDbyString(String string) {
        return ids.get(string);
    }

    public void putID(String string) {
        // TODO: 28.06.16 maybe take random and check if already exists?
        ids.put(string, getNotificationID());
    }

    public void setBuilderWithConfig(NotificationCompat.Builder builder) {
        builder.setSmallIcon(notificationConf.getDefaultActionImage());
    }
}
