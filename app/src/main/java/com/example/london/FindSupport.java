package com.example.london;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FindSupport extends AppCompatActivity {

    com.example.london.DatabaseAdapter databaseAdapter;
    RecyclerView rvPrograms;
    com.example.london.ContactsAdapter contactsAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<com.example.london.Contacts> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findsupport);
        com.example.london.PreCreateDB.copyDB(this);
        databaseAdapter = new com.example.london.DatabaseAdapter(this);
        contactsList = databaseAdapter.getAllContacts();
        rvPrograms = findViewById(R.id.rvPrograms);
        rvPrograms.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvPrograms.setLayoutManager(layoutManager);
        contactsAdapter = new com.example.london.ContactsAdapter(this, contactsList, rvPrograms);
        rvPrograms.setAdapter(contactsAdapter);
    }
}
