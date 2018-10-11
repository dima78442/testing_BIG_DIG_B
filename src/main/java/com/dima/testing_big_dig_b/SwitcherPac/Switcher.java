package com.dima.testing_big_dig_b.SwitcherPac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.dima.testing_big_dig_b.SwitcherPac.FromLauncherPack.FromLauncher;

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
                return 1;
            }else {
                return 2;
            }
        }
        return 3;
    }

    public void starter(){
        int rez = analyzer();
        switch (rez){
            case 1:

                break;
            case 2:
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
