package com.dima.testing_big_dig_b.SwitcherPac.FromLauncherPack.AlertD;

import android.app.DialogFragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dima.testing_big_dig_b.R;

public class DialogCountDown extends DialogFragment {

    private TextView text;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         text = (TextView)view.findViewById(R.id.dialog_mes);
         button = (Button)view.findViewById(R.id.button_dialog);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 getActivity().finishAffinity();
             }
         });
         new CountDownTimer(11000, 1000) {

             public void onTick(long millisUntilFinished) {
                 text.setText("not an independent application, will be closed in: " + millisUntilFinished / 1000);
             }
             public void onFinish() {
                 getActivity().finishAffinity();;
             }
         }.start();
    }

}
