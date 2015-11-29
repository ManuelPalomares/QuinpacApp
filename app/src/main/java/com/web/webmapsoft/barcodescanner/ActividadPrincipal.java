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
    private Button btnActTara;
    private Button btnActCodigo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        btnLlenado = (Button) findViewById(R.id.x_llenado);
        btnActTara = (Button) findViewById(R.id.x_acttara);
        btnActCodigo =(Button) findViewById(R.id.x_actcodigo);
        btnLlenado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirFormaLLenado();

            }
        });
        btnActTara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFormaActTara();
            }
        });
        btnActCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFormaActualizaCodigo();
            }
        });

    }

    public void abrirFormaLLenado(){
        Intent intent = new Intent(this,ActividadLlenado.class);
        startActivity(intent);

    }

    public void abrirFormaActTara(){
        Intent intent = new Intent(this,ActividadActualizarTara.class);
        startActivity(intent);
    }

    public void abrirFormaActualizaCodigo(){
        Intent intent = new Intent(this,ActividadActualizarCodigoBar.class);
        startActivity(intent);
    }


}
