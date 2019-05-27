package com.example.biblioapp.Pojo;

public class Libro {

    String isbn;
    String titulo;
    String autor;
    String editorial;
    String genero;
    String Nejemplares;

    public Libro(String isbn, String titulo, String autor, String editorial, String genero, String nejemplares) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.Nejemplares = nejemplares;
    }

    public String getIsbn() {
        return isbn;
    }

    public String setIsbn(String isbn) {
        this.isbn = isbn;
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String setTitulo(String titulo) {
        this.titulo = titulo;
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String setAutor(String autor) {
        this.autor = autor;
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String setEditorial(String editorial) {
        this.editorial = editorial;
        return editorial;
    }

    public String getGenero() {
        return genero;
    }

    public String setGenero(String genero) {
        this.genero = genero;
        return genero;
    }

    public String getNejemplares() {
        return Nejemplares;
    }

    public String setNejemplares(String nejemplares) {
        Nejemplares = nejemplares;
        return nejemplares;
    }
}
