package com.example.gabrielsfirmino.interactive_menu_android_app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ListActivity extends AppCompatActivity {
    private static final String PREF = "MenuList";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        SharedPreferences menus_list = getSharedPreferences(PREF, MODE_PRIVATE);
        Map<String,?> map = menus_list.getAll();
        List<Sampler.Value> list_value = new ArrayList<Sampler.Value>((Collection<? extends Sampler.Value>) map.values());
    }
}
