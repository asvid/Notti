package io.github.asvid.notificationsengine;

/**
 * Created by adam on 14.06.16.
 */
public class NotificationConf {

    private int defaultActionImage;

    public NotificationConf(int defaultActionImage) {
        this.defaultActionImage = defaultActionImage;
    }

    public int getDefaultActionImage() {
        return defaultActionImage;
    }

}
