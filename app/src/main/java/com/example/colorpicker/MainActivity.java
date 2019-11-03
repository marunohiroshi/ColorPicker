package com.example.colorpicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public TextView redColorStrong;
    public TextView greenColorStrong;
    public TextView blueColorStrong;
    public static int redProgress;
    public static int greenProgress;
    public static int blueProgress;
    public static String redStr;
    public static String greenStr;
    public static String blueStr;
    public  TextView fragmentRedStr;
    public  TextView fragmentGreenStr;
    public  TextView fragmentBlueStr;
    public  TextView fragment;


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

        final SeekBar redSeekBar = findViewById(R.id.red_seek_bar);
        final SeekBar greenSeekBar = findViewById(R.id.green_seek_bar);
        final SeekBar blueSeekBar = findViewById(R.id.blue_seek_bar);
        fragmentRedStr = findViewById(R.id.leftColorStrong);
        fragmentGreenStr = findViewById(R.id.middleColorStrong);
        fragmentBlueStr = findViewById(R.id.rightColorStrong);
        fragmentRedStr = findViewById(R.id.leftColorStrong);
        fragmentGreenStr = findViewById(R.id.middleColorStrong);
        fragmentBlueStr = findViewById(R.id.rightColorStrong);
        fragment = findViewById(R.id.fragment);
        redColorStrong = findViewById(R.id.red_color_strong);
        greenColorStrong = findViewById(R.id.green_color_strong);
        blueColorStrong = findViewById(R.id.blue_color_strong);
        Button button = findViewById(R.id.display_button);

        //最大値と最小値を設定
        redSeekBar.setMax(255);
        redSeekBar.setProgress(0);
        greenSeekBar.setMax(255);
        greenSeekBar.setProgress(0);
        blueSeekBar.setMax(255);
        blueSeekBar.setProgress(0);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                showFragmentDiaolog(DIALOG_FRAGMENT);
            }
        });


        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar == redSeekBar) {
                    redStr = String.format(Locale.US, "%d", progress);
                    redProgress = progress;
                    redColorStrong.setText(redStr);
                } else if(seekBar == greenSeekBar) {
                    greenStr = String.format(Locale.US, "%d", progress);
                    greenProgress = progress;
                    greenColorStrong.setText(greenStr);
                } else if(seekBar == blueSeekBar){
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


    final int DIALOG_FRAGMENT = 0;
    public void showFragmentDiaolog(int id)
    {
        if (id == DIALOG_FRAGMENT) {
            TestDialogFragment dialogFragment = TestDialogFragment.newInstance();
            dialogFragment.show(getSupportFragmentManager(), "dialog_fragment");
        } else {
            throw new IllegalStateException("Unexpected value: " + id);
        }
    }

    public void onTestDialogOKClick()
    {
        Log.i("MainActivity :", "OK clicked");
    }
}


