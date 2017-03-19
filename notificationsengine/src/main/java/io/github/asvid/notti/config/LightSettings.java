package io.github.asvid.notti.config;

public class LightSettings {
    private int argb;
    private int onMs = 300;
    private int offMs = 3000;

    public LightSettings(int argb, int onMs, int offMs) {
        this.argb = argb;
        this.onMs = onMs;
        this.offMs = offMs;
    }

    public LightSettings(int argb) {
        this.argb = argb;
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
