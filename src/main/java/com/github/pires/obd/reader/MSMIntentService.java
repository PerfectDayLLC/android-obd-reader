package com.github.pires.obd.reader;


import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MSMIntentService extends IntentService {

    private static final String TAG = MSMIntentService.class.getSimpleName();

    public MSMIntentService(String name) {
        super("MSMBackgroundThread");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "onHandleIntent thread: " + Thread.currentThread().getName());
        //do things here
        Intent localIntent = new Intent("msm.local.broadcast");
        localIntent.putExtra("results", "things");
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate thread " + Thread.currentThread().getName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy thread " + Thread.currentThread().getName());
    }
}
