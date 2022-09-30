package com.example.london;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

public class Journal extends AppCompatActivity {

    private int currentYear = 0;
    private int currentMonth = 0;
    private int currentDay = 0;
     private int daysIndex = 0;
    private int monthIndex = 0;
    private int yearIndex = 0;
    private SwitchMaterial themeSwitch;
    private TextView themeTV, titleTV;

    private UserSettings settings;
    private View j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.journal);
        CalendarView calendarView = findViewById(R.id.calendarView);
        final TextView selectedDay = findViewById(R.id.selectedDay);
        //final TextView selectedMonth = findViewById(R.id.selectedMonth);
        //final TextView selectedYear = findViewById(R.id.selectedYear);
        final EditText textInput = findViewById(R.id.textInput);
        final Button saveTextButton = findViewById(R.id.saveTextButton);
        final Button resetTextButton = findViewById(R.id.resetTextButton);
        final View dayContent = findViewById(R.id.dayContent);
        final int[] days = new int[31];
        final int[] months = new int[12];
        final int[] years = new int[20];
        List<String> calendarStrings = new ArrayList<>();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                currentYear = year;
                currentMonth = month;
                currentDay = dayOfMonth;
                selectedDay.setVisibility(View.INVISIBLE);
                if(dayContent.getVisibility()==View.GONE){
                    dayContent.setVisibility(View.VISIBLE);
                }
                for(int i = 0; i < 31; i++){
                    if(days[i] == currentDay){
                        for(int j = 0; j < 12; j++){
                            if(months[j] == currentMonth){
                                textInput.setText(calendarStrings.get(i));
                                selectedDay.setText(calendarStrings.get(i));
                                selectedDay.setVisibility(View.VISIBLE);
                                //textInput.setShowSoftInputOnFocus(false);
                                return;
                            }
                        }
                    }
                }
                textInput.setText("");
                //selectedDay.setVisibility(View.VISIBLE);
            }
        });


        resetTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textInput.setText("");
            }
        });
        saveTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //textInput.setShowSoftInputOnFocus(false);
                days[daysIndex] = currentDay;
                months[monthIndex] = currentMonth;
                years[yearIndex] = currentYear;
                //daysIndex++;
                calendarStrings.add(daysIndex,textInput.getText().toString());
                //textInput.setText("");
                daysIndex++;
                monthIndex++;
                yearIndex++;
                textInput.setText("");
                //textInput.setShowSoftInputOnFocus(false);
            }
        });
    }
    private void initWidgets()
    {
        themeTV = findViewById(R.id.themeTV);
        titleTV = findViewById(R.id.titleTV);
        themeSwitch = findViewById(R.id.themeSwitch);
       // parentView = findViewById(R.id.parentView);
        //  findSupport = findViewById(R.id.parentView);
        j = findViewById(R.id.journal);
       // p = findViewById(R.id.progress);
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
            j.setBackgroundColor(black);
          //  p.setBackgroundColor(black);
          //  h.setBackgroundColor(black);
            themeSwitch.setChecked(true);
        }
        else
        {
            titleTV.setTextColor(black);
            themeTV.setTextColor(black);
            themeTV.setText("Light");
           // parentView.setBackgroundColor(white);
            j.setBackgroundColor(white);
           // p.setBackgroundColor(white);
           // h.setBackgroundColor(white);
            themeSwitch.setChecked(false);
        }

    }

}