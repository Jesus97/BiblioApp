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


import com.example.biblioapp.Adaptadores.AdaptadorListaUsuarios;
import com.example.biblioapp.AñadirUsuario;
import com.example.biblioapp.MainActivity;
import com.example.biblioapp.Pojo.Usuario;
import com.example.biblioapp.R;
import com.example.biblioapp.Servidor.BaseUrl;
import com.example.biblioapp.Servidor.BibliotecaService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentoListaUsuarios extends Fragment {

    ListView listaLV;
    private BibliotecaService bibliotecaService;
    List<Usuario> listaUsuario = new ArrayList<>();

    public FragmentoListaUsuarios() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_lista_usuarios, container, false);
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
                    AñadirUsuario dialog = new AñadirUsuario();
                    dialog.show(fragmentManager,"dialog_fragment");
                }
            });

            listaLV = view.findViewById(R.id.listaUsuarios);

            AdaptadorListaUsuarios adapter = new AdaptadorListaUsuarios(getContext(), listaUsuario);
            listaLV.setAdapter(adapter);
            Log.i("onShow", listaUsuario.toString());
            bibliotecaService = BaseUrl.getBiblioteca();

            Call<List<Usuario>> lista = bibliotecaService.getUsuarios();
            lista.enqueue(new Callback<List<Usuario>>() {
                @Override
                public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                    if (response.isSuccessful()) {
                        listaUsuario = response.body();
                        Log.i("onShowOK", listaUsuario.toString());
                        AdaptadorListaUsuarios adapter = new AdaptadorListaUsuarios(getContext(), listaUsuario);
                        listaLV.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<List<Usuario>> call, Throwable t) {
                    Log.i("onShowFail", listaUsuario.toString());
                    Log.i("onShowFail", t.getMessage());
                }
            });
        }
    }
}


