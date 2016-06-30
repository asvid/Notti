package io.github.asvid.notificationsengine;

import io.github.asvid.notificationsengine.notifications.BIgTextNotification;
import io.github.asvid.notificationsengine.notifications.BigPictureNotification;
import io.github.asvid.notificationsengine.notifications.CustomNotification;
import io.github.asvid.notificationsengine.notifications.InboxNotification;
import io.github.asvid.notificationsengine.notifications.StandardNotification;

/**
 * Created by adam on 29.06.16.
 */
public class NotificationsFactory {

    public enum TYPE {INBOX, BIG_TEXT, BIG_PICTURE, STANDARD}

    public static CustomNotification get(TYPE type, String title, String content) {
        switch (type) {
            case STANDARD:
                return new StandardNotification(title, content);
            case BIG_TEXT:
                return new BIgTextNotification(title, content);
            case BIG_PICTURE:
                return new BigPictureNotification(title, content);
            case INBOX:
                return new InboxNotification(title, content);
            default:
                return new StandardNotification(title, content);
        }
    }

}
