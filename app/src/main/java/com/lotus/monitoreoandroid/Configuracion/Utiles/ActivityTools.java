package com.lotus.monitoreoandroid.Configuracion.Utiles;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public abstract class ActivityTools extends AppCompatActivity {

    public ActivityTools() {

    }

    public Toast Tostada(String mjs) {
        return Toast.makeText(this, mjs, Toast.LENGTH_LONG);
    }




}
