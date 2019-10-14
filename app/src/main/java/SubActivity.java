import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.colorpicker.MainActivity;
import com.example.colorpicker.R;

public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_fragment);

        Intent intent = getIntent();
        int data = intent.getIntExtra(MainActivity.EXTRA_DATA, 0);


    }
}