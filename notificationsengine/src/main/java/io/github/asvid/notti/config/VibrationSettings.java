package io.github.asvid.notti.config;

public class VibrationSettings {

    private long[] pattern;
    private boolean vibrate = true;
    public static long[] STD_VIBRATION = {300, 200, 300, 200};
    public static long[] FAST_VIBRATION = {100, 100, 100, 100, 100, 100};

    public VibrationSettings(long... arg) {
        this.pattern = arg;
    }

    public VibrationSettings(long[] pattern, boolean vibrate) {
        this.pattern = pattern;
        this.vibrate = vibrate;
    }

    public VibrationSettings(boolean vibrate) {
        this.vibrate = vibrate;
    }

    public long[] getPattern() {
        return pattern;
    }

    public boolean isVibrate() {
        return vibrate;
    }
}
