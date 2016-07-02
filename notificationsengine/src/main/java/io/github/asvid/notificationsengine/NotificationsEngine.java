package io.github.asvid.notificationsengine;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import java.util.HashMap;
import java.util.Map;

import io.github.asvid.notificationsengine.actions.NotificationAction;
import io.github.asvid.notificationsengine.config.LightSettings;
import io.github.asvid.notificationsengine.config.NotificationConf;
import io.github.asvid.notificationsengine.config.VibrationSettings;
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
        this.notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void show(CustomNotification customNotification) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        setBuilderWithConfig(builder);
        customNotification.setBuilder(builder);
        setActionsForNotification(builder, customNotification);
        setContentIntent(customNotification, builder);
        setDiode(customNotification, builder);
        setVibrations(customNotification, builder);
        notificationManager.notify(getNotificationID(), builder.build());
    }

    private void setVibrations(CustomNotification customNotification,
            NotificationCompat.Builder builder) {
        VibrationSettings vibrationSettings = notificationConf.getVibrationSettings();
        VibrationSettings customVibrationSettings = customNotification.getVibrationSettings();
        if (vibrationSettings != null && vibrationSettings.isVibrate()) {
            builder.setVibrate(vibrationSettings.getPattern());
        } else if (customVibrationSettings != null && customVibrationSettings.isVibrate()) {
            builder.setVibrate(customVibrationSettings.getPattern());
        }
    }

    private void setDiode(CustomNotification customNotification,
            NotificationCompat.Builder builder) {
        LightSettings lightSettings = notificationConf.getLightSettings();
        LightSettings customLightSettings = customNotification.getLightSettings();
        if (lightSettings != null) {
            builder.setLights(lightSettings.getArgb(), lightSettings.getOnMs(),
                    lightSettings.getOffMs());
        } else if (customLightSettings != null) {
            builder.setLights(customLightSettings.getArgb(), customLightSettings.getOnMs(),
                    customLightSettings.getOffMs());
        }
    }

    private void setContentIntent(CustomNotification customNotification,
            NotificationCompat.Builder builder) {
        if (customNotification.getContentAction() != null) {
            builder.setContentIntent(customNotification.getContentAction().getPendingIntent());
        }
    }

    private int provideIcon(Integer icon) {
        if (null == icon) {
            return notificationConf.getDefaultActionImage();
        }
        return icon;
    }

    private void setActionsForNotification(NotificationCompat.Builder builder,
            CustomNotification customNotification) {
        if (customNotification.getActions() != null) {
            for (NotificationAction notificationAction : customNotification.getActions()) {
                builder.addAction(provideIcon(notificationAction.getImage()),
                        notificationAction.getText(), notificationAction.getPendingIntent());
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
