package com.example.biblioapp.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Libro implements Serializable {

    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("titulo")
    @Expose
    private String titulo;
    @SerializedName("autor")
    @Expose
    private String autor;
    @SerializedName("editorial")
    @Expose
    private String editorial;
    @SerializedName("genero")
    @Expose
    private String genero;
    @SerializedName("Nejemplares")
    @Expose
    private String Nejemplares;

    public Libro() {}

    public Libro(String isbn, String titulo, String autor, String editorial, String genero, String nejemplares) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        Nejemplares = nejemplares;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNejemplares() {
        return Nejemplares;
    }

    public void setNejemplares(String nejemplares) {
        Nejemplares = nejemplares;
    }
}
