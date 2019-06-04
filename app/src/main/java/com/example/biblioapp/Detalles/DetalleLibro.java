package com.example.biblioapp.Detalles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.biblioapp.Fragmentos.FragmentoListaLibros;
import com.example.biblioapp.Pojo.Libro;
import com.example.biblioapp.R;

public class DetalleLibro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_libro);

        TextView detalleIsbn,detalleTitulo,detalleAutor,detalleEditorial,detalleGenero,detalleNejemplares;


        detalleIsbn = findViewById(R.id.detalleIsbn);
        detalleTitulo = findViewById(R.id.detalleTitulo);
        detalleAutor = findViewById(R.id.detalleAutor);
        detalleEditorial = findViewById(R.id.detalleEditorial);
        detalleGenero = findViewById(R.id.detalleGenero);
        detalleNejemplares = findViewById(R.id.detalleNejemplares);

        Libro libro = (Libro) getIntent().getExtras().getSerializable(FragmentoListaLibros.EXTRA_LIBRO);

        detalleIsbn.setText(libro.getIsbn());
        detalleTitulo.setText(libro.getTitulo());
        detalleAutor.setText(libro.getAutor());
        detalleEditorial.setText(libro.getEditorial());
        detalleGenero.setText(libro.getGenero());
        detalleNejemplares.setText(libro.getNejemplares());


    }

}
