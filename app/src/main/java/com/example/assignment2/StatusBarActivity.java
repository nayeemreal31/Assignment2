package com.example.assignment2;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StatusBarActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private Switch switchadaptive,switchlow,switchhigh;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_status_bar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        seekBar = findViewById(R.id.seekBar);
        switchadaptive = findViewById(R.id.btn_switchadaptive);
        switchlow=findViewById(R.id.btn_switchlow);
        switchhigh=findViewById(R.id.btn_switchhigh);
        textView = findViewById(R.id.value);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("Volume: " + progress + " / " + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        switchadaptive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Turn off the low switch
                    switchlow.setChecked(false);
                    // Turn off the high switch
                    switchhigh.setChecked(false);

                    seekBar.setProgress(50);
                    textView.setText("Volume: " + 50 + " / " + seekBar.getMax());
                } else {
                    seekBar.setProgress(60);
                    textView.setText("Volume: " + 60 + " / " + seekBar.getMax());
                }
            }
        });

        switchlow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Turn off the adaptive switch
                    switchadaptive.setChecked(false);
                    //Turn off the high switch
                    switchhigh.setChecked(false);

                    seekBar.setProgress(30);
                    textView.setText("Volume: " + 30 + " / " + seekBar.getMax());
                } else {
                    seekBar.setProgress(60);
                    textView.setText("Volume: " + 60 + " / " + seekBar.getMax());
                }
            }
        });




        switchhigh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Turn off the adaptive switch
                    switchadaptive.setChecked(false);
                    //Turn off the low switch
                    switchlow.setChecked(false);


                    seekBar.setProgress(90);
                    textView.setText("Volume: " + 90 + " / " + seekBar.getMax());
                } else {
                    seekBar.setProgress(60);
                    textView.setText("Volume: " + 60 + " / " + seekBar.getMax());
                }
            }
        });

    }
}