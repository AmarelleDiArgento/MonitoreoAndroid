package com.lotus.monitoreoandroid.Modelo.Tabla;

import java.io.Serializable;

public class Productos implements Serializable {
    private long Id_producto;
    private String Codigo_prod;
    private String Nombre_prod;

    public Productos() {
    }

    public Productos(long id_producto, String codigo_prod, String nombre_prod) {
        setId_producto(id_producto);
        setCodigo_prod(codigo_prod);
        setNombre_prod(nombre_prod);
    }


    public long getId_producto() {
        return Id_producto;
    }

    public void setId_producto(long id_producto) {
        Id_producto = id_producto;
    }

    public String getCodigo_prod() {
        return Codigo_prod;
    }

    public void setCodigo_prod(String codigo_prod) {
        Codigo_prod = codigo_prod;
    }

    public String getNombre_prod() {
        return Nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        Nombre_prod = nombre_prod;
    }



    @Override
    public String toString() {
        return "{" +
                "\"Id_producto\":" + Id_producto + ",\n" +
                "\"Codigo_prod\": \"" + Codigo_prod + "\",\n" +
                "\"Nombre_prod\": \"" + Nombre_prod + "\"\n" +
                "}";
    }
}
