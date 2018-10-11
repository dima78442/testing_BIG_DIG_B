package com.dima.testing_big_dig_b;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

    final String LOG_TAG = "myLogs";

    final Uri DATA_URI = Uri
            .parse("content://ru.startandroid.providers.AdressBook/contacts");

    final String DATA_URL = "url";
    final String DATA_STATUS = "status";
    final String DATA_TIME = "time";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int res1 = Switcher.Switcher(this);
        Toast.makeText(this,res1+"",Toast.LENGTH_LONG).show();
        Cursor cursor = getContentResolver().query(DATA_URI, null, null,
                null, null);
        startManagingCursor(cursor);

        String from[] = { "url", "status","time" };
        int to[] = { android.R.id.text1, android.R.id.text2,android.R.id.text2 };
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, cursor, from, to);

        ListView lvContact = (ListView) findViewById(R.id.lvContact);
        lvContact.setAdapter(adapter);
    }

    public void onClickInsert(View v) {

        ContentValues cv = new ContentValues();
        cv.put(DATA_URL, "name 4");
        cv.put(DATA_STATUS, "email 4");
        cv.put(DATA_TIME,"time 4");
        Uri newUri = getContentResolver().insert(DATA_URI, cv);
        Log.d(LOG_TAG, "insert, result Uri : " + newUri.toString());
    }

    public void onClickUpdate(View v) {
        ContentValues cv = new ContentValues();
        cv.put(DATA_URL, "name 5");
        cv.put(DATA_STATUS, "email 5");
        cv.put(DATA_TIME,"time 5");
        Uri uri = ContentUris.withAppendedId(DATA_URI, 2);
        int cnt = getContentResolver().update(uri, cv, null, null);
        Log.d(LOG_TAG, "update, count = " + cnt);
    }

    public void onClickDelete(View v) {
        Uri uri = ContentUris.withAppendedId(DATA_URI, 0);
        int cnt = getContentResolver().delete(uri, null, null);
        Log.d(LOG_TAG, "delete, count = " + cnt);
    }

    public void onClickError(View v) {
        Uri uri = Uri.parse("content://ru.startandroid.providers.AdressBook/contacts");
        try {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);

        } catch (Exception ex) {
            Log.d(LOG_TAG, "Error: " + ex.getClass() + ", " + ex.getMessage());
        }

    }
}