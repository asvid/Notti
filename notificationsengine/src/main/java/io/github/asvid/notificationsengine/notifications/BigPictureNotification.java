package io.github.asvid.notificationsengine.notifications;

import android.support.v4.app.NotificationCompat;

/**
 * Created by adam on 29.06.16.
 */
public class BigPictureNotification extends BaseNotification {
    public BigPictureNotification(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public NotificationCompat.Builder setBuilder(NotificationCompat.Builder builder) {
        builder.setContentTitle(title).setContentText(content);
        setBuilderIcon(builder);
        setBigPictureStyle(builder);
        return builder;
    }

    public void setBuilderIcon(NotificationCompat.Builder builder) {
        if (icon != null) {
            builder.setSmallIcon(icon);
        }
    }

    public void setBigPictureStyle(NotificationCompat.Builder builder) {
        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        if (bigPicture != null) {
            style.bigPicture(bigPicture);
        }
        if (largeImage != null) {
            builder.setLargeIcon(largeImage);
        }
        builder.setStyle(style);
    }
}
