package com.example.london;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MartialArtsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_martial_arts, container, false);

        TextView hname=view.findViewById(R.id.specificHobbyNameTextId2);
        hname.setText("Martial Arts");
        TextView htext=view.findViewById(R.id.specificHobbyDetailsTextId2);
        htext.setText("Martial arts are codified systems and traditions of combat practiced for a number of reasons such as self-defense; military and law enforcement applications; competition; physical, mental, and spiritual development; entertainment; and the preservation of a nation's intangible cultural heritage.");

        Button hprev=view.findViewById(R.id.MAPrevButton);

        hprev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Fragment fragment1=new SoberFragment();
                FragmentTransaction fragmentObject1=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentObject1.replace(R.id.fragmentLayoutId,fragment1).commit();
            }
        });

        Button hnext=view.findViewById(R.id.MANextButton);

        hnext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Fragment fragment3=new MusicFragment();
                FragmentTransaction fragmentObject3=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentObject3.replace(R.id.fragmentLayoutId,fragment3).commit();
            }
        });

        return view;
    }
}