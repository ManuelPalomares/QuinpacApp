package com.web.webmapsoft.barcodescanner;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by mpalomar on 16/11/15.
 */
public class ActividadPrincipal extends Activity {

    private Button btnLlenado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        btnLlenado = (Button) findViewById(R.id.x_llenado);

        btnLlenado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirFormaLLenado();

            }
        });

    }

    public void abrirFormaLLenado(){
        Intent intent = new Intent(this,ActividadLlenado.class);
    }
}
