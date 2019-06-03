package com.example.biblioapp.Detalles;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.biblioapp.Fragmentos.FragmentoListaUsuarios;
import com.example.biblioapp.Pojo.Usuario;

public class DetalleUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Usuario usuario = (Usuario) getIntent().getExtras().getSerializable(FragmentoListaUsuarios.EXTRA_USUARIO);

        Log.i("Usuario tocado", String.valueOf(usuario));

    }
}
