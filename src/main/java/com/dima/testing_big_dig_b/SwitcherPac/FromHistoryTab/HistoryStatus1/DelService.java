package com.dima.testing_big_dig_b.SwitcherPac.FromHistoryTab.HistoryStatus1;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

import com.dima.testing_big_dig_b.Room.DbUri;

public class DelService extends Service {

    static private int id;

    public DelService() {
    }

    final String LOG_TAG = "myLogs";

    public void onCreate() {
        super.onCreate();
        //Log.d(LOG_TAG, "onCreate");
    }


    public int onStartCommand(Intent intent, int flags, int startId) {
        //Log.d(LOG_TAG, "onStartCommand");
        if (intent!=null) {
            if (intent.getIntExtra("id",-1)!=-1){
                id = intent.getIntExtra("id",-1);
            }
        }
        task();
        return Service.START_REDELIVER_INTENT;
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    public IBinder onBind(Intent intent) {
        Log.d(LOG_TAG, "onBind");
        return null;
    }

    void task() {
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                //onClickDelete(id);
                DbUri.Delete(getApplicationContext(),id);
                //Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_LONG).show();
                NotificationHelper notificationHelper = new NotificationHelper(getApplicationContext());
                notificationHelper.createNotification("deleted from db","id: " + id);
                Log.d("DEL", "delete, count = " + id);
                stopSelf();
            }
        }.start();
    }

}
