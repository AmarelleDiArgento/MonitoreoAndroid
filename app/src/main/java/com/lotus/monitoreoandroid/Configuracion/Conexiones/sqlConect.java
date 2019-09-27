package com.lotus.monitoreoandroid.Configuracion.Conexiones;

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public abstract class sqlConect {
    String url = "jdbc:jtds:sqlserver://10.50.1.123;instance=Mercedes;databaseName=Monitoreo";
    String user = "Inventarios";
    String pass = "Inventarios2016*";

    /*
    String url = "jdbc:jtds:sqlserver://192.168.0.15:1433;databaseName=Proyecciones";
    String user = "sa";
    String pass = "Arkangel88";
    */

    public Connection getConexion() throws Exception{

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
            //Class.forName("net.sourceforge.jtds.jdbc.Driver");
            return DriverManager.getConnection(url, user, pass);



    }

    public void closeConexion(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }

    public void closeConexion(Connection con, ResultSet rs) throws Exception {
        if (con != null) {
            con.close();
        }
        if (rs != null) {
            rs.close();
        }


    }
    public String ObtenerLista(String path, String nombre) throws Exception {
        String jsonString = "";
        path = path + nombre + ".json";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        jsonString = sb.toString();

        return jsonString;
    }

    public List<String> listFiles(String path) {
        List<String> list = new ArrayList<String>();
        File f = new File(path);

        //obtiene nombres de archivos dentro del directorio.
        File[] file = f.listFiles();
        for (int i = 0; i < file.length; i++) {
            //Agrega nombres de archivos a List para ser agregado a adapter.
            if (!file[i].getName().equalsIgnoreCase("plano.json")) {
                list.add(file[i].getName());
            }
        }
        return list;
    }

    // generador de archivos, requiere dos cadenas de texto nombre de archivo y contenido del mismo
    public boolean CrearArchivo(String path, String nombre, String contenido) {
        boolean ok = false;
        try {
            FileOutputStream fos = null;
            File f = new File(path + nombre + ".json");
            fos = new FileOutputStream(f);
            fos.write(contenido.getBytes());
            fos.close();
            ok = true;
        } catch (Exception e) {
            ok = false;
        }
        return ok;
    }
}
