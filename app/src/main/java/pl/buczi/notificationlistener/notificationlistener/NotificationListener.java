package pl.buczi.notificationlistener.notificationlistener;

import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

import android.util.Log;
import static android.content.ContentValues.TAG;

public class NotificationListener extends NotificationListenerService {

    String FACEBOOK_PACK_NAME = "com.facebook.katana";
    String FACEBOOK_MESSENGER_PACK_NAME = "com.facebook.orca";
    String WHATSAPP_PACK_NAME = "com.whatsapp";
    String INSTAGRAM_PACK_NAME = "com.instagram.android";

    private String title;
    private String text;

    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    public void onNotificationPosted(StatusBarNotification sbn) {

        Log.i(TAG, "**********  onNotificationPosted");

        String package_name = sbn.getPackageName();
        if (package_name.equals(FACEBOOK_PACK_NAME) || package_name.equals(FACEBOOK_MESSENGER_PACK_NAME) || package_name.equals(WHATSAPP_PACK_NAME) || package_name.equals(INSTAGRAM_PACK_NAME)) {

            title = sbn.getNotification().extras.getString("android.title");
            text = sbn.getNotification().extras.getString("android.text");

            Intent intent = new Intent("pl.buczi.notificationlistener");
            intent.putExtra("notification_tit", title);
            intent.putExtra("notification_txt", text);
            sendBroadcast(intent);
        }

        Log.i("Package Name is:", package_name);

    }

    public void onNotificationRemoved(StatusBarNotification sbn) {

    }

}
