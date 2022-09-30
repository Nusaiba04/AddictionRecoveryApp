package com.example.london;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class WritingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_writing, container, false);

        TextView hname=view.findViewById(R.id.specificHobbyNameTextId5);
        hname.setText("Writing");
        TextView htext=view.findViewById(R.id.specificHobbyDetailsTextId5);
        htext.setText("Creative writing can be a great way to express yourself, explore different worlds and characters, and escape from everyday life. And it’s not just novelists and poets who enjoy writing as a hobby – anyone can do it!");

        Button hprev=view.findViewById(R.id.WritingPrevButton);

        hprev.setOnClickListener(new View.OnClickListener(){
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