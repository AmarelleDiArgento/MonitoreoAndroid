package com.lotus.monitoreoandroid.Configuracion.Utiles;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.lotus.monitoreoandroid.R;

import java.util.ArrayList;


public abstract class ActivityTools extends AppCompatActivity {

    //final String path = getExternalFilesDir(null) + File.separator;

    public Toast Tostada(String mjs) {
        return Toast.makeText(this, mjs, Toast.LENGTH_LONG);
    }


    public FragmentTransaction fs(int rl, Fragment f) {

        FragmentManager FragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = FragmentManager.beginTransaction();
        fragmentTransaction.add(rl, f, null);
        return fragmentTransaction;

    }

    public SharedPreferences sp() {
        return getBaseContext().getSharedPreferences("share", MODE_PRIVATE);
    }

    //CREACION DE LA TABLA
    public void createTable(Context context, TableDinamic tb, TableLayout tableLayout, String[] header, ArrayList<String[]> data, String ColorHead, String ColorGrid1, String ColorGrid2) throws Exception {
        String[] tipos = {"Numero","Numero","Texto"};
        tb = new TableDinamic(tableLayout, context, tipos);
        tableLayout.removeAllViews();
        tb.addHeader(header);
        tb.addData(data);
        tb.backgroundHeader(
                Color.parseColor(ColorHead)
        );
        tb.backgroundData(
                Color.parseColor(ColorGrid1),
                Color.parseColor(ColorGrid2)
        );
    }

}
