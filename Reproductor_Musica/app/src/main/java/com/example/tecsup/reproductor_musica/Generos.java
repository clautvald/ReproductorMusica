package com.example.tecsup.reproductor_musica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generos extends AppCompatActivity {
    RecyclerView recyclerView;
    Genero_Adaptador adaptadorGenero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generos);
        recyclerView = findViewById(R.id.rv_mostarGenero);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        ExtraerJSON("a");
    }

    RequestQueue mRequestQueue;
    private void ExtraerJSON(String urlspoty) {
        Response.Listener<String> response_listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                List<generoListas> genero= new ArrayList<>();
                Log.e("Responsess",response);

                try {
                    JSONObject categoriasjs = new JSONObject(response).getJSONObject("categories");
                    JSONArray items = categoriasjs.getJSONArray("items");



                    System.out.println("*****JARRAY*****"+items.length());
                    for(int i=0;i<items.length();i++){
                        JSONObject json_dataG = items.getJSONObject(i);
                        TextView tx= new TextView(getBaseContext());
                        genero.add(new generoListas(json_dataG.getString("name")));

                        adaptadorGenero = new Genero_Adaptador(genero);
                        recyclerView.setAdapter(adaptadorGenero);
                        //tx.setText(json_data.getString("name"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };


        Response.ErrorListener response_error_listener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    //TODO
                } else if (error instanceof AuthFailureError) {
                    //TODO
                } else if (error instanceof ServerError) {
                    //TODO
                } else if (error instanceof NetworkError) {
                    //TODO
                } else if (error instanceof ParseError) {
                    //TODO
                }
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                "https://api.spotify.com/v1/browse/categories",
                response_listener,response_error_listener)
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json");
                params.put("Authorization", "Bearer BQBH5wiSD5Bp00j-lnRvc55ykGfXkGOChSUrDjkwXx0kc27EK-KOr_xIobPdVdsq0_gQuXhYkQ6hRBnngYxF3nd0gH3G0tFxXCJxPN9DisINse0X0bY9lY86XmPAWEcqSuYAitp_judrxGf7UYyg-yjn-w");

                return params;
            }
        };

        getRequestQueue().add(stringRequest);
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }
}
