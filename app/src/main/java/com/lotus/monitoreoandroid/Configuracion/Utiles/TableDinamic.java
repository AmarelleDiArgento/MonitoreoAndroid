package com.lotus.monitoreoandroid.Configuracion.Utiles;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TableDinamic {    private TableLayout tableLayout;
    private Context context;
    private String[] header;
    private ArrayList<String[]> data;
    private TableRow tableRow;
    private TextView txtCell;
    private EditText editCell;
    private int r, c;
    private int idtabla, firt, second;
    private int[] tipo;
    private boolean multicolor;

    public TableDinamic(TableLayout tableLayout, Context context, String[] tipo) {
        this.tableLayout = tableLayout;
        this.context = context;
        this.tipo = getType(tipo);
    }

    public void addHeader(String[] header) {
        this.header = header;
        createHeader();
    }

    public void addData(ArrayList<String[]> data) {
        this.data = data;
        createDataTable();
    }

    private void newRow() {
        tableRow = new TableRow(context);
    }

    private void newCell() {
        txtCell = new TextView(context);
        txtCell.setGravity(Gravity.CENTER);
        txtCell.setTextColor(Color.BLACK);
        txtCell.setTextSize(20);
        txtCell.setHeight(50);
    }

    private void newCell(int tipo) {
        editCell = new EditText(context);
        editCell.setInputType(tipo);
        editCell.setGravity(Gravity.CENTER);
        editCell.setTextColor(Color.BLACK);
        editCell.setTextSize(20);
        editCell.setHeight(50);
    }

    // final ColorDrawable clr = (ColorDrawable) view.getBackground();

    private int[] getType(String[] type) {
        int[] ty = new int[type.length];
        for (int i = 0; i >= type.length; i++) {
            ty[i] = convertir(type[i]);
        }
        return ty;
    }

    private int convertir(String tipo) {
        switch (tipo) {
            case "Numero":
                return InputType.TYPE_CLASS_NUMBER;
            case "Texto":
                return InputType.TYPE_CLASS_TEXT;
            case "Multilinea":
                return InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE;
            default:
                return InputType.TYPE_NULL;
        }
    }




    private TableRow.LayoutParams newLayoutParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        // params.setMargins(1, 1, 1, 1);
        params.weight = 1;
        return params;
    }

    private void createHeader() {
        c = 0;
        newRow();
        while (c < header.length) {
            newCell();
            txtCell.setText(header[c++]);
            tableRow.addView(txtCell, newLayoutParams());
        }
        tableLayout.addView(tableRow);
    }

    private void createDataTable() {
        String info;

        for (r = 1; r <= data.size(); r++) {
            newRow();
            for (c = 0; c < header.length; c++) {
                newCell();
                final String[] colums = data.get(r - 1);
                info = (c < colums.length) ? colums[c] : "";
                txtCell.setText(info);
                tableRow.addView(txtCell, newLayoutParams());
                tableRow.setId(r);
                //txtCell.setBackgroundColor((multicolor) ? firt : second);
                try {
                    tableRow.clearDisappearingChildren();
                    tableRow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(final View view) {
                            int id = view.getId();
                            setIdTabla(id);
                            Toast.makeText(context,"click "+id,Toast.LENGTH_SHORT).show();
                            view.setBackgroundColor(Color.parseColor("#FCC9D6"));
                            int dur = 1000;
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    view.setBackgroundColor(Color.WHITE);
                                }
                            },dur);
                        }
                    });
                } catch (Exception E) {
                    Toast.makeText(context, "Error \n" + E.toString(), Toast.LENGTH_SHORT).show();
                }


            }
            tableRow.clearFocus();
            tableLayout.addView(tableRow);
        }
    }


    public void backgroundHeader(int head) {
        c = 0;
        while (c < header.length) {
            txtCell = getCell(0, c++);
            txtCell.setBackgroundColor(head);
        }
    }


    public void backgroundData(int firt, int second) {
        //for (r = 1; r <= data.size(); r++) {
        //    multicolor = !multicolor;
        //    for (c = 0; c < Header.length; c++) {
        //        txtCell = getCell(r, c);
        //        txtCell.setBackgroundColor((multicolor) ? firt : second);
        //    }
        //}
        //this.firt = firt;
        //this.second = second;
    }



    private TableRow getRow(int index) {

        return (TableRow) tableLayout.getChildAt(index);
    }

    private TextView getCell(int fil, int col) {
        tableRow = getRow(fil);
        return (TextView) tableRow.getChildAt(col);
    }

    public void setIdTabla(int idTabla) {
        this.idtabla = idTabla;
    }

    public int getIdTabla() {
        return this.idtabla;
    }


}
