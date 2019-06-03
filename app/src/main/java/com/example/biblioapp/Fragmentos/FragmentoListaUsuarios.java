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


import com.example.biblioapp.Adaptadores.AdaptadorListaUsuarios;
import com.example.biblioapp.AñadirUsuario;
import com.example.biblioapp.Detalles.DetalleUsuario;
import com.example.biblioapp.MainActivity;
import com.example.biblioapp.Pojo.Usuario;
import com.example.biblioapp.R;
import com.example.biblioapp.Servidor.BaseUrl;
import com.example.biblioapp.Servidor.BibliotecaService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentoListaUsuarios extends Fragment {

    public static final String EXTRA_USUARIO = "EXTRA_USUARIO";
    ListView listaLV;
    private BibliotecaService bibliotecaService;
    List<Usuario> listaUsuario ;

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
            bibliotecaService = BaseUrl.getBiblioteca();

            Call<List<Usuario>> lista = bibliotecaService.getUsuarios();

            Log.i("onShow", lista.toString());
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
                    Log.i("onShowFail", t.getMessage());
                }
            });

            /*listaLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView <?> adapterView, View view, int i, long l){
                    Intent intent = new Intent(FragmentoListaUsuarios.class, DetalleUsuario.class);
                    intent.putExtra("ALGO", (Serializable) listaUsuario.get(i));
                    startActivity(intent);
                    }
                    });*/


        }
    }
}



