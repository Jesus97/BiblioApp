package com.example.biblioapp.Detalles;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.biblioapp.FragmentosListas.FragmentoListaLibros;
import com.example.biblioapp.Modelos.Libro;
import com.example.biblioapp.R;
import com.example.biblioapp.Servidor.BaseUrl;
import com.example.biblioapp.Servidor.BibliotecaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleLibro extends AppCompatActivity {

    BibliotecaService bibliotecaService;
    TextView detalleIsbn,detalleTitulo,detalleAutor,detalleEditorial,detalleGenero;
    EditText detalleNejemplares;
    Button modificarEjemplares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_libro);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        detalleIsbn = findViewById(R.id.detalleIsbn);
        detalleTitulo = findViewById(R.id.detalleTitulo);
        detalleAutor = findViewById(R.id.detalleAutor);
        detalleEditorial = findViewById(R.id.detalleEditorial);
        detalleGenero = findViewById(R.id.detalleGenero);
        detalleNejemplares = findViewById(R.id.detalleNejemplares);
        modificarEjemplares = findViewById(R.id.botonModificarEjemplares);

        final Libro libro = (Libro) getIntent().getExtras().getSerializable(FragmentoListaLibros.EXTRA_LIBRO);
        final Libro libro2 = new Libro();

        detalleIsbn.setText(libro.getIsbn());
        detalleTitulo.setText(libro.getTitulo());
        detalleAutor.setText(libro.getAutor());
        detalleEditorial.setText(libro.getEditorial());
        detalleGenero.setText(libro.getGenero());
        detalleNejemplares.setText(libro.getNejemplares());

        bibliotecaService = BaseUrl.getBiblioteca();

        modificarEjemplares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarEjemplaresMetodo(libro2);
                onBackPressed();
            }
        });
    }
    public void modificarEjemplaresMetodo(Libro libro2){
        libro2.setIsbn(detalleIsbn.getText().toString());
        libro2.setTitulo(detalleTitulo.getText().toString());
        libro2.setAutor(detalleAutor.getText().toString());
        libro2.setEditorial(detalleEditorial.getText().toString());
        libro2.setGenero(detalleGenero.getText().toString());
        libro2.setNejemplares(detalleNejemplares.getText().toString());

        bibliotecaService.modificarEjemplares(libro2).enqueue(new Callback<Libro>() {
            @Override
            public void onResponse(Call<Libro> call, Response<Libro> response) {
            }

            @Override
            public void onFailure(Call<Libro> call, Throwable t) {
                Log.i("onFAILCREATE", "" + t);
            }
        });
    }
}
