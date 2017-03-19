package io.github.asvid.notti;

import io.github.asvid.notti.notifications.BIgTextNotification;
import io.github.asvid.notti.notifications.BigPictureNotification;
import io.github.asvid.notti.notifications.CustomNotification;
import io.github.asvid.notti.notifications.InboxNotification;
import io.github.asvid.notti.notifications.StandardNotification;

public class NottiFactory {

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
