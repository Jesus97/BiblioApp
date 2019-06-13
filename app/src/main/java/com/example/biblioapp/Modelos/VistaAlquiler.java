package com.example.biblioapp.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VistaAlquiler implements Serializable {

    @SerializedName("dni")
    @Expose
    private String dni;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellidos")
    @Expose
    private String apellidos;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("direccion")
    @Expose
    private String direccion;
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
    @SerializedName("fecha_alquiler")
    @Expose
    private String fecha_alquiler;
    @SerializedName("fecha_devolucion")
    @Expose
    private String fecha_devolucion;

    public VistaAlquiler() {
    }

    public VistaAlquiler(String dni, String nombre, String apellidos, String telefono, String direccion, String isbn, String titulo, String autor, String editorial, String genero, String nejemplares, String fecha_alquiler, String fecha_devolucion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.Nejemplares = nejemplares;
        this.fecha_alquiler = fecha_alquiler;
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getFecha_alquiler() {
        return fecha_alquiler;
    }

    public void setFecha_alquiler(String fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    @Override
    public String toString() {
        return "Vista{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", genero='" + genero + '\'' +
                ", Nejemplares='" + Nejemplares + '\'' +
                ", fecha_alquiler='" + fecha_alquiler + '\'' +
                ", fecha_devolucion='" + fecha_devolucion + '\'' +
                '}';
    }
}

