package com.dima.testing_big_dig_b.SwitcherPac.PicassoDev;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import com.dima.testing_big_dig_b.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PicassoAction {

    private String url;
    private Activity activity;
    private ImageView imageView;
    private Callback callback;
    private boolean flag;

    public PicassoAction(Activity activity,String url, Callback callback,boolean flag) {
        this.activity = activity;
        this.url = url;
        this.imageView = (ImageView)activity.findViewById(R.id.imageView);
        this.callback = callback;
        this.flag = flag;
    }

    public void start(){
        imageDownload();
    }
    private void imageDownload(){
        if (flag) {
            Picasso.with(activity)
                    .load(url)
                    .into(getTarget());
        }
        Picasso.with(activity).load(url).into(imageView, callback);

    }

    //target to save
    private Target getTarget(){
        Target target = new Target(){

            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        File path = new File(Environment.getExternalStorageDirectory(),
                                "/BIGDIG/test/B");
                        path.mkdirs();
                        File file = new File(Environment.getExternalStorageDirectory()
                                +"/BIGDIG/test/B/2.jpg");
                        Log.d("picc", Environment.getExternalStorageDirectory().getAbsolutePath());
                        try {
                            file.createNewFile();
                            FileOutputStream ostream = new FileOutputStream(file);
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, ostream);
                            ostream.flush();
                            ostream.close();
                        } catch (IOException e) {
                            Log.e("IOException", e.getLocalizedMessage());
                        }
                    }
                }).start();

            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        return target;
    }

}
