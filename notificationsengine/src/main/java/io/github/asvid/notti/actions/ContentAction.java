package io.github.asvid.notti.actions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class ContentAction extends NotificationAction {
    public ContentAction(Intent intent, Context context) {
        super(intent, context);
    }

    public ContentAction(PendingIntent pendingIntent) {
        super(pendingIntent);
    }
}
