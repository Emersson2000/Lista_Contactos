package com.example.contactos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.contactos.R;
import com.example.contactos.manager.FirebaseContactManager;
import com.example.contactos.model.Contact;

public class MainActivity extends AppCompatActivity {
    private TextView nombre, correo, ciudad, telefono, descripción;
    private ImageView image;
    private FirebaseContactManager Contacfire;
    private Contact conta;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        String res= intent.getStringExtra("id");

        conta= Contacfire.getInstance().getContactByObjectId(res);

        nombre = (TextView) findViewById(R.id.textnombre);
        correo = (TextView)findViewById(R.id.textcorreo);
        ciudad = (TextView) findViewById(R.id.textciudad);
        telefono = (TextView)findViewById(R.id.textelefono);
        descripción = (TextView) findViewById(R.id.textDescripcion);
        image = (ImageView)findViewById(R.id.imageView);

//        nombre.setText(conta.getName());
//        correo.setText(conta.getEmail());
//        ciudad.setText(conta.getCity());
//        telefono.setText(conta.getPhone());
//        descripción.setText(conta.getDescription());

//        Glide.with(this)
//                .load(conta.getImageUrl())
//                .centerCrop()
//                .into(image);
    }
}