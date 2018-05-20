package com.example.gabrielsfirmino.interactive_menu_android_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToScan(View view) {
        Intent i = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(i);
    }

    public void goToMenu(View view) {

    }
}
