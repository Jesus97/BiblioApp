package com.example.biblioapp.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Usuario implements Serializable {

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

    public Usuario(){}

    public Usuario(String dni, String nombre, String apellidos, String telefono, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

