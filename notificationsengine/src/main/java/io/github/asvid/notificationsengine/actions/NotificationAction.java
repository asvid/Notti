package io.github.asvid.notificationsengine.actions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * Created by adam on 14.06.16.
 */
public class NotificationAction {

    private String text;
    private Intent intent;
    private int image;
    private Context context;
    private PendingIntent pendingIntent;

    public NotificationAction(Intent intent, Context context) {
        this.intent = intent;
        this.context = context;
    }

    public NotificationAction(String text, Intent intent, Context context) {
        this.text = text;
        this.intent = intent;
        this.context = context;
    }

    public NotificationAction(String text, Intent intent, int image, Context context) {
        this.text = text;
        this.intent = intent;
        this.image = image;
        this.context = context;
    }

    public NotificationAction(String text, PendingIntent pendingIntent, int image) {
        this.text = text;
        this.pendingIntent = pendingIntent;
        this.image = image;
    }

    public PendingIntent getPendingIntent() {
        if (pendingIntent != null) {
            return pendingIntent;
        }
        PendingIntent pendingIntent;
        pendingIntent = PendingIntent.getActivity(context, getRequestCode(), intent, 0);
        return pendingIntent;
    }

    private int getRequestCode() {
        return 0;
    }

    public String getText() {
        return text;
    }

    public Intent getIntent() {
        return intent;
    }

    public int getImage() {
        return image;
    }

    public Context getContext() {
        return context;
    }
}


