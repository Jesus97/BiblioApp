package com.example.biblioapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.biblioapp.Pojo.Alquiler;
import com.example.biblioapp.Servidor.BibliotecaService;
import com.google.zxing.integration.android.IntentIntegrator;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AñadirAlquiler extends DialogFragment {

        BibliotecaService bibliotecaService;
        ImageButton fotoDNI,fotoISBN;
        Button añadirAlquiler,atras;
        EditText editDNI,editISBN;
        Alquiler alquiler = new Alquiler();


public AñadirAlquiler(){

        }

@Override
public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.anadir_alquiler,container,false);


        fotoDNI = v.findViewById(R.id.fotoDNI);
        fotoISBN = v.findViewById(R.id.fotoISBN);
        añadirAlquiler = v.findViewById(R.id.botonAñadirAlquiler);
        atras = v.findViewById(R.id.botonAtras);
        editDNI = v.findViewById(R.id.editDNI);
        editISBN = v.findViewById(R.id.editISBN);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        final String fecha = dateFormat.format(date);

        fotoDNI.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Log.e("ESCANER", "Contenido del scan");
                        IntentIntegrator escanerDNI = new IntentIntegrator(getActivity());
                        escanerDNI.setDesiredBarcodeFormats(IntentIntegrator.PRODUCT_CODE_TYPES);
                        escanerDNI.setPrompt("ESCANEAR DNI USUARIO");
                        escanerDNI.setCameraId(0);
                        escanerDNI.setBeepEnabled(false);
                        escanerDNI.setBarcodeImageEnabled(false);
                        escanerDNI.initiateScan();
                }
                });

                        añadirAlquiler.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                        alquiler.setDni(editDNI.getText().toString());
                                        alquiler.setIsbn(editISBN.getText().toString());
                                        alquiler.setFecha_alquiler(fecha);
                                        alquiler.setFecha_alquiler(fecha+15);

                                        Log.i("ALQUILER", "" + alquiler.toString());
                                        crearAlquilerMetodo(alquiler);
                                        dismiss();
                                }
                        });

                        atras.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                        dismiss();
                                }
                        });

                        return v;
                }
                public void crearAlquilerMetodo(Alquiler alquiler) {
                        bibliotecaService.crearAlquiler(alquiler).enqueue(new Callback<Alquiler>() {
                                @Override
                                public void onResponse(Call<Alquiler> call, Response<Alquiler> response) {

                                        if (response.code() == 201) {

                                        } else {
                                                Log.i("code", "" + response.code());
                                        }
                                }

                                @Override
                                public void onFailure(Call<Alquiler> call, Throwable t) {
                                        Log.i("onFAILCREATE", "" + t);
                                }
                        });
                }



}
