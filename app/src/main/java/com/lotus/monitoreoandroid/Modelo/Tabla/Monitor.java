package com.lotus.monitoreoandroid.Modelo.Tabla;

import java.io.Serializable;

public class Monitor implements Serializable {
    private Long Id_Monitor;
    private String Codigo_monitor;
    private String Nombre_monitor;

    public Monitor() {
    }

    public Monitor(Long id_Monitor, String codigo_monitor, String nombre_monitor) {
        setId_Monitor(id_Monitor);
        setCodigo_monitor(codigo_monitor);
        setNombre_monitor(nombre_monitor);
    }


    public Long getId_Monitor() {
        return Id_Monitor;
    }

    public void setId_Monitor(Long id_Monitor) {
        Id_Monitor = id_Monitor;
    }

    public String getCodigo_monitor() {
        return Codigo_monitor;
    }

    public void setCodigo_monitor(String codigo_monitor) {
        Codigo_monitor = codigo_monitor;
    }

    public String getNombre_monitor() {
        return Nombre_monitor;
    }

    public void setNombre_monitor(String nombre_monitor) {
        Nombre_monitor = nombre_monitor;
    }

    @Override
    public String toString() {
        return "{" +
                "\"Id_Monitor\":" + Id_Monitor + ",\n" +
                "\"Codigo_monitor\": \"" + Codigo_monitor + "\",\n" +
                "\"Nombre_monitor\": \"" + Nombre_monitor + "\"\n" +
                "}";
    }
}
