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
    private static final String KEY_RED = "KEY_RED";
    private static final String KEY_GREEN = "KEY_GREEN";
    private static final String KEY_BLUE = "KEY_BLUE";

    static TestDialogFragment newInstance(int red, int green, int blue) {
        TestDialogFragment tdf = new TestDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RED, red);
        bundle.putInt(KEY_GREEN, green);
        bundle.putInt(KEY_BLUE, blue);
        tdf.setArguments(bundle);
        return tdf;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View dialogView = LayoutInflater.from(activity).inflate(R.layout.dialog_fragment, null);
        builder.setView(dialogView);
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        int redInt = 0;
        int greenInt = 0;
        int blueInt = 0;
        if (bundle != null) {
            redInt = bundle.getInt(KEY_RED, 0);
            greenInt = bundle.getInt(KEY_GREEN, 0);
            blueInt = bundle.getInt(KEY_BLUE, 0);
        }
        Dialog dialog = getDialog();
        TextView fragment = dialog.findViewById(R.id.fragment);
        TextView fragmentRedStr = dialog.findViewById(R.id.leftValueView);
        TextView fragmentGreenStr = dialog.findViewById(R.id.middleValueView);
        TextView fragmentBlueStr = dialog.findViewById(R.id.rightValueView);
        fragment.setBackgroundColor(Color.rgb(redInt, greenInt, blueInt));
        String red = String.valueOf(redInt);
        String green = String.valueOf(greenInt);
        String blue = String.valueOf(blueInt);

        fragmentRedStr.setText(red);
        fragmentGreenStr.setText(green);
        fragmentBlueStr.setText(blue);
    }
}