package edu.gatech.gtri.notificationtray;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private NotificationManager nMN;

    private final static int HOME_ID = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.showNotification();
        finish();

    }

    private void showNotification() {
        //Intent resultIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.chromecast.app");
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent homePendingIntent = PendingIntent.getActivity(this, 0, homeIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // TODO Auto-generated method stub
        nMN = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // TODO Auto-generated method stub
        Notification m  = new Notification.Builder(this)
                .setContentTitle("Home Screen")
                .setContentText("Launch")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setOngoing(true)
                .setContentIntent(homePendingIntent)
                .build();
        nMN.notify(HOME_ID, m);
    }
}
