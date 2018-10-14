package com.dima.testing_big_dig_b.Presenter;

import android.app.Activity;
import android.database.Cursor;

import com.dima.testing_big_dig_b.Room.DbUri;
import com.dima.testing_big_dig_b.Room.Reference;

public class Presenter {

    private Activity activity;
    private DbUri dbUri;

    public Presenter(Activity activity) {
        this.activity = activity;
        dbUri = new DbUri(activity);
    }
    public void Insert(Reference reference){
        dbUri.onClickInsert(reference);
    }
    public void Update(Reference reference, int id){
        dbUri.onClickUpdate(reference,id);
    }
    public void Deleate(int id){
        dbUri.onClickDelete(id);
    }
    public Cursor Query(){
        return dbUri.onClickQuery();
    }

}
