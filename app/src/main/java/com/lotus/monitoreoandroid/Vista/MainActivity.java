package com.lotus.monitoreoandroid.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.lotus.monitoreoandroid.Configuracion.Utiles.ActivityTools;
import com.lotus.monitoreoandroid.Configuracion.Utiles.TableDinamic;
import com.lotus.monitoreoandroid.Modelo.Tabla.Monitor;
import com.lotus.monitoreoandroid.Modelo.iMonitor;
import com.lotus.monitoreoandroid.R;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp = null;
    public String path = null;
    List<Monitor> ml = new ArrayList<>();
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
            Toast.makeText(this, "Error de la  table: " + e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public ArrayList<String[]> cargarMonitores() {

        final ArrayList<String[]> rows = new ArrayList<>();

        try {
            rows.clear();
            final iMonitor iM = new iMonitor(path);

            Toast.makeText(this, "Conectado: " + iM.getConexion(), Toast.LENGTH_LONG).show();
            iM.local();
            Toast.makeText(this, "Cargo local", Toast.LENGTH_LONG).show();

            final List<Monitor> ml = iM.all();
            for (final Monitor m : ml) {
                // {"Finca", "Bloque", "Variedad", "CC", "CT", "S1C", "S1P", "S4C", "S4P

                rows.add(new String[]{
                        String.valueOf(m.getId_Monitor()),
                                m.getCodigo_monitor(),
                                m.getNombre_monitor(),
                        }
                );
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error cargar monitores : " + e, Toast.LENGTH_LONG).show();
        }
        return rows;
    }
}
