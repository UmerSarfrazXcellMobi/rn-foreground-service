package com.supersami.foregroundservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("NotificationReceiver", "Broadcast received with action: " + intent.getAction());
        if (intent.getAction() != null) {
            switch (intent.getAction()) {
                case "com.remimb.ACTION_BUTTON_CLICK":
                    String buttonAction = intent.getStringExtra("buttonOnPress");
                    Log.d("NotificationReceiver", "Button Clicked: " + buttonAction);

                    if( ForegroundService.getInstance() != null){
                        ForegroundService.getInstance().emitNotificationClickedButtonText(buttonAction);
                    }
                    break;
                case "com.remimb.ACTION_BUTTON2_CLICK":
                    String button2Action = intent.getStringExtra("button2OnPress");
                    Log.d("NotificationReceiver", "Button 2 Clicked: " + button2Action);
                    break;
            }
        }
    }
}