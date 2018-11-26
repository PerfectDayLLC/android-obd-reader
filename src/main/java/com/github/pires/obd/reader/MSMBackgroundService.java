package com.github.pires.obd.reader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


public class MSMBackgroundService extends Service {
    public Context context = this;
    public Handler handler = null;
    public static Runnable runnable = null;
    private static final String TAG = MSMBackgroundService.class.getSimpleName();
    public MSMBackgroundService() {

    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service created!", Toast.LENGTH_LONG).show();

        //Fire the app on service start.
//        Intent i = new Intent(context,MainActivity.class);
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(i);

        //temp timer
        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
                Toast.makeText(context, "Service is still running", Toast.LENGTH_LONG).show();
                Log.i(TAG, "Service is running in thread " + Thread.currentThread().getName());
                handler.postDelayed(runnable, 10000);
            }
        };

        handler.postDelayed(runnable, 15000);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, ":MSM: onStartCommand  Thread Name: "+Thread.currentThread().getName());
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, ":MSM: onBind Thread Name: "+Thread.currentThread().getName());
        return null;
    }


    @Override
    public void onDestroy() {
        /* IF YOU WANT THIS SERVICE KILLED WITH THE APP THEN UNCOMMENT THE FOLLOWING LINE */
        //handler.removeCallbacks(runnable);

        Log.i(TAG, ":MSM: onStartCommand  Thread Name: "+Thread.currentThread().getName());
        Toast.makeText(this, "Service stopped", Toast.LENGTH_LONG).show();
    }

    class AsyncTasks extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
        //todo
    }
}
