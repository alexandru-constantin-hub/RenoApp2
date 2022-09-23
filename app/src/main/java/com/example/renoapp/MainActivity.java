package com.example.renoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLogin = (Button) findViewById(R.id.button_login);
        EditText usernameEdit   = (EditText)findViewById(R.id.username);
        EditText passwordEdit   = (EditText)findViewById(R.id.password);
        TextView usernameError = (TextView)findViewById(R.id.username_error);
        TextView passwordError = (TextView)findViewById(R.id.password_error);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(usernameEdit.getText().toString().equals("test@test.com") && passwordEdit.getText().toString().equals("123")) {
                    Intent intent = new Intent(v.getContext(), UserDashboard.class);
                    v.getContext().startActivity(intent);
                    editor.putString("type","user");
                    editor.apply();
                    } else {

                        if(usernameEdit.getText().toString().equals("entreprise@test.com") && passwordEdit.getText().toString().equals("123")) {
                            Intent intent = new Intent(v.getContext(), EntrepriseDashboard.class);
                            v.getContext().startActivity(intent);
                            editor.putString("type","entreprise");
                            editor.apply();
                        } else {
                            if(usernameEdit.getText().toString() != "test@test.com") {
                                usernameError.setVisibility(View.VISIBLE);
                            }
                            if(passwordEdit.getText().toString() != "123") {
                                passwordError.setVisibility(View.VISIBLE);
                            }
                        }

                    }
                }
        });

    }

}