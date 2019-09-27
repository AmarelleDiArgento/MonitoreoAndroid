package com.lotus.monitoreoandroid.Configuracion.Utiles;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.io.File;

public abstract class ActivityTools extends AppCompatActivity {


    public Toast Tostada(String mjs) {
        return Toast.makeText(this, mjs, Toast.LENGTH_LONG);
    }


    public FragmentTransaction fs(int rl, Fragment f) {

        FragmentManager FragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = FragmentManager.beginTransaction();
        fragmentTransaction.add(rl, f, null);
        return fragmentTransaction;
    }

}
