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
import com.example.biblioapp.Servidor.BaseUrl;
import com.example.biblioapp.Servidor.BibliotecaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AñadirLibro extends DialogFragment {

    BibliotecaService bibliotecaService;
    EditText isbn,titulo,autor,editorial,genero,n_ejemplares;
    Button añadir,cancelar;
    Libro libro = new Libro();

    public AñadirLibro(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.anadir_libro, container, false);

        isbn = v.findViewById(R.id.campo_isbn);
        titulo = v.findViewById(R.id.campo_titulo);
        autor = v.findViewById(R.id.campo_autor);
        editorial = v.findViewById(R.id.campo_editorial);
        genero = v.findViewById(R.id.campo_genero);
        n_ejemplares = v.findViewById(R.id.campo_numero_ejemplares);
        añadir = v.findViewById(R.id.botonAñadirLibro);
        cancelar = v.findViewById(R.id.botonAtras);

        bibliotecaService = BaseUrl.getBiblioteca();

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                libro.setIsbn(isbn.getText().toString());
                libro.setTitulo(titulo.getText().toString());
                libro.setAutor(autor.getText().toString());
                libro.setEditorial(editorial.getText().toString());
                libro.setGenero(genero.getText().toString());
                libro.setNejemplares(n_ejemplares.getText().toString());
                Log.i("LIBRO",""+libro.toString());
                crearLibroMetodo(libro);

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

    public void crearLibroMetodo(Libro libro) {
        bibliotecaService.crearLibro(libro).enqueue(new Callback<Libro>() {
            @Override
            public void onResponse(Call<Libro> call, Response<Libro> response) {

                if (response.code()==201) {

                }else{
                    Log.i("code",""+response.code());
                }
            }

            @Override
            public void onFailure(Call<Libro> call, Throwable t) {
                Log.i("onFAILCREATE", "" + t);
            }
        });
    }
}
