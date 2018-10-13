package com.dima.testing_big_dig_b.SwitcherPac.FromHistoryTab.HistoryStatus2_3;

import android.app.Activity;

import com.dima.testing_big_dig_b.Presenter.Presenter;
import com.dima.testing_big_dig_b.Room.Reference;
import com.dima.testing_big_dig_b.SwitcherPac.PicassoDev.PicassoAction;
import com.squareup.picasso.Callback;

public class HistoryStatusTwo {
    private Activity activity;
    private int id;
    private String url;
    private String time;
    private PicassoAction picassoAction;
    Presenter presenter;

    public HistoryStatusTwo(Activity activity, int id, String url, String time) {
        this.activity = activity;
        this.id = id;
        this.url = url;
        this.time = time;
    }

    public void starter(){
        presenter = new Presenter(activity);
        picassoAction = new PicassoAction(activity,url,getCallback(),false);
        picassoAction.start();
    }

    Callback getCallback(){
        return new Callback() {
            @Override
            public void onSuccess() {
                Reference reference = new Reference().newBuilder()
                        .setUrl(url).setId(id).setStatus("1").setTimeAt(time).build();
                presenter.Update(reference,id);
            }

            @Override
            public void onError() {
            }
        };
    }
}
