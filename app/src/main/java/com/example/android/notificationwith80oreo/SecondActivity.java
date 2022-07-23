package com.example.android.notificationwith80oreo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "myTag";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
         textView = findViewById(R.id.textView1);
        if (getIntent().hasExtra(MainActivity.MESSAGE_KEY)){
            String s = getIntent().getStringExtra(MainActivity.MESSAGE_KEY);
            textView.setText(s);
            Log.d(TAG, "onCreate: "+s);
        }
    }
}