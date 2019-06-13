package com.example.biblioapp.Servidor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class BaseRetrofit{

        private static Retrofit retrofit = null;

        public static Retrofit getBibliotecaRetrofit(String baseUrl) {
            if (retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
    }

