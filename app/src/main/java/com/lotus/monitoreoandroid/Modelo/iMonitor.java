package com.lotus.monitoreoandroid.Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lotus.monitoreoandroid.Configuracion.Conexiones.sqlConect;
import com.lotus.monitoreoandroid.Modelo.Interfaz.Monitores;
import com.lotus.monitoreoandroid.Modelo.Tabla.Monitor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class iMonitor extends sqlConect implements Monitores {


    public List<Monitor> ml = new ArrayList<>();
    Connection cn = null;
    public String path = "";

    final String nombre = "Monitores";

    final String ins = "";
    final String upd = "";
    final String del = "";
    final String one = "";
    final String all = "SELECT [Id_Monitor]\n" +
            "      ,[Codigo_monitor]\n" +
            "      ,[Nombre_monitor]\n" +
            "  FROM [Monitoreo].[dbo].[Monitores];";

    public iMonitor(String path) throws Exception{
        this.cn = getConexion();
        getPath(path);
    }

    @Override
    public void getPath(String path) {
        this.path = path;
    }

    @Override
    public String insert(Monitor o) throws Exception {
        return null;
    }

    @Override
    public String update(Monitor o) throws Exception {
        return null;
    }

    @Override
    public String delete(Long id) throws Exception {
        return null;
    }

    @Override
    public Monitor gift(ResultSet rs) throws Exception {
        Monitor m = new Monitor();
        m.setId_Monitor(rs.getLong("Id_Monitor"));
        m.setCodigo_monitor(rs.getString("Codigo_monitor"));
        m.setNombre_monitor(rs.getString("Nombre_monitor"));
        return m;
    }

    @Override
    public Monitor oneId(Long id) throws Exception {
        return null;
    }

    @Override
    public boolean local() throws Exception {

        List<Monitor> mo = new ArrayList<>();

        ResultSet rs;
        PreparedStatement ps = cn.prepareStatement(all);
        rs = ps.executeQuery();
        while (rs.next()) {
            mo.add(gift(rs));
        }

        closeConexion(cn, rs);
        String contenido = mo.toString();

        return CrearArchivo(path, nombre, contenido);
    }

    @Override
    public List<Monitor> all() throws Exception {

        Gson gson = new Gson();
        ml = gson.fromJson(ObtenerLista(path, nombre), new TypeToken<List<Monitor>>() {
        }.getType());

        return ml;
    }
}
