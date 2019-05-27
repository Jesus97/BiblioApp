package com.example.biblioapp.Pojo;

public class Libro {

    int isbn;
    String titulo;
    String autor;
    String editorial;
    String genero;
    int Nejemplares;

    public Libro(int isbn, String titulo, String autor, String editorial, String genero, int nejemplares) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        Nejemplares = nejemplares;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
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

    public int getNejemplares() {
        return Nejemplares;
    }

    public void setNejemplares(int nejemplares) {
        Nejemplares = nejemplares;
    }
}
