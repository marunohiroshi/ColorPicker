package com.example.colorpicker;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.colorpicker.MainActivity.blueProgress;
import static com.example.colorpicker.MainActivity.greenProgress;

public class SubActivity extends Activity {

    TextView fragment;
    TextView fragmentRedStr;
    TextView fragmentGreenStr;
    TextView fragmentBlueStr;

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.dialog_fragment);
        fragmentRedStr = findViewById(R.id.leftColorStrong);
        fragmentGreenStr = findViewById(R.id.middleColorStrong);
        fragmentBlueStr = findViewById(R.id.rightColorStrong);

        fragment = findViewById(R.id.fragment);

        fragment.setBackgroundColor(Color.rgb(MainActivity.redProgress, greenProgress, blueProgress));
        fragmentRedStr.setText(MainActivity.redStr);
        fragmentGreenStr.setText(MainActivity.greenStr);
        fragmentBlueStr.setText(MainActivity.blueStr);

        Button button = findViewById(R.id.Return);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}