package io.github.asvid.notificationsengine.notifications;

import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;

import java.util.List;

import io.github.asvid.notificationsengine.ContentAction;
import io.github.asvid.notificationsengine.NotificationAction;
import io.github.asvid.notificationsengine.NotificationConf;

/**
 * Created by adam on 29.06.16.
 */
public interface CustomNotification {

    CustomNotification setTitle(String title);

    CustomNotification setContent(String content);

    CustomNotification setIcon(int icon);

    CustomNotification setActions(List<NotificationAction> actions);

    CustomNotification setId(int ID);

    NotificationCompat.Builder setBuilder(NotificationCompat.Builder builder);

    List<NotificationAction> getActions();

    CustomNotification setBigText(String text);

    CustomNotification setBigPicture(Bitmap picture);

    CustomNotification setLargeIcon(Bitmap image);

    CustomNotification addInboxItem(String item);

    CustomNotification setInboxSummary(String item);

    CustomNotification setInboxItems(List<String> itemList);

    CustomNotification setContentAction(ContentAction contentAction);

    ContentAction getContentAction();

    CustomNotification setVibrationPattern(long[] pattern);

    long[] getVibrationPattern();

    NotificationConf.LightSettings getLightSettings();

    CustomNotification setLightSettings(NotificationConf.LightSettings lightSettings);
}
