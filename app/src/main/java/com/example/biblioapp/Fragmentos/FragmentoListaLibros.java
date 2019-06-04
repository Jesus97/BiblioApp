package com.example.biblioapp.Fragmentos;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.biblioapp.Adaptadores.AdaptadorListaLibros;
import com.example.biblioapp.AñadirLibro;
import com.example.biblioapp.Detalles.DetalleLibro;
import com.example.biblioapp.MainActivity;

import com.example.biblioapp.Pojo.Libro;
import com.example.biblioapp.R;
import com.example.biblioapp.Servidor.BaseUrl;
import com.example.biblioapp.Servidor.BibliotecaService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentoListaLibros extends Fragment {

    public static String EXTRA_LIBRO = "EXTRA_LIBRO";
    ListView listaLV;
    private BibliotecaService bibliotecaService;
    List<Libro> listaLibro ;

    public FragmentoListaLibros() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_lista_libros, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            FloatingActionButton fab = mainActivity.findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    AñadirLibro dialog = new AñadirLibro();
                    dialog.show(fragmentManager,"dialog_fragment");
                }
            });

            listaLV = view.findViewById(R.id.listaLibros);
            bibliotecaService = BaseUrl.getBiblioteca();

            Call<List<Libro>> lista = bibliotecaService.getLibros();

            Log.i("onShow", lista.toString());
            lista.enqueue(new Callback<List<Libro>>() {
                @Override
                public void onResponse(Call<List<Libro>> call, Response<List<Libro>> response) {
                    if (response.isSuccessful()) {
                        listaLibro = response.body();
                        Log.i("onShowOK", listaLibro.toString());
                        AdaptadorListaLibros adapter = new AdaptadorListaLibros(getContext(), listaLibro);
                        listaLV.setAdapter(adapter);
                    }
                }
                @Override
                public void onFailure(Call<List<Libro>> call, Throwable t) {
                    Log.i("onShowFail", t.getMessage());
                }
            });

            listaLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView <?> adapterView, View view, int i, long l){
                    Intent intent = new Intent(FragmentoListaLibros.this.getActivity(), DetalleLibro.class);
                    intent.putExtra(EXTRA_LIBRO,listaLibro.get(i));
                    startActivity(intent);
                }
            });
        }
    }
}
