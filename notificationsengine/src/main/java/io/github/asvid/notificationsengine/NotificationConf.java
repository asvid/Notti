package io.github.asvid.notificationsengine;

/**
 * Created by adam on 14.06.16.
 */
public class NotificationConf {

    private int defaultActionImage;
    private boolean sameID = false;

    public NotificationConf(int defaultActionImage) {
        this.defaultActionImage = defaultActionImage;
    }

    public NotificationConf(int defaultActionImage, boolean sameID) {
        this.defaultActionImage = defaultActionImage;
        this.sameID = sameID;
    }

    public int getDefaultActionImage() {
        return defaultActionImage;
    }

    public boolean isSameID() {
        return sameID;
    }
}
