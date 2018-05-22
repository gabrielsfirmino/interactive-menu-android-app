package com.example.gabrielsfirmino.interactive_menu_android_app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListActivity extends AppCompatActivity {
    private static final String PREF = "MenuList";
    ArrayAdapter<String> adapter;
    private AlertDialog alert;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        ListView listview = (ListView) findViewById(R.id.lstm);

        SharedPreferences menus_list = getSharedPreferences(PREF, MODE_PRIVATE);
        final Map<String,?> map = menus_list.getAll();
        final Set<String> list = map.keySet();
        final ArrayList<String> array = new ArrayList<String>();

        for (String item : list) {
            array.add(item);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                builder.setTitle(array.get(position));
                builder.setMessage(map.get(array.get(position)).toString());
                alert = builder.create();
                alert.show();
            }
        });

    }
}
