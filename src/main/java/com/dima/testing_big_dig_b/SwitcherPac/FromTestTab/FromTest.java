package com.dima.testing_big_dig_b.SwitcherPac.FromTestTab;

import android.app.Activity;

import com.dima.testing_big_dig_b.Presenter.Presenter;
import com.dima.testing_big_dig_b.Room.Reference;
import com.dima.testing_big_dig_b.SwitcherPac.IntentGetter;
import com.dima.testing_big_dig_b.SwitcherPac.PicassoDev.PicassoAction;
import com.squareup.picasso.Callback;

public class FromTest {

    private Activity activity;
    private String url;
    //private ImageView imageView;
    private Presenter presenter;

    public FromTest(Activity activity, String url) {
        this.activity = activity;
        this.url = url;
    }

    public void starter(){
        presenter = new Presenter(activity);
        PicassoAction picassoAction = new PicassoAction(activity,url,getCallback(),false);
        picassoAction.start();
    }

    private Callback getCallback(){
        return new Callback() {
            @Override
            public void onSuccess() {
                IntentGetter.create(activity);
                Reference reference = new Reference().newBuilder().setUrl(url)
                        .setStatus("1").setTimeAt(IntentGetter.getTIME()).build();
                presenter.Insert(reference);

            }

            @Override
            public void onError() {
                IntentGetter.create(activity);
                Reference reference = new Reference().newBuilder().setUrl(url)
                        .setStatus("2").setTimeAt(IntentGetter.getTIME()).build();
                presenter.Insert(reference);
            }
        };
    }



}
