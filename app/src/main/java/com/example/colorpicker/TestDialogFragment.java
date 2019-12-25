package com.example.colorpicker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class TestDialogFragment extends androidx.fragment.app.DialogFragment {
    private final static String redKey = "KEY_RED";
    private final static String greenKey = "KEY_GREEN";
    private final static String blueKey = "KEY_BLUE";


    static TestDialogFragment newInstance(int red, int green, int blue) {
        TestDialogFragment tdf = new TestDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(redKey, red);
        bundle.putInt(greenKey, green);
        bundle.putInt(blueKey, blue);
        tdf.setArguments(bundle);
        return tdf;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final View dialogView;
        dialogView = LayoutInflater.from(activity).inflate(R.layout.dialog_fragment, null);
        builder.setView(dialogView);
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        int redInt = getArguments().getInt(redKey);
        int GreenInt = getArguments().getInt(greenKey);
        int BlueInt = getArguments().getInt(blueKey);
        TextView fragment = getDialog().findViewById(R.id.fragment);
        TextView fragmentRedStr = getDialog().findViewById(R.id.leftColorStrong);
        TextView fragmentGreenStr = getDialog().findViewById(R.id.middleColorStrong);
        TextView fragmentBlueStr = getDialog().findViewById(R.id.rightColorStrong);
        fragment.setBackgroundColor(Color.rgb(redInt, GreenInt, BlueInt));

        if (redInt == 0) {
            fragmentRedStr.setText("0");
        } else {
            fragmentRedStr.setText(MainActivity.redStr);
        }
        if (GreenInt == 0) {
            fragmentGreenStr.setText("0");
        } else {
            fragmentGreenStr.setText(MainActivity.greenStr);
        }
        if (BlueInt == 0) {
            fragmentBlueStr.setText("0");
        } else {
            fragmentBlueStr.setText(MainActivity.blueStr);
        }
    }
}