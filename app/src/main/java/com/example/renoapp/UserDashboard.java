package com.example.renoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        Button buttonCreate = (Button) findViewById(R.id.plus);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), newdemande.class);
                v.getContext().startActivity(intent);
            };
        });

        Button buttonDemande = (Button) findViewById(R.id.demande);

        buttonDemande.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), mesdemande.class);
                v.getContext().startActivity(intent);
            };
        });



    }
}