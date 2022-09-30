package com.example.london;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class SoberFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sober, container, false);

        TextView hname=view.findViewById(R.id.specificHobbyNameTextId);
        hname.setText("Remain Sober");
        TextView htext=view.findViewById(R.id.specificHobbyDetailsTextId);
        htext.setText("Sobriety means not being under the influence of a substance. However, the word is often used in different ways in different contexts. Many 12-step programs suggest that sobriety means total abstinence—never using the substance ever again.");

        Button hnext=view.findViewById(R.id.soberNextButton);

        hnext.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View view){

                Fragment fragment2=new com.example.london.MartialArtsFragment();
                FragmentTransaction fragmentObject2=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentObject2.replace(R.id.fragmentLayoutId,fragment2).commit();
            }
        });


        return view;
    }
}