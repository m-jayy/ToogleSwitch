package com.example.togglebuttonmine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleSwitchButton toggle;


        toggle = (ToggleSwitchButton) findViewById(R.id.toggle);

        toggle.setOnTriggerListener(new ToggleSwitchButton.OnTriggerListener() {
            @Override
            public void toggledUp() {
                Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void toggledDown() {
                Toast.makeText(getApplicationContext(), "Left", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
