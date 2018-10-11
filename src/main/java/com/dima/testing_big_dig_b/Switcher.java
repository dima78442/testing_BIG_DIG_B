package com.dima.testing_big_dig_b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Switcher {

    public static int Switcher(Activity activity){
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
}
