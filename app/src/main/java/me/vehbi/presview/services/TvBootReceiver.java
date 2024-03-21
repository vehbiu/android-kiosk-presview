package me.vehbi.presview.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import me.vehbi.presview.TvActivity;

public class TvBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(!Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            System.out.println("Boot completed, but not launching TvActivity");
            return;
        }
        System.out.println("Boot completed, launching TvActivity");
        Intent newIntent = new Intent(context, TvActivity.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(newIntent);
    }
}
