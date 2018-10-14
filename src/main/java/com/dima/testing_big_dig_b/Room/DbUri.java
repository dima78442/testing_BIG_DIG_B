package com.dima.testing_big_dig_b.Room;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class DbUri {

    private Activity activity;
    private final String LOG_TAG = "myLogs";

    final Uri DATA_URI = Uri.parse("content://ru.startandroid.providers.AdressBook/contacts");

    final String DATA_URL = "url";
    final String DATA_STATUS = "status";
    final String DATA_TIME = "time";

    public DbUri(Activity activity) {
        this.activity = activity;
    }

    public void onClickInsert(Reference reference) {

        ContentValues cv = new ContentValues();
        cv.put(DATA_URL, reference.getUrl());
        //cv.put(DATA_STATUS, "email 4");
        cv.put(DATA_TIME,reference.getTimeAt());
        cv.put(DATA_STATUS,reference.getStatus());
        Uri newUri = activity.getContentResolver().insert(DATA_URI, cv);
        //Log.d(LOG_TAG, "insert, result Uri : " + newUri.toString());
    }

    public void onClickUpdate(Reference reference,int id) {
        ContentValues cv = new ContentValues();
        cv.put(DATA_URL, reference.getUrl());
        cv.put(DATA_STATUS, reference.getStatus());
        cv.put(DATA_TIME,reference.getTimeAt());
        Uri uri = ContentUris.withAppendedId(DATA_URI, id);
        int cnt = activity.getContentResolver().update(uri, cv, null, null);
        //Log.d(LOG_TAG, "update, count = " + cnt);
    }

    public void onClickDelete(int id) {
        Uri uri = ContentUris.withAppendedId(DATA_URI, id);
        int cnt = activity.getContentResolver().delete(uri, null, null);
        //Log.d(LOG_TAG, "delete, count = " + cnt);
    }

    public Cursor onClickQuery() {

        Uri uri = Uri.parse("content://ru.startandroid.providers.AdressBook/contacts");
        Cursor cursor = null;

        try {
            cursor = activity.getContentResolver().query(uri, null, null, null, null);
        } catch (Exception ex) {
            Log.d(LOG_TAG, "Error: " + ex.getClass() + ", " + ex.getMessage());
        }
        return cursor;
    }

    public static void Delete(Context context,int id) {
        Uri DATA_URI = Uri.parse("content://ru.startandroid.providers.AdressBook/contacts");
        Uri uri = ContentUris.withAppendedId(DATA_URI, id);
        int cnt = context.getContentResolver().delete(uri, null, null);
        //Log.d("DEL", "delete, count = " + cnt);
    }
}
