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
import androidx.fragment.app.DialogFragment;

public class TestDialogFragment extends DialogFragment {
    private static final String redIntKey = "redIntKey";
    private static final String greenIntKey = "greenIntKey";
    private static final String blueIntKey = "blueIntKey";
    private static final String redStringKey = "redStringKey";
    private static final String greenStringKey = "greenStringKey";
    private static final String blueStringKey = "blueStringKey";


    static TestDialogFragment newInstance(int red, int green, int blue, String redstr, String greenstr, String bluestr) {
        TestDialogFragment tdf = new TestDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(redIntKey, red);
        bundle.putInt(greenIntKey, green);
        bundle.putInt(blueIntKey, blue);
        bundle.putString(redStringKey, redstr);
        bundle.putString(greenStringKey, greenstr);
        bundle.putString(blueStringKey, bluestr);
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
        int redInt = getArguments().getInt(redIntKey);
        int greenInt = getArguments().getInt(greenIntKey);
        int blueInt = getArguments().getInt(blueIntKey);
        String redString = getArguments().getString(redStringKey);
        String greenString = getArguments().getString(greenStringKey);
        String blueString = getArguments().getString(blueStringKey);
        TextView fragment = getDialog().findViewById(R.id.fragment);
        TextView fragmentRedStr = getDialog().findViewById(R.id.leftColorStrong);
        TextView fragmentGreenStr = getDialog().findViewById(R.id.middleColorStrong);
        TextView fragmentBlueStr = getDialog().findViewById(R.id.rightColorStrong);
        fragment.setBackgroundColor(Color.rgb(redInt, greenInt, blueInt));

        if (redInt == 0) {
            fragmentRedStr.setText("0");
        } else {
            fragmentRedStr.setText(redString);
        }
        if (greenInt == 0) {
            fragmentGreenStr.setText("0");
        } else {
            fragmentGreenStr.setText(greenString);
        }
        if (blueInt == 0) {
            fragmentBlueStr.setText("0");
        } else {
            fragmentBlueStr.setText(blueString);
        }
    }
}