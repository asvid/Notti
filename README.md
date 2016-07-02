# Notti 
[![Build Status](https://travis-ci.org/asvid/Notti.svg?branch=master)](https://travis-ci.org/asvid/Notti)
[![](https://jitpack.io/v/asvid/Notti.svg)](https://jitpack.io/#asvid/Notti)

Simple library for making quick notifications. After initialisation with config, all notifications will be displayed with same icon, light and vibrations unless you state different for specific notification. 
Every type of notification has same configurable options including vibrations, light settings, icon etc. For details please check usage examples.

Feel free to contribute or create issues with bugs or new features.
 
# Usage
Add library to project dependencies.

```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.asvid:Notti:0.0.6'
}
```
# Examples

## Simple usage
```java
public class MainActivity extends AppCompatActivity {

    private Notti notti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notti = new Notti(this, new NottiConf(R.drawable.ic_stat_name));

        notti.show(NottiFactory.get(NottiFactory.TYPE.STANDARD,
                                              "some text", 
                                              "some content"));
    }
}
```
## NottiConf options
```java
long[] pattern = {100, 200, 100, 200};
boolean shouldVibrate = true;
VibrationSettings vibrationSettings = new VibrationSettings(pattern, shouldVibrate);
//  or simply
VibrationSettings vibrationSettings = new VibrationSettings(VibrationSettings.STD_VIBRATION);

int argb = Color.BLUE;
int onMs = 300;
int offMs = 3000;
LightSettings lightSettings = new LightSettings(argb, onMs, offMs);
//  or simply
LightSettings lightSettings = new LightSettings(Color.BLUE); 

notti = new Notti(this,
        new NottiConf(R.drawable.ic_stat_name, vibrationSettings, lightSettings).setSameID(false));
```


## Adding actions
```java
List<NotificationAction> actionsList = Arrays.asList(
                                                    new NotificationAction("action", intent, this),
                                                    new NotificationAction("action 2", intent, this));


notti.show(NottiFactory
                .get(NottiFactory.TYPE.STANDARD, "some text", "some content")
                .setContentAction(new ContentAction(new Intent(this, MainActivity.class), this))
                .setActions(actionsList));
```
### Using PendingIntents
```java

notti.show(NottiFactory
                .get(NottiFactory.TYPE.STANDARD, "some text", "some content")
                .setContentAction(new ContentAction(PendingIntent.getService(context, 0, intent, 0))));
```

## Notification types
- STANDARD
- INBOX
- BIG_TEXT
- BIG_PICTURE

## Configurable methods
- setTitle(String title);
- setContent(String content);
- setIcon(int icon);
- setActions(List<NotificationAction> actions);
- setId(int ID);
- setBigText(String text);
- setBigPicture(Bitmap picture);
- setLargeIcon(Bitmap image);
- addInboxItem(String item);
- setInboxSummary(String summary);
- setInboxItems(List<String> itemList);
- setContentAction(ContentAction contentAction);
- setLightSettings(LightSettings lightSettings);
- setVibrationSettings(VibrationSettings vibrations);

# License

    Copyright [2016] [Adam Świderski <adam.swiderski89@gmail.com>]
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
    	http://www.apache.org/licenses/LICENSE-2.0
        
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
