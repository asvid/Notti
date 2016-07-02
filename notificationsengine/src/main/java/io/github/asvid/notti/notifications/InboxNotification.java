package io.github.asvid.notti.notifications;

import android.support.v4.app.NotificationCompat;

public class InboxNotification extends BaseNotification {
    public InboxNotification(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public NotificationCompat.Builder setBuilder(NotificationCompat.Builder builder) {
        builder.setContentTitle(title).setContentText(content);
        setBuilderIcon(builder);
        setInboxStyle(builder);
        return builder;
    }

    public void setBuilderIcon(NotificationCompat.Builder builder) {
        if (icon != null) {
            builder.setSmallIcon(icon);
        }
    }

    public void setInboxStyle(NotificationCompat.Builder builder) {
        NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
        for (String item : inboxItems) {
            style.addLine(item);
        }
        if (inboxSummary != null) {
            style.setSummaryText(inboxSummary);
        }
        builder.setStyle(style);
    }
}
