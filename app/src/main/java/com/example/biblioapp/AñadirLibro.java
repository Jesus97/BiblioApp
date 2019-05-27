package com.example.biblioapp;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.biblioapp.Pojo.Libro;
import com.example.biblioapp.Pojo.Usuario;
import com.example.biblioapp.Servidor.BibliotecaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AñadirLibro extends DialogFragment {

    BibliotecaService bibliotecaService;
    EditText isbn,titulo,autor,editorial,genero,n_ejemplares;
    Button añadir,cancelar;
    String isbnU, tituloU, autorU,editorialU,generoU,n_ejemplaresU;
    Libro libro = new Libro(isbnU,tituloU,autorU,editorialU,generoU,n_ejemplaresU);

    public AñadirLibro(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.anadir_libro,container,false);

        isbn = v.findViewById(R.id.campo_isbn);
        titulo = v.findViewById(R.id.campo_titulo);
        autor = v.findViewById(R.id.campo_autor);
        editorial = v.findViewById(R.id.campo_editorial);
        genero = v.findViewById(R.id.campo_genero);
        n_ejemplares = v.findViewById(R.id.campo_numero_ejemplares);
        añadir = v.findViewById(R.id.botonAñadirUsuario);
        cancelar = v.findViewById(R.id.botonAtras);

        isbnU = libro.setIsbn(isbn.getText().toString());
        tituloU = libro.setTitulo(titulo.getText().toString());
        autorU = libro.setAutor(autor.getText().toString());
        editorialU = libro.setEditorial(editorial.getText().toString());
        generoU = libro.setGenero(genero.getText().toString());
        n_ejemplaresU = libro.setNejemplares(n_ejemplares.getText().toString());

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Libro> u = bibliotecaService.crearLibro(libro);
                u.enqueue(new Callback<Libro>() {
                    @Override
                    public void onResponse(Call<Libro> call, Response<Libro> response) {
                        Log.i("onCreateOK",call.toString());
                        Log.i("onCreateOK",response.message());
                    }

                    @Override
                    public void onFailure(Call<Libro> call, Throwable t) {
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
