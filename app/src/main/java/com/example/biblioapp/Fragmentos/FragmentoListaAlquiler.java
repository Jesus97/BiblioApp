package com.example.biblioapp.Fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biblioapp.R;


public class FragmentoListaAlquiler extends Fragment {

    public FragmentoListaAlquiler() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_alquiler, container, false);
    }
}
