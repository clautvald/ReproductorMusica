package com.example.tecsup.reproductor_musica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Perfil_usuario extends AppCompatActivity {
TextView nombre;
ImageView imagenperfil;
TextView correo;
TextView tipo_usuario;
TextView follower;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        nombre = findViewById(R.id.txt_nombre);
        imagenperfil = findViewById(R.id.imagen_perfil);
        correo = findViewById(R.id.txt_correo);
        follower = findViewById(R.id.follower);
        tipo_usuario = findViewById(R.id.tipo_usuario);


        ExtraerJSON();
    }


    RequestQueue mRequestQueue;
    private void ExtraerJSON() {
        Response.Listener<String> response_listener = new Response.Listener<String>() {
            //RETORNA UN STRONG DE TIPO JSON EN RESPONSE
            @Override
            public void onResponse(String response) {
                Log.e("Responsess",response);

                try {
                    String minombre = new JSONObject(response).getString("display_name");
                    //Extraer un array de imagenes
                    JSONArray arrayFotos = new JSONObject(response).getJSONArray("images");
                    //saca un objeto de la posicion 0
                    JSONObject valor = arrayFotos.getJSONObject(0);
                    String urlfoto= valor.getString("url");
                    Log.e("resultado",urlfoto);
                    nombre.setText(minombre);
                    Picasso.with(getBaseContext()).load(urlfoto).into(imagenperfil);




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
                "https://api.spotify.com/v1/me",
                response_listener,response_error_listener)
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json");
                params.put("Authorization", "Bearer BQAKlV0lmtL5YO5pa_aEYYQK3HkQQilKLobEYH8Y-EjaKgjOZo9MMcyml69nhhjmR_mv16lwLoyAkjo0-pXtbpsw9_THiV_4Pv9xusTGj5GEANGKWzD7nO1kYTh5-TYgixm7J-G_oQKh4oadF1yqUxhyHFIE46c-uR8");

                return params;
            }
        };

        getRequestQueue().add(stringRequest);
    }

    //ESTA FUNCION CARGA LA IMAGEN DESDE INTERNET
/*
    private void loadImage(final ImageView imageView, final String imageUrl){
        Picasso.with(getBaseContext()).load(imageUrl).into(imageView);

    }*/

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }
}
