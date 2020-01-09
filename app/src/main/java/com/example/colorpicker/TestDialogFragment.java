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
    private static final String key_red = "KEY_RED";
    private static final String key_green = "KEY_GREEN";
    private static final String key_blue = "KEY_BLUE";

     public static TestDialogFragment newInstance(int red, int green, int blue) {
        TestDialogFragment tdf = new TestDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(key_red, red);
        bundle.putInt(key_green, green);
        bundle.putInt(key_blue, blue);
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
            redInt = bundle.getInt(key_red, 0);
            greenInt =bundle.getInt(key_green,0);
            blueInt = bundle.getInt(key_blue,0);
        }
        Dialog dialog = getDialog();
        TextView fragment = dialog.findViewById(R.id.fragment);
        TextView fragmentRedStr = dialog.findViewById(R.id.leftColorStrong);
        TextView fragmentGreenStr = dialog.findViewById(R.id.middleColorStrong);
        TextView fragmentBlueStr = dialog.findViewById(R.id.rightColorStrong);
        fragment.setBackgroundColor(Color.rgb(redInt, greenInt, blueInt));
        String red = String.valueOf(redInt);
        String green = String.valueOf(greenInt);
        String blue = String.valueOf(blueInt);

        fragmentRedStr.setText(red);
        fragmentGreenStr.setText(green);
        fragmentBlueStr.setText(blue);
    }
}