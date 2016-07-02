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
import io.github.asvid.notti.Notti;
import io.github.asvid.notti.NottiFactory;
import io.github.asvid.notti.actions.ContentAction;
import io.github.asvid.notti.actions.NotificationAction;
import io.github.asvid.notti.config.LightSettings;
import io.github.asvid.notti.config.NottiConf;
import io.github.asvid.notti.config.VibrationSettings;

public class MainActivity extends AppCompatActivity {

    private Notti notti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        notti = new Notti(this,
                new NottiConf(R.drawable.ic_stat_name,
                        new VibrationSettings(VibrationSettings.STD_VIBRATION),
                        new LightSettings(Color.BLUE)));
    }

    @OnClick(R.id.simpleNotification)
    void simpleNotification() {
        notti.show(NottiFactory
                .get(NottiFactory.TYPE.STANDARD, "some text", "some content")
                .setContentAction(new ContentAction(new Intent(this, MainActivity.class), this)));
    }

    @OnClick(R.id.simpleNotificationActions)
    void simpleNotificationActions() {
        Intent intent = new Intent(this, MainActivity.class);

        List<NotificationAction> actionsList = Arrays
                .asList(new NotificationAction("action", intent, this),
                        new NotificationAction("action 2", intent, this));

        notti.show(NottiFactory
                .get(NottiFactory.TYPE.STANDARD, "some text", "some content")
                .setActions(actionsList));
    }

    @OnClick(R.id.bigTextNotification)
    void bigTextNotification() {
        notti.show(NottiFactory
                .get(NottiFactory.TYPE.BIG_TEXT, "some text", "some content").setBigText(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam posuere arcu enim, ut imperdiet sem pellentesque quis. Morbi in tempus lorem. Integer venenatis risus sit amet dolor lobortis, et consequat neque luctus. Etiam ut est nulla. Quisque turpis sapien, aliquet a consequat in, lacinia ut neque. Praesent scelerisque maximus nisi, sed pharetra nulla varius id. Proin at augue purus. Aliquam ut ullamcorper lorem, at vehicula nisl. Pellentesque imperdiet nunc vitae quam consectetur tempus. Nullam vel auctor orci. Ut a turpis ac quam placerat vestibulum. Sed ac hendrerit lorem, non imperdiet neque. Sed nisl urna, eleifend ac sem et, accumsan consectetur felis. Quisque cursus interdum erat, sit amet maximus felis consectetur ac. Aenean luctus, mi nec elementum bibendum, felis felis lacinia justo, vitae lacinia ligula nibh ut nulla. Nunc viverra commodo augue, in cursus nulla."));
    }

    @OnClick(R.id.inboxNotification)
    void inboxNotification() {
        notti.show(NottiFactory
                .get(NottiFactory.TYPE.INBOX, "some text", "some content")
                .addInboxItem("some item").addInboxItem("another item")
                .addInboxItem("and final item").setInboxSummary("random summary"));
    }

    @OnClick(R.id.bigPictureNotification)
    void bigPictureNotification() {
        Bitmap icon = BitmapFactory.decodeResource(this.getResources(), R.mipmap.picture);
        notti.show(NottiFactory
                .get(NottiFactory.TYPE.BIG_PICTURE, "some text", "some " + "content")
                .setBigPicture(icon).setLargeIcon(icon));
    }
}
