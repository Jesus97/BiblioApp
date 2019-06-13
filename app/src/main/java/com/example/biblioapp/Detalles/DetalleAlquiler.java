package com.example.biblioapp.Detalles;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.biblioapp.FragmentosListas.FragmentoListaAlquiler;
import com.example.biblioapp.Modelos.Alquiler;
import com.example.biblioapp.Modelos.VistaAlquiler;
import com.example.biblioapp.R;
import com.example.biblioapp.Servidor.BaseUrl;
import com.example.biblioapp.Servidor.BibliotecaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleAlquiler extends AppCompatActivity {

    BibliotecaService bibliotecaService;
    Button botonDevolver;
    TextView detalleDNI, detalleNombre,detalleApellidos,detalleTelefono,detalleDireccion,detalleISBN,detalleTitulo,detalleAutor,detalleEditorial,detalleGenero,detalleNejemplares, detalleFechaAlquiler, detalleFechaDevolucion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_alquiler);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        botonDevolver = findViewById(R.id.botonDevolver);
        detalleDNI = findViewById(R.id.detalleDNI);
        detalleNombre = findViewById(R.id.detalleNombre);
        detalleApellidos = findViewById(R.id.detalleApellidos);
        detalleTelefono = findViewById(R.id.detalleTelefono);
        detalleDireccion = findViewById(R.id.detalleDireccion);
        detalleISBN = findViewById(R.id.detalleISBN);
        detalleTitulo = findViewById(R.id.detalleTitulo);
        detalleAutor = findViewById(R.id.detalleAutor);
        detalleEditorial = findViewById(R.id.detalleEditorial);
        detalleGenero = findViewById(R.id.detalleGenero);
        detalleNejemplares = findViewById(R.id.detalleNejemplares);
        detalleFechaAlquiler = findViewById(R.id.detalleFechaAlquiler);
        detalleFechaDevolucion = findViewById(R.id.detalleFechaDevolucion);

        final VistaAlquiler vista = (VistaAlquiler) getIntent().getExtras().getSerializable(FragmentoListaAlquiler.EXTRA_ALQUILER);
        final Alquiler alquiler = new Alquiler();

        detalleDNI.setText(vista.getDni());
        detalleNombre.setText(vista.getNombre());
        detalleApellidos.setText(vista.getApellidos());
        detalleTelefono.setText(vista.getTelefono());
        detalleDireccion.setText(vista.getDireccion());
        detalleISBN.setText(vista.getIsbn());
        detalleTitulo.setText(vista.getTitulo());
        detalleAutor.setText(vista.getAutor());
        detalleEditorial.setText(vista.getEditorial());
        detalleGenero.setText(vista.getGenero());
        detalleNejemplares.setText(vista.getNejemplares());
        detalleFechaAlquiler.setText(vista.getFecha_alquiler());
        detalleFechaDevolucion.setText(vista.getFecha_devolucion());

        alquiler.setDni(detalleDNI.getText().toString());
        alquiler.setIsbn(detalleISBN.getText().toString());
        alquiler.setFecha_alquiler(detalleFechaAlquiler.getText().toString());
        alquiler.setFecha_devolucion(detalleFechaDevolucion.getText().toString());

        bibliotecaService = BaseUrl.getBiblioteca();

        botonDevolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrarAlquilerMetodo(alquiler);
                onBackPressed();
            }
        });

    }

    public void borrarAlquilerMetodo(final Alquiler alquiler){
        bibliotecaService.borrarAlquiler(alquiler).enqueue(new Callback<Alquiler>() {
            @Override
            public void onResponse(Call<Alquiler> call, Response<Alquiler> response) {
            }

            @Override
            public void onFailure(Call<Alquiler> call, Throwable t) {
                Log.i("onFAILCREATE", "" + t);
            }
        });
    }

}

