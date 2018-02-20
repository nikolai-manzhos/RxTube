package com.rxtube.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.rxJavaButton).setOnClickListener(it -> startActivity(new Intent(this, RxJavaActivity.class)));
        findViewById(R.id.rxJava2Button).setOnClickListener(it -> startActivity(new Intent(this, RxJava2Activity.class)));
    }
}
