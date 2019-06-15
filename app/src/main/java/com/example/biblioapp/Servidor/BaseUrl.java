package com.example.biblioapp.Servidor;

public class BaseUrl {

    private BaseUrl() {}

    public static final String BASE_URL = "http://192.168.16.219/biblioteca/";

    public static BibliotecaService getBiblioteca() {

        return BaseRetrofit.getBibliotecaRetrofit(BASE_URL).create(BibliotecaService.class);
    }
}