package com.example.biblioapp.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Alquiler implements Serializable {

    @SerializedName("dni")
    @Expose
    private String dni;
    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("fecha_alquiler")
    @Expose
    private String fecha_alquiler;
    @SerializedName("fecha_devolucion")
    @Expose
    private String fecha_devolucion;

    public Alquiler() {
    }

    public Alquiler(String dni, String isbn, String fecha_alquiler, String fecha_devolucion) {
        this.dni = dni;
        this.isbn = isbn;
        this.fecha_alquiler = fecha_alquiler;
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
        return "Alquiler{" +
                "dni='" + dni + '\'' +
                ", isbn='" + isbn + '\'' +
                ", fecha_alquiler='" + fecha_alquiler + '\'' +
                ", fecha_devolucion='" + fecha_devolucion + '\'' +
                '}';
    }
}
