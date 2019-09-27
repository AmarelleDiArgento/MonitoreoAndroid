package com.lotus.monitoreoandroid.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.lotus.monitoreoandroid.Configuracion.DAO.Admin;
import com.lotus.monitoreoandroid.Configuracion.Utiles.ActivityTools;
import com.lotus.monitoreoandroid.Configuracion.Utiles.TableDinamic;
import com.lotus.monitoreoandroid.Modelo.Tabla.Monitores;
import com.lotus.monitoreoandroid.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActivityTools {
    SharedPreferences sp = null;
    public String path = null;
    List<Monitores> ml = new ArrayList<>();
    private TableLayout tableLayout;
    // Encabezados de la tabla
    private String[] header = {"ID", "Codigo", "Nombre"};
    TableDinamic tb;
    TableRow tr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getBaseContext().getSharedPreferences("share", MODE_PRIVATE);
        path = getExternalFilesDir(null) + File.separator;

        // createTable();
        createTable();

    }

    //CREACION DE LA TABLA
    public void createTable() {
        try {
            tableLayout = findViewById(R.id.tabla);
            tb = new TableDinamic(tableLayout, getApplicationContext());
            tableLayout.removeAllViews();
            tb.addHeader(header);
            tb.addData(cargarMonitores());
            tb.backgroundHeader(
                    Color.parseColor("#20C0FF")
            );
            tb.backgroundData(
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#81F0EDED")
            );


        } catch (Exception e) {
            Tostada("Error de la  table: " + e.toString()).show();
        }
    }

    public ArrayList<String[]> cargarMonitores() {

        final ArrayList<String[]> rows = new ArrayList<>();

        try {
            rows.clear();
            final Admin aSql = new Admin(path) ;

            aSql.getMonitor().local();
            Tostada("Cargo local").show();

            final List<Monitores> ml = aSql.getMonitor().all();
            for (final Monitores m : ml) {
                // {"Finca", "Bloque", "Variedad", "CC", "CT", "S1C", "S1P", "S4C", "S4P

                rows.add(new String[]{
                        String.valueOf(m.getId_Monitor()),
                                m.getCodigo_monitor(),
                                m.getNombre_monitor(),
                        }
                );
            }
        } catch (Exception e) {
            Tostada("Error cargar monitores : " + e).show();
        }
        return rows;
    }
}
