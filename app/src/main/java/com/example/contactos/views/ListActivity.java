package com.example.contactos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.contactos.R;
import com.example.contactos.adapter.ContactAdapter;
import com.example.contactos.manager.FirebaseContactManager;
import com.example.contactos.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView mListView;
    private ContactAdapter contactAdapter;
    private List<Contact> mListContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Set views
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setOnItemClickListener(this);

        // Set contact list
        mListContacts = FirebaseContactManager.getInstance().getAllContacts();
        // check if list is null or empty to show the list or an informative text
        if (mListContacts != null && mListContacts.size() > 0) {
            mListView.setVisibility(View.VISIBLE);

            // Init adapter
            contactAdapter = new ContactAdapter(this, mListContacts);
            mListView.setAdapter(contactAdapter);
        } else {
            mListView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // start detail screen when an item list is pressed
        Intent intent = new Intent();
        intent.setClass(ListActivity.this, MainActivity.class);
        intent.putExtra("id", mListContacts.get(position).getObjectId());
        startActivity(intent);
    }
}