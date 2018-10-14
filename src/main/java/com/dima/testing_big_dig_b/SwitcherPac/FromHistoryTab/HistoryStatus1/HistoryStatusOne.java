package com.dima.testing_big_dig_b.SwitcherPac.FromHistoryTab.HistoryStatus1;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.dima.testing_big_dig_b.Presenter.Presenter;
import com.dima.testing_big_dig_b.SwitcherPac.PicassoDev.PicassoAction;
import com.squareup.picasso.Callback;

public class HistoryStatusOne {

    private Activity activity;
    static public int id;
    private String url;
    private PicassoAction picassoAction;
    Presenter presenter;

    public HistoryStatusOne(Activity activity, int id, String url) {
        this.activity = activity;
        this.id = id;
        this.url = url;
    }

    public void starter(){
        presenter = new Presenter(activity);
        picassoAction = new PicassoAction(activity,url,getCallback(),true);
        picassoAction.start();
    }

    Callback getCallback(){
        return new Callback() {
            @Override
            public void onSuccess() {
                //presenter.Deleate(id);
                Intent startIntent = new Intent(activity.getApplicationContext(), DelService.class);
                Log.d("DEL",id +"");
                startIntent.putExtra("id",id);
                activity.startService(startIntent);
            }

            @Override
            public void onError() {
                presenter.Deleate(id);
            }
        };
    }

}
