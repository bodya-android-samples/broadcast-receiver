package ru.popov.bodya.callsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @author Bogdan Popov
 */
public class MyPhoneReceiver extends BroadcastReceiver {

    private static final String TAG = MyPhoneReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.e(TAG, "state: " + state);
            if (state != null && state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.e(TAG, "phone number: " + phoneNumber);
            }
        }
    }
}
