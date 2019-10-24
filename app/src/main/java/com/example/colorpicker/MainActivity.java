package com.example.colorpicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Locale;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    TextView redColorStrong;
    TextView greenColorStrong;
    TextView blueColorStrong;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Title");
        alert.setMessage("Message");
        alert.setPositiveButton("OK", null);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //Yesボタンが押された時の処理
                Toast.makeText(MainActivity.this, "Yes Clicked!", Toast.LENGTH_LONG).show();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //Noボタンが押された時の処理
                Toast.makeText(MainActivity.this, "No Clicked!", Toast.LENGTH_LONG).show();
            }
        });
        alert.show();

        SeekBar redSeekBar = findViewById(R.id.red_seek_bar);
        SeekBar greenSeekBar = findViewById(R.id.green_seek_bar);
        SeekBar blueSeekBar = findViewById(R.id.blue_seek_bar);

        //最大値と最小値を設定
        redSeekBar.setMax(255);
        redSeekBar.setProgress(0);
        greenSeekBar.setMax(255);
        greenSeekBar.setProgress(0);
        blueSeekBar.setMax(255);
        blueSeekBar.setProgress(0);

        redColorStrong = findViewById(R.id.red_color_strong);
        greenColorStrong = findViewById(R.id.green_color_strong);
        blueColorStrong = findViewById(R.id.blue_color_strong);
        imageView = findViewById(R.id.imageView);
        Button button = findViewById(R.id.display_button);

        button.setOnClickListener(buttonClick);

        redSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String redstr = String.format(Locale.US, "%d", progress);
                        redColorStrong.setText(redstr);
                    }

                    //つまみがタッチされたときに呼ばれるメソッド
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    //つまみがリリースされたときに呼ばれるメソッド
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        greenSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String redstr = String.format(Locale.US, "%d", progress);
                        greenColorStrong.setText(redstr);
                    }

                    //つまみがタッチされたときに呼ばれるメソッド
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    //つまみがリリースされたときに呼ばれるメソッド
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        blueSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String greenstr = String.format(Locale.US, "%d", progress);
                        blueColorStrong.setText(greenstr);
                    }

                    //つまみがタッチされたときに呼ばれるメソッド
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    //つまみがリリースされたときに呼ばれるメソッド
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        button.setBackgroundColor(Color.rgb(100, 100, 100));

//        View.OnClickListener display_button_onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        };
    }

    public OnClickListener buttonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("debug", "button, Perform action on click");

        }
    };

    private void setScreenSub() {
        setContentView(R.layout.dialog_fragment);
    }
}


