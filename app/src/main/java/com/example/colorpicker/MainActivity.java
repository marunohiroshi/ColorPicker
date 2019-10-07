package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

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

        //最大値と最小値を設定
        redSeekBar.setMax(255);
        redSeekBar.setProgress(0);
        greenSeekBar.setMax(255);
        greenSeekBar.setProgress(0);
        blueSeekBar.setMax(255);
        blueSeekBar.setProgress(0);

        redColorStrong = findViewById(R.id.red_color_strong);
        Button button = findViewById(R.id.display_button);
        button.setOnClickListener(display_button_onClickListener);//warningが出る原因がよくわからない

        //redSeekbarだけうまく動く原因が分からない
        redSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        String str = String.format(Locale.US, "%d", progress);
                        redColorStrong.setText(str);
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
                        String str = String.format(Locale.US, "%d", progress);
                        blueColorStrong.setText(str);
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
                        String str = String.format(Locale.US, "%d", progress);
                        greenColorStrong.setText(str);
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
            Color color = new Color(str, str, str )
                    g.setColor(color);
        }



        View.OnClickListener display_button_onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //色表示ボタンが押されたときの挙動
                
            }
        };

    }

}

