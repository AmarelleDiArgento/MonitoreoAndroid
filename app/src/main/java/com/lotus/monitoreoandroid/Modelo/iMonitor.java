package com.lotus.monitoreoandroid.Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lotus.monitoreoandroid.Configuracion.Conexiones.sqlConect;
import com.lotus.monitoreoandroid.Configuracion.Utiles.ActivityTools;
import com.lotus.monitoreoandroid.Configuracion.Utiles.FileAdmin;
import com.lotus.monitoreoandroid.Modelo.Interfaz.Monitor;
import com.lotus.monitoreoandroid.Modelo.Tabla.Monitores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class iMonitor extends FileAdmin implements Monitor {


    public List<Monitores> ml = new ArrayList<>();
    Connection cn = null;
    public String path = "";

    final String nombre = "Monitor";

    final String ins = "";
    final String upd = "";
    final String del = "";
    final String one = "";
    final String all = "SELECT [Id_Monitor]\n" +
            "      ,[Codigo_monitor]\n" +
            "      ,[Nombre_monitor]\n" +
            "  FROM [Monitoreo].[dbo].[Monitor];";

    public iMonitor(Connection cn, String path) {
        this.cn = cn;
        this.path = path;
    }

    @Override
    public String insert(Monitores o) throws Exception {
        return null;
    }

    @Override
    public String update(Monitores o) throws Exception {
        return null;
    }

    @Override
    public String delete(Long id) throws Exception {
        return null;
    }

    @Override
    public Monitores gift(ResultSet rs) throws Exception {
        Monitores m = new Monitores();
        m.setId_Monitor(rs.getLong("Id_Monitor"));
        m.setCodigo_monitor(rs.getString("Codigo_monitor"));
        m.setNombre_monitor(rs.getString("Nombre_monitor"));
        return m;
    }

    @Override
    public Monitores oneId(Long id) throws Exception {
        return null;
    }

    @Override
    public boolean local() throws Exception {

        List<Monitores> mo = new ArrayList<>();

        ResultSet rs;
        PreparedStatement ps = cn.prepareStatement(all);
        rs = ps.executeQuery();
        while (rs.next()) {
            mo.add(gift(rs));
        }

        String contenido = mo.toString();

        return CrearArchivo(path, nombre, contenido);
    }

    @Override
    public List<Monitores> all() throws Exception {

        Gson gson = new Gson();
        ml = gson.fromJson(ObtenerLista(path, nombre), new TypeToken<List<Monitores>>() {
        }.getType());

        return ml;
    }
}
