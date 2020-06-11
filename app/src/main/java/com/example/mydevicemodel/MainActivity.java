package com.example.mydevicemodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtModel, txtSoltus, txtSagtus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initControls();

        initControlEvents();
    }

    private void initControls() {
        txtModel = findViewById(R.id.txtModel);
        txtSoltus = findViewById(R.id.txtSoltus);
        txtSagtus = findViewById(R.id.txtSagtus);
    }

    private void initControlEvents() {

        txtModel.setText(getDeviceName());

        txtModel.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                Toast.makeText(MainActivity.this,String.valueOf(event.getScanCode()),Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        txtSoltus.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                txtSoltus.setText(String.valueOf(event.getScanCode()));

                return false;
            }
        });

        txtSagtus.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                txtSagtus.setText(String.valueOf(event.getScanCode()));

                return false;
            }
        });

        System.out.println(getDeviceName());
    }

    public String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;

        String myString = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            myString = String.join(manufacturer, model);
        }

        return myString;
    }

}
