package com.lotus.monitoreoandroid.Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lotus.monitoreoandroid.Configuracion.Utiles.FileAdmin;
import com.lotus.monitoreoandroid.Modelo.Interfaz.Postcosecha;
import com.lotus.monitoreoandroid.Modelo.Tabla.Postcosechas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class iPostcosecha extends FileAdmin implements Postcosecha {
    public List<Postcosechas> pl = new ArrayList<>();
    private Connection cn = null;
    private String path = "";

    final String nombre = "Postcosecha";

    final String ins = "";
    final String upd = "";
    final String del = "";
    final String one = "";
    final String all = "SELECT [id_posco]\n" +
            "      ,[id_finca]\n" +
            "      ,[codigo_posco]\n" +
            "      ,[nombre_posco]\n" +
            "  FROM [Monitoreo].[dbo].[Poscosechas];";

    public iPostcosecha(Connection cn, String path) {
        this.cn = cn;
        this.path = path;
    }

    @Override
    public String insert(Postcosechas o) throws Exception {
        return null;
    }

    @Override
    public String update(Postcosechas o) throws Exception {
        return null;
    }

    @Override
    public String delete(Long id) throws Exception {
        return null;
    }

    @Override
    public Postcosechas gift(ResultSet rs) throws Exception {
        Postcosechas p = new Postcosechas();
        p.setId_posco(rs.getLong("Id_posco"));
        p.setId_finca(rs.getLong("Id_finca"));
        p.setCodigo_posco(rs.getString("Codigo_posco"));
        p.setNombre_posco(rs.getString("Nombre_posco"));
        return p;
    }

    @Override
    public Postcosechas oneId(Long id) throws Exception {
        return null;
    }

    @Override
    public boolean local() throws Exception {

        List<Postcosechas> po = new ArrayList<>();

        ResultSet rs;
        PreparedStatement ps = cn.prepareStatement(all);

        rs = ps.executeQuery();
        while (rs.next()) {
            po.add(gift(rs));
        }

        String contenido = po.toString();

        return CrearArchivo(path, nombre, contenido);
    }

    @Override
    public List<Postcosechas> all() throws Exception {

        Gson gson = new Gson();
        pl = gson.fromJson(ObtenerLista(path, nombre), new TypeToken<List<Postcosechas>>() {
        }.getType());

        return pl;
    }
}
