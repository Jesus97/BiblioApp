package com.example.biblioapp.FragmentosListas;

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

import com.example.biblioapp.Adaptadores.AdaptadorListaAlquileres;
import com.example.biblioapp.Añadir.AñadirAlquiler;
import com.example.biblioapp.Detalles.DetalleAlquiler;
import com.example.biblioapp.MainActivity;
import com.example.biblioapp.Modelos.VistaAlquiler;
import com.example.biblioapp.R;
import com.example.biblioapp.Servidor.BaseUrl;
import com.example.biblioapp.Servidor.BibliotecaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentoListaAlquiler extends Fragment {

    public static String EXTRA_ALQUILER = "EXTRA_ALQUILER";
    ListView listaLV;
    private BibliotecaService bibliotecaService;
    List<VistaAlquiler> listaAlquiler ;

    public FragmentoListaAlquiler() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_lista_alquiler, container, false);
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
                    AñadirAlquiler dialog = new AñadirAlquiler();
                    dialog.show(fragmentManager,"dialog_fragment");
                }
            });

            listaLV = view.findViewById(R.id.listaAlquiler);
            bibliotecaService = BaseUrl.getBiblioteca();

            Call<List<VistaAlquiler>> lista = bibliotecaService.getVistaAlquiler();

            Log.i("onShow", lista.toString());
            lista.enqueue(new Callback<List<VistaAlquiler>>() {
                @Override
                public void onResponse(Call<List<VistaAlquiler>> call, Response<List<VistaAlquiler>> response) {
                    if (response.isSuccessful()) {
                        listaAlquiler = response.body();
                        Log.i("onShowOK", listaAlquiler.toString());
                        AdaptadorListaAlquileres adapter = new AdaptadorListaAlquileres(getContext(), listaAlquiler);
                        listaLV.setAdapter(adapter);
                        Log.i("AQUI", adapter.toString());
                        Log.i("AQUI2", listaLV.toString());
                    }
                }
                @Override
                public void onFailure(Call<List<VistaAlquiler>> call, Throwable t) {
                    Log.i("onShowFail", t.getMessage());
                }
            });

            listaLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(FragmentoListaAlquiler.this.getActivity(), DetalleAlquiler.class);
                    intent.putExtra(EXTRA_ALQUILER, listaAlquiler.get(i));
                    startActivity(intent);
                }
            });

        }
    }
}




