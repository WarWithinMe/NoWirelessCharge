package com.wwm.nowirelesscharge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

//        Log.i("NoWireless", "BootReceiver");

        BYDWirelessCharger.turnOff(context);

//        Log.i("NoWireless", intent.getAction());

//        Toast.makeText(context, "BootReceiver", Toast.LENGTH_LONG).show();

//        Intent i = new Intent(context, MainActivity.class);
//        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(i);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            context.startForegroundService(new Intent(context, AutoStartService.class));
//        } else {
//            context.startService(new Intent(context, AutoStartService.class));
//        }
    }
}
