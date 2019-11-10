package com.example.colorpicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView redColorStrong;
    private TextView greenColorStrong;
    private TextView blueColorStrong;
    public static int redProgress;
    public static int greenProgress;
    public static int blueProgress;
    public static String redStr;
    public static String greenStr;
    public static String blueStr;
    public TextView fragmentRedStr;
    public TextView fragmentGreenStr;
    public TextView fragmentBlueStr;
    public TextView fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar redSeekBar = findViewById(R.id.red_seek_bar);
        final SeekBar greenSeekBar = findViewById(R.id.green_seek_bar);
        final SeekBar blueSeekBar = findViewById(R.id.blue_seek_bar);
        fragmentRedStr = findViewById(R.id.leftColorStrong);
        fragmentGreenStr = findViewById(R.id.middleColorStrong);
        fragmentBlueStr = findViewById(R.id.rightColorStrong);
        fragment = findViewById(R.id.fragment);
        redColorStrong = findViewById(R.id.red_color_strong);
        greenColorStrong = findViewById(R.id.green_color_strong);
        blueColorStrong = findViewById(R.id.blue_color_strong);
        Button button = findViewById(R.id.display_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                showFragmentDialog();
            }
        });

        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar == redSeekBar) {
                    redStr = String.format(Locale.US, "%d", progress);
                    redProgress = progress;
                    redColorStrong.setText(redStr);
                } else if (seekBar == greenSeekBar) {
                    greenStr = String.format(Locale.US, "%d", progress);
                    greenProgress = progress;
                    greenColorStrong.setText(greenStr);
                } else if (seekBar == blueSeekBar) {
                    blueStr = String.format(Locale.US, "%d", progress);
                    blueProgress = progress;
                    blueColorStrong.setText(blueStr);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        };
        redSeekBar.setOnSeekBarChangeListener(listener);
        blueSeekBar.setOnSeekBarChangeListener(listener);
        greenSeekBar.setOnSeekBarChangeListener(listener);
    }

    private void showFragmentDialog() {
        TestDialogFragment dialogFragment = TestDialogFragment.newInstance();
        dialogFragment.show(getSupportFragmentManager(), "dialog_fragment");
    }
}




