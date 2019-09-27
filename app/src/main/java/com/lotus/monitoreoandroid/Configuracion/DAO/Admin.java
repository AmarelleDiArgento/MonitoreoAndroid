package com.lotus.monitoreoandroid.Configuracion.DAO;

import com.lotus.monitoreoandroid.Configuracion.Conexiones.sqlConect;
import com.lotus.monitoreoandroid.Modelo.Interfaz.Monitor;
import com.lotus.monitoreoandroid.Modelo.iMonitor;
import android.content.Context;

import java.sql.Connection;

public class Admin extends sqlConect implements Administrador {
    private String path = null;
    private Connection cn = null;


    public Admin(String path) throws Exception {
        this.path = path;
        this.cn = getConexion();
    }

    Monitor mon = null;

    public Monitor getMonitor() {
        if (mon == null) {
            mon = new iMonitor(cn, path);
        }
        return mon;
    }
}
