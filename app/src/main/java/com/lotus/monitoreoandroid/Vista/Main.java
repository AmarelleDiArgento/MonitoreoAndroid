package com.lotus.monitoreoandroid.Vista;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.lotus.monitoreoandroid.Configuracion.DAO.Admin;
import com.lotus.monitoreoandroid.Configuracion.Utiles.ActivityTools;
import com.lotus.monitoreoandroid.Configuracion.Utiles.TableDinamic;
import com.lotus.monitoreoandroid.Modelo.Interfaz.Postcosecha;
import com.lotus.monitoreoandroid.Modelo.Tabla.Monitores;
import com.lotus.monitoreoandroid.Modelo.Tabla.Postcosechas;
import com.lotus.monitoreoandroid.R;
import com.lotus.monitoreoandroid.Vista.Fragmentos.Header;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main extends ActivityTools {
    SharedPreferences sp = null;
    public String path = null;
    List<Monitores> ml = new ArrayList<>();
    private TableLayout tableLayout;
    // Encabezados de la tabla
    private String[] header = {"ID", "Codigo", "Nombre"};
    TableDinamic tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
        path = getExternalFilesDir(null) + File.separator;
        Header h = new Header();
        fs(R.id.header, h).commit();
        // createTable();
        try {
            tableLayout = (TableLayout) findViewById(R.id.tabla);
            createTable(
                    getApplicationContext(),
                    tb,
                    tableLayout,
                    header,
                    cargarMonitores(),
                    "#00B6FF",
                    "#FFFFFF",
                    "#BEC0C7"
            );
        } catch (Exception e) {
            Tostada("Error en tabla: " + e).show();
        }
    }


    public ArrayList<String[]> cargarMonitores() {

        final ArrayList<String[]> rows = new ArrayList<>();

        try {
            rows.clear();
            final Admin aSql = new Admin(path);

            aSql.getPostcosecha().local();
            Tostada("Cargo local").show();

            final List<Postcosechas> pl = aSql.getPostcosecha().all();
            for (final Postcosechas p : pl) {
                rows.add(new String[]{
                                String.valueOf(p.getCodigo_posco()),
                                p.getCodigo_posco(),
                                p.getNombre_posco(),
                        }
                );
            }
        } catch (Exception e) {
            Tostada("Error cargar monitores : " + e).show();
        }
        return rows;
    }
}
