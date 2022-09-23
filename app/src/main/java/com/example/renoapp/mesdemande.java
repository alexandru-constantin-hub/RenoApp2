package com.example.renoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class mesdemande extends AppCompatActivity {

    ListView demandeListView;
    final String url = "http://renovationAPI.personaldevelopment.space/api/announces";
    List<Demande> demandeList;
    ListDemandeAdapter demandeAdapter;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesdemande);
        demandeListView = findViewById(R.id.listeDemande);
        demandeList = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);//This will take care of
        //background newtwork activities
        getdata();
        demandeAdapter = new ListDemandeAdapter(this,R.layout.demande,demandeList);
        demandeListView.setAdapter(demandeAdapter);

        demandeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent appInfo = new Intent(mesdemande.this, newreponse.class);
                startActivity(appInfo);
            }
        });
    }
    private void getdata()
    {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONArray jsonArray = response;
                try {
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String piece = jsonObject.getString("piece");
                        String description = jsonObject.getString("description");
                        String budget = jsonObject.getString("budget");
                        String deadline = jsonObject.getString("Y-m-d");
                        demandeList.add(new Demande(piece,description, budget, deadline));
                    }
                    demandeAdapter.notifyDataSetChanged();//To prevent app from crashing when updating
                    //UI through background Thread
                }
                catch (Exception w)
                {
                    Toast.makeText(mesdemande.this,w.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mesdemande.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

}