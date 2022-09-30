package com.example.london;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class Homepage extends AppCompatActivity {
   // private SwitchMaterial themeSwitch;







    private TextView t1, t2,t3;
    private Button b1, b2,b3,b4,b5;

    private UserSettings settings1;
    private View h;
    private SwitchMaterial Switch;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        Button findSupport = findViewById(R.id.button);
        Button lifeStyle = findViewById(R.id.button4);
        Button journal = findViewById(R.id.button2);
        Button progress = findViewById(R.id.button3);
        Button settings = findViewById(R.id.button5);

        settings1 = (UserSettings) getApplication();

        initWidgets();
        loadSharedPreferences();
        initSwitchListener();
      //  SharedPreferences prefs = PreferenceManager
           //     .getDefaultSharedPreferences(this);
      //  if(prefs.getBoolean("use_light_theme",false)==true)
       // {
       //     setTheme(R.style.AppThemeLight);
      //  }
      //  super.onCreate(savedInstanceState);
     //   super.onCreate(savedInstanceState);

        //Button lifestyle = findViewById(R.id.imageView5);
        findSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(Homepage.this, FindSupport.class);
                startActivity(intent);
            }
        });
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(Homepage.this, Progress.class);
                startActivity(intent);
            }
        });
        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(Homepage.this, Journal.class);
                startActivity(intent);
            }
        });
        lifeStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(Homepage.this, LifestyleActivity.class);
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(Homepage.this, Preference.class);
                startActivity(intent);
            }
        });

    }
    /*
    public void Change(View View)
    {
        String button_text;
        button_text =((Button)View).getText().toString();
        if(View.getId()==R.id.imageView2)
        {
            Intent change = new Intent(this,FindSupport.class);
            startActivity(change);
        }
        else if(View.getId()==R.id.imageView3){
            Intent change = new Intent(this,Journal.class);
            startActivity(change);
        }
        else if(View.getId()==R.id.imageView4){
            Intent change = new Intent(this, Progress.class);
            startActivity(change);
        }
    }

     */
    private void initWidgets()
    {
      //  themeTV = findViewById(R.id.themeTV);
      //  titleTV = findViewById(R.id.titleTV);
        Switch = findViewById(R.id.themeSwitch);
       // parentView = findViewById(R.id.parentView);
        //  findSupport = findViewById(R.id.parentView);
      //  j = findViewById(R.id.journal);
       // p = findViewById(R.id.progress);
        h = findViewById(R.id.homepage);
         b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
         b3 = findViewById(R.id.button4);
         b4 = findViewById(R.id.button3);
        t1 = findViewById(R.id.textView5);
        t2 = findViewById(R.id.textView6);
        t3 = findViewById(R.id.textView12);
        // parentView = findViewById(R.id.parentView);
    }

    private void loadSharedPreferences()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE);
        String theme = sharedPreferences.getString(UserSettings.CUSTOM_THEME, UserSettings.LIGHT_THEME);
        settings1.setCustomTheme(theme);
        updateView();
    }

    private void initSwitchListener()
    {
        Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked)
            {
                if(checked)
                    settings1.setCustomTheme(UserSettings.DARK_THEME);
                else
                    settings1.setCustomTheme(UserSettings.LIGHT_THEME);

                SharedPreferences.Editor editor = getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE).edit();
                editor.putString(UserSettings.CUSTOM_THEME, settings1.getCustomTheme());
                editor.apply();
                updateView();
            }
        });
    }

    private void updateView()
    {
        final int black = ContextCompat.getColor(this, R.color.black);
        final int white = ContextCompat.getColor(this, R.color.white);
        final int cc = ContextCompat.getColor(this, R.color.teal_200);
        final int cc1 = ContextCompat.getColor(this, R.color.purple_200);

        if(settings1.getCustomTheme().equals(UserSettings.DARK_THEME))
        {
            t1.setTextColor(white);
            t2.setTextColor(white);
            t3.setTextColor(white);
            b1.setBackgroundColor(cc);
           b2.setBackgroundColor(cc);
            b3.setBackgroundColor(cc);
            b4.setBackgroundColor(cc);
          //  b5.setBackgroundColor(cc);
         //   parentView.setBackgroundColor(black);
         //   j.setBackgroundColor(black);
          //  p.setBackgroundColor(black);
            h.setBackgroundColor(black);
            Switch.setChecked(true);
        }
        else
        {
            t1.setTextColor(black);
            t2.setTextColor(black);
            t3.setTextColor(black);
            b1.setBackgroundColor(cc1);
            b2.setBackgroundColor(cc1);
            b3.setBackgroundColor(cc1);
            b4.setBackgroundColor(cc1);
          ///  titleTV.setTextColor(black);
           // themeTV.setTextColor(black);
           // themeTV.setText("Light");
          //  parentView.setBackgroundColor(white);
          //  j.setBackgroundColor(white);
          //  p.setBackgroundColor(white);
            h.setBackgroundColor(white);
            Switch.setChecked(false);
        }

    }
}
