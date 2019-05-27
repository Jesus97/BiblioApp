package com.example.biblioapp.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario{

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

    public String setDni(String dni) {
        this.dni = dni;
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String setNombre(String nombre) {
        this.nombre = nombre;
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String setTelefono(String telefono) {
        this.telefono = telefono;
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String setDireccion(String direccion) {
        this.direccion = direccion;
        return direccion;
    }

}
