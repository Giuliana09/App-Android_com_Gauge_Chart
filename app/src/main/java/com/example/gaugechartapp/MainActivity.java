package com.example.gaugechartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private CustomGaugeView gaugeView;
    private Button buttonIncrease;
    private Button buttonDecrease;
    private int currentValue = 50; // Valor inicial
    private final int minValue = 0;
    private final int maxValue = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gaugeView = findViewById(R.id.gaugeView);
        buttonIncrease = findViewById(R.id.buttonIncrease);
        buttonDecrease = findViewById(R.id.buttonDecrease);

        gaugeView.setValue(currentValue);

        // Aumentar valor
        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentValue < maxValue) {
                    currentValue += 5;
                    gaugeView.setValue(currentValue);
                }
            }
        });

        // Diminuir valor
        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentValue > minValue) {
                    currentValue -= 5;
                    gaugeView.setValue(currentValue);
                }
            }
        });
    }
}
