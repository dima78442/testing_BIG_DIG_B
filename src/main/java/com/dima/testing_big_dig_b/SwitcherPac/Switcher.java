package com.dima.testing_big_dig_b.SwitcherPac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.dima.testing_big_dig_b.SwitcherPac.FromHistoryTab.FromHistory;
import com.dima.testing_big_dig_b.SwitcherPac.FromLauncherPack.FromLauncher;
import com.dima.testing_big_dig_b.SwitcherPac.FromTestTab.FromTest;

public class Switcher {
    private Activity activity;

    public Switcher(Activity activity) {
        this.activity = activity;
    }

    private int analyzer(){
        Intent intent = activity.getIntent();
        Bundle bundle= intent.getBundleExtra("Reference");
        if(bundle != null){
            String from = bundle.getString("from");
            if(from.equals("test")){
                //Log.d("here","test" + bundle.get("url"));
                return 1;
            }else if(from.equals("history")){
                //Toast.makeText(activity,"here"+"history",Toast.LENGTH_LONG).show();
                return 2;
            }
        }
        return 3;
    }

    public void starter(){
        int rez = analyzer();
        switch (rez){
            case 1:
                IntentGetter.create(activity);
                FromTest fromTest = new FromTest(activity,IntentGetter.getURL());
                fromTest.starter();
                break;
            case 2:
                //Log.d("here","here");
                FromHistory fromHistory = new FromHistory(activity);
                fromHistory.starter();
                break;
            case 3:
                FromLauncher fromLauncher = new FromLauncher(activity);
                fromLauncher.starter();
                break;
            default:
                break;
        }
    }
}
