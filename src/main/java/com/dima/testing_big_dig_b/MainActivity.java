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
    }

    public void verifyPermissions()
    {
        int permissionExternalMemory = ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(permissionExternalMemory != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this,STORAGE_PERMISSIONS,1);
        }
    }

}