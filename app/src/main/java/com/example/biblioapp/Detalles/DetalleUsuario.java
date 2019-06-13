package com.example.biblioapp.Detalles;

import android.os.Bundle;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.biblioapp.FragmentosListas.FragmentoListaUsuarios;
import com.example.biblioapp.Modelos.Usuario;
import com.example.biblioapp.R;
import com.example.biblioapp.Servidor.BaseUrl;
import com.example.biblioapp.Servidor.BibliotecaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleUsuario extends AppCompatActivity {

    BibliotecaService bibliotecaService;
    Button botonEliminarUsuario;
    TextView detalleDni,detalleNombre,detalleApellidos,detalleTelefono,detalleDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_usuario);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        detalleDni = findViewById(R.id.detalleDni);
        detalleNombre = findViewById(R.id.detalleNombre);
        detalleApellidos = findViewById(R.id.detalleApellidos);
        detalleTelefono = findViewById(R.id.detalleTelefono);
        detalleDireccion = findViewById(R.id.detalleDireccion);
        botonEliminarUsuario = findViewById(R.id.botonEliminarUsuario);

        final Usuario usuario = (Usuario) getIntent().getExtras().getSerializable(FragmentoListaUsuarios.EXTRA_USUARIO);

        detalleDni.setText(usuario.getDni());
        detalleNombre.setText(usuario.getNombre());
        detalleApellidos.setText(usuario.getApellidos());
        detalleTelefono.setText(usuario.getTelefono());
        detalleDireccion.setText(usuario.getDireccion());

        bibliotecaService = BaseUrl.getBiblioteca();

        botonEliminarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrarUsuarioMetodo(usuario);
                onBackPressed();
            }
        });
    }
    public void borrarUsuarioMetodo(Usuario usuario){
        bibliotecaService.borrarUsuario(usuario).enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
            }
        });
    }

}



