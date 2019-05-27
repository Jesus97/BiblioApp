package com.example.biblioapp.Servidor;

import com.example.biblioapp.Pojo.Libro;
import com.example.biblioapp.Pojo.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BibliotecaService {

    @GET("usuario/read.php")
    Call<List<Usuario>> getUsuarios();

    @GET("libro/read.php")
    Call<List<Libro>> getLibros();

    @POST("usuario/create.php")
    Call<Usuario> crearUsuario(@Body Usuario usuario);

    @POST("libro/create.php")
    Call<Libro> crearLibro(@Body Libro libro);

}
