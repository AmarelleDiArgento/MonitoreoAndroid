package com.lotus.monitoreoandroid.Modelo.Tabla;

import java.io.Serializable;

public class Postcosechas implements Serializable {
    private long id_posco;
    private long id_finca;
    private String codigo_posco;
    private String nombre_posco;

    public Postcosechas() {
    }

    public long getId_posco() {
        return id_posco;
    }

    public void setId_posco(long id_posco) {
        this.id_posco = id_posco;
    }

    public long getId_finca() {
        return id_finca;
    }

    public void setId_finca(long id_finca) {
        this.id_finca = id_finca;
    }

    public String getCodigo_posco() {
        return codigo_posco;
    }

    public void setCodigo_posco(String codigo_posco) {
        this.codigo_posco = codigo_posco;
    }

    public String getNombre_posco() {
        return nombre_posco;
    }

    public void setNombre_posco(String nombre_posco) {
        this.nombre_posco = nombre_posco;
    }


    @Override
    public String toString() {
        return "{" +
                "\"id_posco\":" + id_posco + ",\n" +
                "\"id_finca\":" + id_finca + ",\n" +
                "\"codigo_posco\": \"" + codigo_posco + "\",\n" +
                "\"nombre_posco\": \"" + nombre_posco + "\"\n" +
                "}";
    }
}
