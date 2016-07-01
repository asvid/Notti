package io.github.asvid.notificationsengine;

/**
 * Created by adam on 14.06.16.
 */
public class NotificationConf {

    private int defaultActionImage;
    private boolean sameID = false;
    private long[] vibrationPattern;
    private LightSettings lightSettings;

    public NotificationConf(int defaultActionImage) {
        this.defaultActionImage = defaultActionImage;
    }

    public NotificationConf(int defaultActionImage, boolean sameID) {
        this.defaultActionImage = defaultActionImage;
        this.sameID = sameID;
    }

    public NotificationConf(int defaultActionImage, boolean sameID, long[] vibrationPattern) {
        this.defaultActionImage = defaultActionImage;
        this.sameID = sameID;
        this.vibrationPattern = vibrationPattern;
    }

    public NotificationConf(int defaultActionImage, boolean sameID, long[] vibrationPattern,
            LightSettings lightSettings) {
        this.defaultActionImage = defaultActionImage;
        this.sameID = sameID;
        this.vibrationPattern = vibrationPattern;
        this.lightSettings = lightSettings;
    }

    public int getDefaultActionImage() {
        return defaultActionImage;
    }

    public boolean isSameID() {
        return sameID;
    }

    public long[] getVibrationPattern() {
        return vibrationPattern;
    }

    public LightSettings getLightSettings() {
        return lightSettings;
    }

    public class LightSettings {
        private int argb = 0xff00ff00;
        private int onMs = 300;
        private int offMs = 100;

        public LightSettings(int argb, int onMs, int offMs) {
            this.argb = argb;
            this.onMs = onMs;
            this.offMs = offMs;
        }

        public int getArgb() {
            return argb;
        }

        public int getOnMs() {
            return onMs;
        }

        public int getOffMs() {
            return offMs;
        }
    }
}
