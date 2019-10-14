package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity  {

    TextView redColorStrong;
    TextView greenColorStrong;
    TextView blueColorStrong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar redSeekBar = findViewById(R.id.red_seek_bar);
        SeekBar greenSeekBar = findViewById(R.id.green_seek_bar);
        SeekBar blueSeekBar = findViewById(R.id.blue_seek_bar);
        final ImageView imageView = findViewById(R.id.imageView);

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

        View display_button = findViewById(R.id.display_button);
        display_button.setOnClickListener(display_button_onClickListener);

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

        greenSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String bluestr = String.format(Locale.US, "%d", progress);
                        greenColorStrong.setText(bluestr);
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

        public void paint (Graphics g){
            Color color = new Color(redstr, greenstr, bluestr )
                    g.setColor(color);
        }

        imageView.setTextColor(Color.rgb(redstr,  greenstr,  bluestr));

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.display_button:
                    Log.d("My Test", "Clicked!");
            }
        }
    }


        View.OnClickListener display_button_onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //色表示ボタンが押されたときの挙動
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("EXTRA_DATA",  imageView.getText().toString());//渡すデータの名前と値を入れる
                startActivity(intent);
            }
        };

    }

