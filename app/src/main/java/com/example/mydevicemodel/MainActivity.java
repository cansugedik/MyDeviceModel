package com.example.mydevicemodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt_model, txt_soltus, txt_sagtus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        InitControls();

        InitControlEvents();
    }

    private void InitControls() {
        txt_model = findViewById(R.id.txt_model);
        txt_soltus = findViewById(R.id.txt_soltus);
        txt_sagtus = findViewById(R.id.txt_sagtus);
    }

    private void InitControlEvents() {

        txt_model.setText(getDeviceName());

        txt_model.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                Toast.makeText(MainActivity.this,String.valueOf(event.getScanCode()),Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        txt_soltus.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                txt_soltus.setText(String.valueOf(event.getScanCode()));

                return false;
            }
        });

        txt_sagtus.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                txt_sagtus.setText(String.valueOf(event.getScanCode()));

                return false;
            }
        });

        System.out.println(getDeviceName());
    }

    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;

        return manufacturer + " " + model;
    }

}
