package io.github.asvid.notti.notifications;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

import io.github.asvid.notti.actions.ContentAction;
import io.github.asvid.notti.actions.NotificationAction;
import io.github.asvid.notti.config.LightSettings;
import io.github.asvid.notti.config.VibrationSettings;

public abstract class BaseNotification implements CustomNotification {

    public String title;
    public String content;
    public ContentAction contentAction;
    public String bigText;
    public List<NotificationAction> actions;
    public Integer icon;
    public int ID;
    public Bitmap bigPicture;
    public Bitmap largeImage;
    public List<String> inboxItems = new ArrayList<>();
    public String inboxSummary;
    public LightSettings lightSettings;
    public VibrationSettings vibrationSettings;

    @Override
    public CustomNotification setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public CustomNotification setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public CustomNotification setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    @Override
    public CustomNotification setActions(List<NotificationAction> actions) {
        this.actions = actions;
        return this;
    }

    @Override
    public CustomNotification setId(int ID) {
        this.ID = ID;
        return this;
    }

    @Override
    public List<NotificationAction> getActions() {
        return actions;
    }

    @Override
    public CustomNotification setBigText(String text) {
        this.bigText = text;
        return this;
    }

    @Override
    public CustomNotification setBigPicture(Bitmap picture) {
        this.bigPicture = picture;
        return this;
    }

    @Override
    public CustomNotification setLargeIcon(Bitmap image) {
        this.largeImage = image;
        return this;
    }

    @Override
    public CustomNotification addInboxItem(String item) {
        this.inboxItems.add(item);
        return this;
    }

    @Override
    public CustomNotification setInboxItems(List<String> itemList) {
        this.inboxItems = itemList;
        return this;
    }

    @Override
    public CustomNotification setInboxSummary(String inboxSummary) {
        this.inboxSummary = inboxSummary;
        return this;
    }

    @Override
    public CustomNotification setContentAction(ContentAction contentAction) {
        this.contentAction = contentAction;
        return this;
    }

    @Override
    public ContentAction getContentAction() {
        return contentAction;
    }

    @Override
    public LightSettings getLightSettings() {
        return lightSettings;
    }

    @Override
    public CustomNotification setLightSettings(LightSettings lightSettings) {
        this.lightSettings = lightSettings;
        return this;
    }

    @Override
    public VibrationSettings getVibrationSettings() {
        return vibrationSettings;
    }

    @Override
    public CustomNotification setVibrationSettings(VibrationSettings vibrationSettings) {
        this.vibrationSettings = vibrationSettings;
        return this;
    }
}
