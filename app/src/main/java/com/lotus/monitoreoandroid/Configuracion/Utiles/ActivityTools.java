package com.lotus.monitoreoandroid.Configuracion.Utiles;

import android.content.Context;
import android.widget.Toast;

public abstract class ActivityTools {
    private Context context;

    public ActivityTools(Context context) {
        this.context = context;
    }

    Toast tostada(String mjs) {
        return Toast.makeText(context, mjs, Toast.LENGTH_LONG);
    }


}
