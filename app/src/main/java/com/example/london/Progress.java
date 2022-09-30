package com.example.london;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class Progress extends AppCompatActivity
{
    private int progress = 0;

    private ProgressBar progressBar;
    private TextView textViewProgress;
    private SwitchMaterial themeSwitch;
    private TextView themeTV, titleTV;

    private UserSettings settings;
    private View p;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);

        progressBar = findViewById(R.id.progress_bar);
        textViewProgress = findViewById(R.id.text_view_progress);

        progressBar.setProgress(0);
        textViewProgress.setText("0 Days");

    }

    public void onClickUp(View view)
    {
        if (progress <= 99)
        {
            progress += 1;
            updateProgressBar();
        }
    }

    public void onClickLow(View view)
    {
        if (progress >= 1)
        {
            progress -= 1;
            updateProgressBar();
        }
    }

    private void updateProgressBar()
    {
        progressBar.setProgress(progress);
        textViewProgress.setText(progress + "Days");
    }
    private void initWidgets()
    {
        themeTV = findViewById(R.id.themeTV);
        titleTV = findViewById(R.id.titleTV);
        themeSwitch = findViewById(R.id.themeSwitch);
       // parentView = findViewById(R.id.parentView);
        //  findSupport = findViewById(R.id.parentView);
      //  j = findViewById(R.id.journal);
        p = findViewById(R.id.progress);
      //  h = findViewById(R.id.homepage);
        // parentView = findViewById(R.id.parentView);
    }

    private void loadSharedPreferences()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE);
        String theme = sharedPreferences.getString(UserSettings.CUSTOM_THEME, UserSettings.LIGHT_THEME);
        settings.setCustomTheme(theme);
        updateView();
    }

    private void initSwitchListener()
    {
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked)
            {
                if(checked)
                    settings.setCustomTheme(UserSettings.DARK_THEME);
                else
                    settings.setCustomTheme(UserSettings.LIGHT_THEME);

                SharedPreferences.Editor editor = getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE).edit();
                editor.putString(UserSettings.CUSTOM_THEME, settings.getCustomTheme());
                editor.apply();
                updateView();
            }
        });
    }

    private void updateView()
    {
        final int black = ContextCompat.getColor(this, R.color.black);
        final int white = ContextCompat.getColor(this, R.color.white);

        if(settings.getCustomTheme().equals(UserSettings.DARK_THEME))
        {
            titleTV.setTextColor(white);
            themeTV.setTextColor(white);
            themeTV.setText("Dark");
           // parentView.setBackgroundColor(black);
          //  j.setBackgroundColor(black);
            p.setBackgroundColor(black);
          //  h.setBackgroundColor(black);
            themeSwitch.setChecked(true);
        }
        else
        {
            titleTV.setTextColor(black);
            themeTV.setTextColor(black);
            themeTV.setText("Light");
          //  parentView.setBackgroundColor(white);
          //  j.setBackgroundColor(white);
            p.setBackgroundColor(white);
            //h.setBackgroundColor(white);
            themeSwitch.setChecked(false);
        }

    }
}