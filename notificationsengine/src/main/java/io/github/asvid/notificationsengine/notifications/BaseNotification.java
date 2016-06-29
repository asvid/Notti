package io.github.asvid.notificationsengine.notifications;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

import io.github.asvid.notificationsengine.NotificationAction;

/**
 * Created by adam on 29.06.16.
 */
public abstract class BaseNotification implements CustomNotification {

    public String title;
    public String content;
    public String bigText;
    public ArrayList<NotificationAction> actions;
    public Integer icon;
    public int ID;
    public Bitmap bigPicture;
    public Bitmap largeImage;

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
    public CustomNotification setActions(ArrayList<NotificationAction> actions) {
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
        return null;
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
}
