package io.github.asvid.notificationsengine.notifications;

import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;

import java.util.ArrayList;
import java.util.List;

import io.github.asvid.notificationsengine.NotificationAction;

/**
 * Created by adam on 29.06.16.
 */
public interface CustomNotification {

    CustomNotification setTitle(String title);

    CustomNotification setContent(String content);

    CustomNotification setIcon(int icon);

    CustomNotification setActions(ArrayList<NotificationAction> actions);

    CustomNotification setId(int ID);

    NotificationCompat.Builder setBuilder(NotificationCompat.Builder builder);

    List<NotificationAction> getActions();

    CustomNotification setBigText(String text);

    CustomNotification setBigPicture(Bitmap picture);

    CustomNotification setLargeIcon(Bitmap image);
}
