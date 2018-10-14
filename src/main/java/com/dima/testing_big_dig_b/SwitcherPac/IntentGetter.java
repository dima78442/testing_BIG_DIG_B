package com.dima.testing_big_dig_b.SwitcherPac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class IntentGetter {

    private static String FROM = "";
    private static String URL = "";
    private static String TIME = "";
    private static String STATUS = "";
    private static int ID = -1;

    public static void create(Activity activity){

        Intent intent = activity.getIntent();
        Bundle bundle = intent.getBundleExtra("Reference");

        if(bundle!= null){
            FROM = bundle.getString("from");
            URL = bundle.getString("url");
            TIME = bundle.getString("time");
            STATUS = bundle.getString("status");
            if (bundle.getString("id")!=null) {
                ID = Integer.parseInt(bundle.getString("id"));
            }
        }
    }

    public static String getFROM() {
        return FROM;
    }

    public static String getURL() {
        return URL;
    }

    public static String getTIME() {
        return TIME;
    }

    public static String getSTATUS() { return STATUS; }

    public static int getID() { return ID; }
}
