package com.example.biblioapp;

import android.content.Context;
import android.support.v4.app.DialogFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.biblioapp.Pojo.Usuario;
import com.example.biblioapp.Servidor.BibliotecaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AñadirUsuario extends DialogFragment{

    BibliotecaService bibliotecaService;
    EditText dni,nombre,apellidos,telefono,direccion;
    Button añadir,cancelar;
    String dniU, nombreU, apellidosU,telefonoU, direccionU;
    Usuario usuario = new Usuario(dniU,nombreU,apellidosU,telefonoU,direccionU);

    public AñadirUsuario(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.anadir_usuario,container,false);

        dni = v.findViewById(R.id.campo_dni);
        nombre = v.findViewById(R.id.campo_nombre);
        apellidos = v.findViewById(R.id.campo_apellidos);
        telefono = v.findViewById(R.id.campo_telefono);
        direccion = v.findViewById(R.id.campo_direccion);
        añadir = v.findViewById(R.id.botonAñadirUsuario);
        cancelar = v.findViewById(R.id.botonAtras);

        dniU = usuario.setDni(dni.getText().toString());
        nombreU = usuario.setNombre(nombre.getText().toString());
        apellidosU = usuario.setApellidos(apellidos.getText().toString());
        telefonoU = usuario.setTelefono(telefono.getText().toString());
        direccionU = usuario.setDireccion(direccion.getText().toString());

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Usuario> u = bibliotecaService.crearUsuario(usuario);
                u.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        Log.i("onCreateOK",call.toString());
                        Log.i("onCreateOK",response.message());
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Log.i("onCreateFail",call.toString());
                        Log.i("onCreateFail",t.getMessage());
                    }
                });
                dismiss();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return v;
    }

}

