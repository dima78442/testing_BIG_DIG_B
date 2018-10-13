package com.dima.testing_big_dig_b;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.dima.testing_big_dig_b.SwitcherPac.Switcher;

public class MainActivity extends AppCompatActivity {
    private static final String[] STORAGE_PERMISSIONS = { Manifest.permission.WRITE_EXTERNAL_STORAGE};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Switcher switcher = new Switcher(this);
        switcher.starter();
        verifyPermissions();

        /*Cursor cursor = getContentResolver().query(DATA_URI, null, null,
                null, null);
        startManagingCursor(cursor);

        String from[] = { "url", "status","time" };
        int to[] = { android.R.id.text1, android.R.id.text2,android.R.id.text2 };
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, cursor, from, to);

        ListView lvContact = (ListView) findViewById(R.id.lvContact);
        lvContact.setAdapter(adapter);*/
    }


    public void verifyPermissions()
    {
        // This will return the current Status
        int permissionExternalMemory = ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(permissionExternalMemory != PackageManager.PERMISSION_GRANTED)
        {
            // If permission not granted then ask for permission real time.
            ActivityCompat.requestPermissions(MainActivity.this,STORAGE_PERMISSIONS,1);
        }
    }
}