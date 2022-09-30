package com.example.london;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LifestyleDetailsActivity extends AppCompatActivity {

    TextView lifestyleNameTV, lifestyleTextTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifestyle_details);

        lifestyleNameTV = findViewById(R.id.lifestyleNameTextId);
        lifestyleTextTV = findViewById(R.id.lifestyleTextTextId);

        String lifestyleName = getIntent().getStringExtra("keyName");
        String lifestyleText = getIntent().getStringExtra("keyText");

        lifestyleNameTV.setText(lifestyleName);
        lifestyleNameTV.setTextSize(24);
        lifestyleTextTV.setText(lifestyleText);
        lifestyleTextTV.setTextSize(18);
    }
}