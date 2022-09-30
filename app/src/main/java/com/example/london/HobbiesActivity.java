package com.example.london;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HobbiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);

        Fragment fragment1=new SoberFragment();

        FragmentTransaction fragmentObject1=getSupportFragmentManager().beginTransaction();
        fragmentObject1.replace(R.id.fragmentLayoutId,fragment1).commit();
    }
}