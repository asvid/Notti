# Notifications Engine 
[![Build Status](https://travis-ci.org/asvid/AndroidNotifications.svg?branch=master)](https://travis-ci.org/asvid/AndroidNotifications) 
[![](https://jitpack.io/v/asvid/NotificationsEngine.svg)](https://jitpack.io/#asvid/NotificationsEngine) 
<a href="http://www.methodscount.com/?lib=com.github.asvid%3ANotificationsEngine%3A0.0.2"><img src="https://img.shields.io/badge/Methods count-38-e91e63.svg"/></a>

simple library for making quick notifications
 
# Usage
Add library to project dependencies.

```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.asvid:NotificationsEngine:0.0.2'
}
```
# Examples

## Simple usage

```java
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
```
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