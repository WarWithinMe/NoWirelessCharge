package com.wwm.nowirelesscharge;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AutoStartService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

        startForeground(1, new Notification());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

//        Log.i("NoWireless", "Service");
//
//        Toast.makeText(this, "Service", Toast.LENGTH_LONG).show();

        BYDWirelessCharger.turnOff(this);
        stopSelf();

        return START_NOT_STICKY;
    }

//    @Override
//    public void onDestroy() {
//        LocalBroadcastManager
//                .getInstance(this)
//                .sendBroadcast(new Intent(MainActivity.IntentServiceStopped));
//        super.onDestroy();
//    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
