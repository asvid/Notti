package io.github.asvid.notificationsengineexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.github.asvid.notificationsengine.CustomNotification;
import io.github.asvid.notificationsengine.NotificationConf;
import io.github.asvid.notificationsengine.NotificationsEngine;

public class MainActivity extends AppCompatActivity {

    private NotificationsEngine notificationsEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationsEngine = new NotificationsEngine(this, new NotificationConf(R.drawable.ic_stat_name));

        notificationsEngine.show(new CustomNotification("some text", "some content"));
    }
}
