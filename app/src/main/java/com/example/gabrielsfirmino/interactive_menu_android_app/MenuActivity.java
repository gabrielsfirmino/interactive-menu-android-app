package com.example.gabrielsfirmino.interactive_menu_android_app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MenuActivity extends AppCompatActivity {
    private static final String PREF = "MenuList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        scan();
    }

    public void scan() {
        final Activity scanActivity = this;

        IntentIntegrator integrator = new IntentIntegrator(scanActivity);

        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setCameraId(0);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() != null) {
                printMenu(result.getContents());
            }
        }
        else {
            Toast.makeText(this, R.string.menu_invalid, Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    public void printMenu(String menu) {
        TextView menuList = (TextView) findViewById(R.id.menuList);

        String[] linhas = menu.split("\\r\\n|\\r|\\n", -1);

        menuList.setText(menu);
    }

    public void selectRadio(View v) {
        SharedPreferences menus_list = getSharedPreferences(PREF, MODE_PRIVATE);

        RadioButton rdy = (RadioButton) findViewById(R.id.rdy);
        RadioButton rdn = (RadioButton) findViewById(R.id.rdn);
        TextView menuList = (TextView) findViewById(R.id.menuList);

        Intent i = new Intent(this, MainActivity.class);

        String[] linhas = menuList.getText().toString().split("\\r\\n|\\r|\\n", -1);

        if (rdy.isChecked()) {
            SharedPreferences.Editor edit = menus_list.edit();
            edit.putString(linhas[0], menuList.getText().toString());
            edit.commit();
            Toast.makeText(this, R.string.menu_saved, Toast.LENGTH_SHORT).show();
            startActivity(i);
            finish();
        }

        if (rdn.isChecked()) {
            Toast.makeText(this, R.string.menu_nsaved, Toast.LENGTH_SHORT).show();
            startActivity(i);
            finish();
        }
    }
}
