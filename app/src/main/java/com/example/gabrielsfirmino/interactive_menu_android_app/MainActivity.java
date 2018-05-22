package com.example.gabrielsfirmino.interactive_menu_android_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String PREF = "MenuList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences menus_list = getSharedPreferences(PREF, MODE_PRIVATE);

        RadioButton pt = (RadioButton) findViewById(R.id.rdgroupptbr);
        RadioButton us = (RadioButton) findViewById(R.id.rdgroupus);

        if (pt.getText().toString().equals("Portuguese - Brazil")) {
            us.setChecked(true);
        }
        else {
            pt.setChecked(true);
        }

    }

    public void goToScan(View view) {
        Intent i = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(i);
    }

    public void goToMenus(View view) {
        Intent i = new Intent(MainActivity.this, ListActivity.class);
        startActivity(i);
    }
}
