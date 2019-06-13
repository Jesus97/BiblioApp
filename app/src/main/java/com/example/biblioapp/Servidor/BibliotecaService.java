package com.example.biblioapp.Servidor;

import com.example.biblioapp.Modelos.Alquiler;
import com.example.biblioapp.Modelos.Libro;
import com.example.biblioapp.Modelos.Usuario;
import com.example.biblioapp.Modelos.VistaAlquiler;

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

    @GET("vista/read.php")
    Call<List<VistaAlquiler>> getVistaAlquiler();

    @POST("alquiler/create.php")
    Call<Alquiler> crearAlquiler(@Body Alquiler alquiler);

    @POST("usuario/create.php")
    Call<Usuario> crearUsuario(@Body Usuario usuario);

    @POST("libro/create.php")
    Call<Libro> crearLibro(@Body Libro libro);

    @POST("usuario/delete.php")
    Call<Usuario> borrarUsuario(@Body Usuario usuario);

    @POST("alquiler/delete.php")
    Call<Alquiler> borrarAlquiler(@Body Alquiler alquiler);

    @POST("libro/update.php")
    Call<Libro> modificarEjemplares(@Body Libro libro);



}
