package com.example.biblioapp.Fragmentos;

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
import android.widget.ListView;
import android.widget.Toast;

import com.example.biblioapp.Adaptadores.AdaptadorListaAlquiler;
import com.example.biblioapp.AñadirAlquiler;
import com.example.biblioapp.MainActivity;
import com.example.biblioapp.Pojo.Alquiler;
import com.example.biblioapp.R;
import com.example.biblioapp.Servidor.BaseUrl;
import com.example.biblioapp.Servidor.BibliotecaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentoListaAlquiler extends Fragment {

    ListView listaLV;
    private BibliotecaService bibliotecaService;
    List<Alquiler> listaAlquiler ;

    public FragmentoListaAlquiler() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_alquiler, container, false);
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

            Call<List<Alquiler>> lista = bibliotecaService.getAlquileres();

            Log.i("onShow", lista.toString());
            lista.enqueue(new Callback<List<Alquiler>>() {
                @Override
                public void onResponse(Call<List<Alquiler>> call, Response<List<Alquiler>> response) {
                    if (response.isSuccessful()) {
                        listaAlquiler = response.body();
                        Log.i("onShowOK", listaAlquiler.toString());
                        AdaptadorListaAlquiler adapter = new AdaptadorListaAlquiler(getContext(), listaAlquiler);
                        listaLV.setAdapter(adapter);
                        Log.i("AQUI", adapter.toString());
                        Log.i("AQUI2", listaLV.toString());
                    }
                }
                @Override
                public void onFailure(Call<List<Alquiler>> call, Throwable t) {
                    Log.i("onShowFail", t.getMessage());
                }
            });
    }
}
}
