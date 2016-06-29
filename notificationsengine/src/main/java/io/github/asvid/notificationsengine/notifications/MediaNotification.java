package io.github.asvid.notificationsengine.notifications;

import android.support.v4.app.NotificationCompat;

import java.util.ArrayList;

import io.github.asvid.notificationsengine.NotificationAction;

/**
 * Created by adam on 29.06.16.
 */
public class MediaNotification extends BaseNotification {
    public MediaNotification(String title, String content) {
        this.title = title;
        this.content = content;
    }


    @Override
    public NotificationCompat.Builder setBuilder(NotificationCompat.Builder builder) {
        builder.setContentTitle(title).setContentText(content);
        setBuilderIcon(builder);

        return builder;
    }

    public void setBuilderIcon(NotificationCompat.Builder builder) {
        if (icon != null) {
            builder.setSmallIcon(icon);
        }
    }
}
