package com.example.biblioapp.Añadir;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.biblioapp.Modelos.Alquiler;
import com.example.biblioapp.R;
import com.example.biblioapp.Servidor.BaseUrl;
import com.example.biblioapp.Servidor.BibliotecaService;
import com.google.zxing.integration.android.IntentIntegrator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        bibliotecaService = BaseUrl.getBiblioteca();

        Date date = Calendar.getInstance().getTime();
        Date date1 = sumarDiasAFecha(date,15);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        final String fecha = dateFormat.format(date);
        final String fecha2 = dateFormat.format(date1);

        fotoDNI.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        IntentIntegrator escanerDNI = new IntentIntegrator(getActivity());
                        escanerDNI.setRequestCode(1);
                        escanerDNI.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                        escanerDNI.setPrompt("ESCANEAR DNI USUARIO");
                        escanerDNI.initiateScan();

                }
        });

        fotoISBN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        IntentIntegrator escanerISBN = new IntentIntegrator(getActivity());
                        escanerISBN.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                        escanerISBN.setRequestCode(2);
                        escanerISBN.setPrompt("ESCANEAR ISBN");
                        escanerISBN.initiateScan();

                }
        });


        añadirAlquiler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        alquiler.setDni(editDNI.getText().toString());
                        alquiler.setIsbn(editISBN.getText().toString());
                        alquiler.setFecha_alquiler(fecha);
                        alquiler.setFecha_devolucion(fecha2);

                        Log.i("ALQUILER",alquiler.toString());
                        Log.i("SERVICE",bibliotecaService.toString());
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
        }
@Override
public void onFailure(Call<Alquiler> call, Throwable t) {
        Log.i("onFAILCREATE", "" + t);
        }
        });
        }

        public void recogerResultadoDNI(String resultado){
                editDNI.setText(resultado);
        }
        public void recogerResultadoISBN(String resultado){
                editISBN.setText(resultado);
        }


        public static Date sumarDiasAFecha(Date fecha, int dias){
        if (dias==0) return fecha;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
        }



        }
