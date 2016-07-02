package io.github.asvid.notificationsengine.config;

/**
 * Created by adam on 14.06.16.
 */
public class NotificationConf {

    private int defaultActionImage;
    private boolean sameID = false;
    private LightSettings lightSettings;
    private VibrationSettings vibrationSettings;

    public NotificationConf(int defaultActionImage) {
        this.defaultActionImage = defaultActionImage;
    }

    public NotificationConf(int defaultActionImage, VibrationSettings vibrationSettings) {
        this.defaultActionImage = defaultActionImage;
        this.sameID = sameID;
        this.vibrationSettings = vibrationSettings;
    }

    public NotificationConf(int defaultActionImage, VibrationSettings vibrationSettings,
            LightSettings lightSettings) {
        this.defaultActionImage = defaultActionImage;
        this.sameID = sameID;
        this.vibrationSettings = vibrationSettings;
        this.lightSettings = lightSettings;
    }

    public int getDefaultActionImage() {
        return defaultActionImage;
    }

    public boolean isSameID() {
        return sameID;
    }

    public NotificationConf setSameID(boolean sameID) {
        this.sameID = sameID;
        return this;
    }

    public VibrationSettings getVibrationSettings() {
        return vibrationSettings;
    }

    public LightSettings getLightSettings() {
        return lightSettings;
    }
}
