package com.example.contactos.manager;

import com.example.contactos.model.Contact;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FirebaseContactManager {

        private static final String CONTACTS_URL = "https://contactos-474c1-default-rtdb.firebaseio.com";

        // Class instance
        private static FirebaseContactManager instance = null;
        // Reference of Firebase object
        private DatabaseReference firebaseContactRef;
        // List contacts
        private HashMap<String, Contact> contactHashMap = new HashMap<>();

        /**
         * Classic Singleton design pattern implementation
         */
        public static FirebaseContactManager getInstance() {
            if (instance == null) {
                instance = new FirebaseContactManager();
            }
            return instance;
        }

        private FirebaseContactManager() {
            // Initialize Firebase reference
            firebaseContactRef = FirebaseDatabase.getInstance().getReferenceFromUrl(CONTACTS_URL);
        }

        /**
         * Retrieving the list  from Firebase server
         */
        public void getContactFromServer(ValueEventListener listener) {
            firebaseContactRef.keepSynced(true);
            Query queryRef = firebaseContactRef.orderByKey();
            queryRef.addListenerForSingleValueEvent(listener);
        }

        /**
         * Retrieving the list
         */
        public List<Contact> getAllContacts() {
            return new ArrayList<>(contactHashMap.values());
        }

        /**
         * Retrieving a contact from list
         */
        public Contact getContactByObjectId(String objectId) {
            return contactHashMap.get(objectId);
        }

        /**
         * Adding a contact to HashMap
         */
        public void addContactHashMap(Contact contact) {
            this.contactHashMap.put(contact.getObjectId(), contact);
        }
    }
