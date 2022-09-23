package com.example.renoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;

import java.util.List;

public class newreponse extends AppCompatActivity {
    private TextView responseTV;
    private TextView message;
    private TextView budget;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newreponse);
        Button buttonLogin = (Button) findViewById(R.id.createReponse);
        EditText messageReponse = (EditText)findViewById(R.id.messageReponse);
        message = findViewById(R.id.messageReponse);
        budget = findViewById(R.id.budgetReponse);
        button = findViewById(R.id.createReponse);
        responseTV = findViewById(R.id.idTVResponse);
        responseTV.setVisibility(View.GONE);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                responseTV.setVisibility(View.VISIBLE);
                responseTV.setText("Enregistré avec succès");
                message.setVisibility(View.GONE);
                budget.setVisibility(View.GONE);
                button.setVisibility(View.GONE);

            };
        });


    }
}