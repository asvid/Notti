package io.github.asvid.notti.config;

public class NottiConf {

    private int defaultActionImage;
    private boolean sameID = false;
    private LightSettings lightSettings;
    private VibrationSettings vibrationSettings;

    public NottiConf(int defaultActionImage) {
        this.defaultActionImage = defaultActionImage;
    }

    public NottiConf(int defaultActionImage, VibrationSettings vibrationSettings) {
        this.defaultActionImage = defaultActionImage;
        this.sameID = sameID;
        this.vibrationSettings = vibrationSettings;
    }

    public NottiConf(int defaultActionImage, VibrationSettings vibrationSettings,
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

    public NottiConf setSameID(boolean sameID) {
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
