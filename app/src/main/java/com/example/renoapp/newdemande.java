package com.example.renoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class newdemande extends AppCompatActivity {

    private EditText pieceEdt, descriptionEdt, budgetEdt, deadlineEdt;
    private Button updateBtn;
    private ProgressBar loadingPB;
    private TextView responseTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newdemande);

        // initializing our views with their ids.
        pieceEdt = findViewById(R.id.piece);
        descriptionEdt = findViewById(R.id.description);
        budgetEdt = findViewById(R.id.budget);
        deadlineEdt = findViewById(R.id.deadline);
        updateBtn = findViewById(R.id.createAnnounce);
        loadingPB = findViewById(R.id.idLoadingPB);
        responseTV = findViewById(R.id.idTVResponse);

        // adding on click listener for our button.
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking if the edit text is empty or not.
                if (TextUtils.isEmpty(pieceEdt.getText().toString()) && TextUtils.isEmpty(descriptionEdt.getText().toString())) {
                    // displaying a toast message if the edit text is empty.
                    Toast.makeText(newdemande.this, "Please enter your data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to update data in our API.
                callPUTDataMethod(pieceEdt.getText().toString(), descriptionEdt.getText().toString(), budgetEdt.getText().toString(), deadlineEdt.getText().toString());
            }
        });
    }

    private void callPUTDataMethod(String piece, String description, String budget, String deadline) {

        // making our progress bar visible.
        loadingPB.setVisibility(View.VISIBLE);

        // url for updating our data
        // in below url 2 is the identity at which
        // we will be updating our data.
        String url = "http://renovationAPI.personaldevelopment.space/api/announces";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(newdemande.this);

        // making a string request to update our data and
        // passing method as PUT. to update our data.
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                // hiding our progress bar.
                loadingPB.setVisibility(View.GONE);

                // inside on response method we are
                // setting our edit text to empty.
                pieceEdt.setText("");
                descriptionEdt.setText("");
                budgetEdt.setText("");
                deadlineEdt.setText("");

                // on below line we are displaying a toast message as data updated.
                Toast.makeText(newdemande.this, "Data Updated..", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are extracting data from our json object
                    // and passing our response to our json object.
                    JSONObject jsonObject = new JSONObject(response);

                    // creating a string for our output.
                    String output = jsonObject.getString("name") + "\n" + jsonObject.getString("job") + "\n" + jsonObject.getString("updatedAt");

                    // on below line we are setting
                    // our string to our text view.
                    responseTV.setText(output);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // displaying toast message on response failure.
                Toast.makeText(newdemande.this, "Fail to update data..", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("piece", piece);
                params.put("description", description);
                params.put("budget", budget);
                params.put("Y-m-d", deadline);
                params.put("user_id", "1");


                // at last we are
                // returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }
}