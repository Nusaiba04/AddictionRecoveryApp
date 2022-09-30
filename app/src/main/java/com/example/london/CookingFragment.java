package com.example.london;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class CookingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cooking, container, false);

        TextView hname=view.findViewById(R.id.specificHobbyNameTextId4);
        hname.setText("Cooking");
        TextView htext=view.findViewById(R.id.specificHobbyDetailsTextId4);
        htext.setText("Cooking, cookery, or culinary arts is the art, science and craft of using heat to prepare food for consumption.");

        Button hprev=view.findViewById(R.id.CookingPrevButton);

        hprev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Fragment fragment3=new MusicFragment();
                FragmentTransaction fragmentObject1=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentObject1.replace(R.id.fragmentLayoutId,fragment3).commit();
            }
        });

        Button hnext=view.findViewById(R.id.CookingNextButton);

        hnext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Fragment fragment5=new WritingFragment();
                FragmentTransaction fragmentObject5=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentObject5.replace(R.id.fragmentLayoutId,fragment5).commit();
            }
        });

        return view;
    }
}