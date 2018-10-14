package com.dima.testing_big_dig_b.SwitcherPac.FromHistoryTab;

import android.app.Activity;

import com.dima.testing_big_dig_b.SwitcherPac.FromHistoryTab.HistoryStatus1.HistoryStatusOne;
import com.dima.testing_big_dig_b.SwitcherPac.FromHistoryTab.HistoryStatus2_3.HistoryStatusTwo;
import com.dima.testing_big_dig_b.SwitcherPac.IntentGetter;

public class FromHistory {

    Activity activity;

    public FromHistory(Activity activity) {
        this.activity = activity;
    }

    public void starter(){
        IntentGetter.create(activity);

        if (IntentGetter.getSTATUS().equals("1")){
            HistoryStatusOne historyStatusOne = new HistoryStatusOne(activity,
                    IntentGetter.getID(),IntentGetter.getURL());
            historyStatusOne.starter();
        }
        else if (IntentGetter.getSTATUS().equals("1")){

            HistoryStatusTwo historyStatusTwo = new HistoryStatusTwo(activity,
                    IntentGetter.getID(),IntentGetter.getURL(),IntentGetter.getTIME());
            historyStatusTwo.starter();;
        }
        //Toast.makeText(activity,""+ IntentGetter.getFROM() + IntentGetter.getSTATUS() + IntentGetter.getID(), Toast.LENGTH_LONG).show();
    }
}
