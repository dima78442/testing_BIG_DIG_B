package com.dima.testing_big_dig_b.SwitcherPac.FromHistoryTab.HistoryStatus1;

import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

import com.dima.testing_big_dig_b.Presenter.Presenter;

public class DelService extends Service {
    static private int id;
    private Presenter presenter;

    public DelService() {
    }

    final String LOG_TAG = "myLogs";

    public void onCreate() {
        super.onCreate();

        Log.d(LOG_TAG, "onCreate");
    }


    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "onStartCommand");
       // presenter = new Presenter(getApplicationContext());
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
                onClickDelete(id);
                //Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_LONG).show();
                NotificationHelper notificationHelper = new NotificationHelper(getApplicationContext());
                notificationHelper.createNotification("deleted from db","id: " + id);
                Log.d("DEL", "delete, count = " + id);
                stopSelf();
            }
        }.start();
    }

    final Uri DATA_URI = Uri
            .parse("content://ru.startandroid.providers.AdressBook/contacts");
    public void onClickDelete(int id) {
        Uri uri = ContentUris.withAppendedId(DATA_URI, id);
        int cnt = getApplicationContext().getContentResolver().delete(uri, null, null);
        Log.d(LOG_TAG, "delete, count = " + cnt);
    }

}
