package com.example.london;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MusicFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        TextView hname=view.findViewById(R.id.specificHobbyNameTextId3);
        hname.setText("Music");
        TextView htext=view.findViewById(R.id.specificHobbyDetailsTextId3);
        htext.setText("Music is generally defined as the art of arranging sound to create some combination of form, harmony, melody, rhythm or otherwise expressive content.");

        Button hprev=view.findViewById(R.id.MusicPrevButton);

        hprev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Fragment fragment2=new com.example.london.MartialArtsFragment();
                FragmentTransaction fragmentObject2=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentObject2.replace(R.id.fragmentLayoutId,fragment2).commit();
            }
        });

        Button hnext=view.findViewById(R.id.MusicNextButton);

        hnext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Fragment fragment4=new com.example.london.CookingFragment();
                FragmentTransaction fragmentObject4=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentObject4.replace(R.id.fragmentLayoutId,fragment4).commit();
            }
        });

        return view;

    }
}