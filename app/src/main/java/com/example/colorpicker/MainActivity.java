package com.example.colorpicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView redValueView;
    private TextView greenValueView;
    private TextView blueValueView;
    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redSeekBar = findViewById(R.id.red_seek_bar);
        greenSeekBar = findViewById(R.id.green_seek_bar);
        blueSeekBar = findViewById(R.id.blue_seek_bar);
        redValueView = findViewById(R.id.red_color_strong);
        greenValueView = findViewById(R.id.green_color_strong);
        blueValueView = findViewById(R.id.blue_color_strong);
        Button button = findViewById(R.id.display_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                showFragmentDialog();
            }
        });

        final SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String redStr;
                String greenStr;
                String blueStr;
                if (seekBar == redSeekBar) {
                    redStr = String.format(Locale.US, "%d", progress);
                    redValueView.setText(redStr);
                } else if (seekBar == greenSeekBar) {
                    greenStr = String.format(Locale.US, "%d", progress);
                    greenValueView.setText(greenStr);
                } else if (seekBar == blueSeekBar) {
                    blueStr = String.format(Locale.US, "%d", progress);
                    blueValueView.setText(blueStr);
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
        TestDialogFragment dialogFragment = TestDialogFragment.newInstance(redSeekBar.getProgress(), greenSeekBar.getProgress(), blueSeekBar.getProgress());
        dialogFragment.show(getSupportFragmentManager(), "dialog_fragment");
    }
}




