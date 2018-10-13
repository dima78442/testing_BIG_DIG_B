package com.dima.testing_big_dig_b.SwitcherPac.FromLauncherPack;

import android.app.Activity;
import android.app.FragmentManager;

import com.dima.testing_big_dig_b.SwitcherPac.FromLauncherPack.AlertD.DialogCountDown;

public class FromLauncher {
    private Activity activity;
    public FromLauncher(Activity activity) {
        this.activity = activity;
    }

    public void starter (){
        FragmentManager fm = activity.getFragmentManager();
        DialogCountDown dialogFragment = new DialogCountDown ();
        dialogFragment.show(fm, "Fragment");
    }
}


