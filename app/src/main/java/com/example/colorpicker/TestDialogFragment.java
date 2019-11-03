package com.example.colorpicker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import static com.example.colorpicker.MainActivity.blueProgress;
import static com.example.colorpicker.MainActivity.greenProgress;
import static com.example.colorpicker.MainActivity.redProgress;

public class TestDialogFragment extends androidx.fragment.app.DialogFragment {

    static TestDialogFragment newInstance()
    {
        return new TestDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        final Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final View dialogView = LayoutInflater.from(activity).inflate(R.layout.dialog_fragment, null);
        builder
                .setView(dialogView)
                .setTitle("Fragment Dialog")
                .setPositiveButton("元の画面に戻る", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        assert activity != null;
                        ((MainActivity)activity).onTestDialogOKClick();
                    }
                });
        return builder.create();
    }

    @Override
    public void onStart(){
        super.onStart();
        TextView fragment = getDialog().findViewById(R.id.fragment);
        TextView fragmentRedStr = getDialog().findViewById(R.id.leftColorStrong);
        TextView fragmentGreenStr = getDialog().findViewById(R.id.middleColorStrong);
        TextView fragmentBlueStr = getDialog().findViewById(R.id.rightColorStrong);
        fragment.setBackgroundColor(Color.rgb(MainActivity.redProgress, greenProgress, blueProgress));
        if (redProgress == 0){
            fragmentRedStr.setText("0");
        }else {
            fragmentRedStr.setText(MainActivity.redStr);
        }
        if (greenProgress == 0){
            fragmentGreenStr.setText("0");
        }else {
            fragmentGreenStr.setText(MainActivity.greenStr);
        }
        if (blueProgress == 0){
            fragmentBlueStr.setText("0");
        }else {
            fragmentBlueStr.setText(MainActivity.blueStr);
        }
    }
}
