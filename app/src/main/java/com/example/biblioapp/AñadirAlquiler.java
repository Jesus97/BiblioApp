package com.example.biblioapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class AñadirAlquiler extends DialogFragment {

    int Variable = 0;
    IntentIntegrator escanerDNI = new IntentIntegrator(getActivity());
    IntentIntegrator escanerISBN = new IntentIntegrator(getActivity());
    ImageButton fotoDNI,fotoISBN;
    Button añadirAlquiler,atras;
    EditText editDNI,editISBN;


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

            fotoDNI.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    escanerDNI.initiateScan();
                    Variable=1;
                }
            });

            fotoISBN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    escanerISBN.initiateScan();
                    Variable=2;
                }
            });
            return v;
        }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

            if(Variable==1){
                IntentResult escanerDNI = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
                String resultDNI = escanerDNI.getContents();
                editDNI.setText(resultDNI);
            }if(Variable==2){
            IntentResult escanerISBN = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
            String resultISBN = escanerISBN.getContents();
            editISBN.setText(resultISBN);
        }

    }
}
