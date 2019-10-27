package com.example.colorpicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public TextView redColorStrong;
    TextView greenColorStrong;
    TextView blueColorStrong;

    public static int redProgress;
    public static int greenProgress;
    public static int blueProgress;
    public static String redStr;
    public static String greenStr;
    public static String blueStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("注意");
        alert.setMessage("今からカラーピッカーアプリを起動しますか？");
        alert.setPositiveButton("OK", null);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //Yesボタンが押された時の処理
                Toast.makeText(MainActivity.this, "カラーピッカーを始めます。", Toast.LENGTH_LONG).show();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //Noボタンが押された時の処理
                Toast.makeText(MainActivity.this, "問答無用でカラーピッカーを始めます。", Toast.LENGTH_LONG).show();
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
        Button button = findViewById(R.id.display_button);


        button.setOnClickListener(buttonClick);

        redSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        redStr = String.format(Locale.US, "%d", progress);
                        redProgress = progress;
                        redColorStrong.setText(redStr);
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
                        greenStr = String.format(Locale.US, "%d", progress);
                        greenProgress = progress;
                        greenColorStrong.setText(greenStr);
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
                        blueStr = String.format(Locale.US, "%d", progress);
                        blueProgress = progress;
                        blueColorStrong.setText(blueStr);
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

    }

    public OnClickListener buttonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("debug", "button, Perform action on click");
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            startActivity(intent);
        }
    };
}


