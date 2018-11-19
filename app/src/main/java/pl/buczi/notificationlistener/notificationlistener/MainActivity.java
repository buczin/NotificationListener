package pl.buczi.notificationlistener.notificationlistener;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private NotificationReceiver nReceiver;
    TextView notification_title;
    TextView notification_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification_title = findViewById(R.id.notification_title);
        notification_text = findViewById(R.id.notification_text);

        nReceiver = new NotificationReceiver();
       // IntentFilter filter = new IntentFilter();
        //filter.addAction("pl.buczak.zegarek.notificationlistener");
        //registerReceiver(nReceiver, filter);
    }

    class NotificationReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            notification_title.setText(intent.getStringExtra("notification_tit"));
            notification_text.setText(intent.getStringExtra("notification_txt"));
        }
    }

}