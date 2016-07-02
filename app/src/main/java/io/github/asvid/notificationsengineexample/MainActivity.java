package io.github.asvid.notificationsengineexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.asvid.notificationsengine.NotificationsEngine;
import io.github.asvid.notificationsengine.NotificationsFactory;
import io.github.asvid.notificationsengine.actions.ContentAction;
import io.github.asvid.notificationsengine.actions.NotificationAction;
import io.github.asvid.notificationsengine.config.LightSettings;
import io.github.asvid.notificationsengine.config.NotificationConf;
import io.github.asvid.notificationsengine.config.VibrationSettings;

public class MainActivity extends AppCompatActivity {

    private NotificationsEngine notificationsEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        notificationsEngine = new NotificationsEngine(this,
                new NotificationConf(R.drawable.ic_stat_name,
                        new VibrationSettings(VibrationSettings.STD_VIBRATION),
                        new LightSettings(Color.BLUE)));
    }

    @OnClick(R.id.simpleNotification)
    void simpleNotification() {
        notificationsEngine.show(NotificationsFactory
                .get(NotificationsFactory.TYPE.STANDARD, "some text", "some content")
                .setContentAction(new ContentAction(new Intent(this, MainActivity.class), this)));
    }

    @OnClick(R.id.simpleNotificationActions)
    void simpleNotificationActions() {
        Intent intent = new Intent(this, MainActivity.class);

        List<NotificationAction> actionsList = Arrays
                .asList(new NotificationAction("action", intent, this),
                        new NotificationAction("action 2", intent, this));

        notificationsEngine.show(NotificationsFactory
                .get(NotificationsFactory.TYPE.STANDARD, "some text", "some content")
                .setActions(actionsList));
    }

    @OnClick(R.id.bigTextNotification)
    void bigTextNotification() {
        notificationsEngine.show(NotificationsFactory
                .get(NotificationsFactory.TYPE.BIG_TEXT, "some text", "some content").setBigText(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam posuere arcu enim, ut imperdiet sem pellentesque quis. Morbi in tempus lorem. Integer venenatis risus sit amet dolor lobortis, et consequat neque luctus. Etiam ut est nulla. Quisque turpis sapien, aliquet a consequat in, lacinia ut neque. Praesent scelerisque maximus nisi, sed pharetra nulla varius id. Proin at augue purus. Aliquam ut ullamcorper lorem, at vehicula nisl. Pellentesque imperdiet nunc vitae quam consectetur tempus. Nullam vel auctor orci. Ut a turpis ac quam placerat vestibulum. Sed ac hendrerit lorem, non imperdiet neque. Sed nisl urna, eleifend ac sem et, accumsan consectetur felis. Quisque cursus interdum erat, sit amet maximus felis consectetur ac. Aenean luctus, mi nec elementum bibendum, felis felis lacinia justo, vitae lacinia ligula nibh ut nulla. Nunc viverra commodo augue, in cursus nulla."));
    }

    @OnClick(R.id.inboxNotification)
    void inboxNotification() {
        notificationsEngine.show(NotificationsFactory
                .get(NotificationsFactory.TYPE.INBOX, "some text", "some content")
                .addInboxItem("some item").addInboxItem("another item")
                .addInboxItem("and final item").setInboxSummary("random summary"));
    }

    @OnClick(R.id.bigPictureNotification)
    void bigPictureNotification() {
        Bitmap icon = BitmapFactory.decodeResource(this.getResources(), R.mipmap.picture);
        notificationsEngine.show(NotificationsFactory
                .get(NotificationsFactory.TYPE.BIG_PICTURE, "some text", "some " + "content")
                .setBigPicture(icon).setLargeIcon(icon));
    }
}
