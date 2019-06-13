package com.example.biblioapp.Añadir;

import android.support.v4.app.DialogFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



import com.example.biblioapp.Modelos.Usuario;
import com.example.biblioapp.R;
import com.example.biblioapp.Servidor.BaseUrl;
import com.example.biblioapp.Servidor.BibliotecaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AñadirUsuario extends DialogFragment {


        BibliotecaService bibliotecaService;
        EditText dni, nombre, apellidos, telefono, direccion;
        Button añadir, cancelar;
        Usuario usuario = new Usuario();

        public AñadirUsuario() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

                View v = inflater.inflate(R.layout.anadir_usuario, container, false);

                dni = v.findViewById(R.id.campo_dni);
                nombre = v.findViewById(R.id.campo_nombre);
                apellidos = v.findViewById(R.id.campo_apellidos);
                telefono = v.findViewById(R.id.campo_telefono);
                direccion = v.findViewById(R.id.campo_direccion);
                añadir = v.findViewById(R.id.botonAñadirUsuario);
                cancelar = v.findViewById(R.id.botonAtras);

                bibliotecaService = BaseUrl.getBiblioteca();

                añadir.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                usuario.setDni(dni.getText().toString());
                                usuario.setNombre(nombre.getText().toString());
                                usuario.setApellidos(apellidos.getText().toString());
                                usuario.setTelefono(telefono.getText().toString());
                                usuario.setDireccion(direccion.getText().toString());
                                Log.i("USUARIO",""+usuario.toString());
                                crearUsuarioMetodo(usuario);

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

        public void crearUsuarioMetodo(Usuario usuario) {
                bibliotecaService.crearUsuario(usuario).enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {
                                Log.i("onFAILCREATE", "" + t);
                        }
                });
        }
        }


