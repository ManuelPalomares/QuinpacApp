package com.web.webmapsoft.barcodescanner;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.Date;

/**
 * Created by mpalomar on 17/11/2015.
 */
public class ActividadLlenado extends Activity {

    private Button bt_camara;
    private static final int RC_BARCODE_CAPTURE = 9001;
    private EditText eCodigoBarras;
    private static final String TAG = "Actividad Llenado";
    private EditText eLote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_llenado);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        bt_camara = (Button) findViewById(R.id.x_codigobarras);
        eCodigoBarras = (EditText) findViewById(R.id.x_codigobarrascapturado);
        eLote = (EditText) findViewById(R.id.x_lote);
        Date fecha = new Date();

        System.out.println(fecha.getMonth() + " " + fecha.getYear() + fecha.getDay());
        StringBuilder lote = new StringBuilder();
        lote.append(fecha.getMonth());
        lote.append(fecha.getYear());
        if(fecha.getDay() > 15){
            lote.append("2");
        }else
        {
            lote.append("1");
        }



        eLote.setText(lote.toString());

        bt_camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamarActividadCamara();
            }
        });

    }

    public void llamarActividadCamara(){
        // launch barcode activity.
        Intent intent = new Intent(this, BarcodeCaptureActivity.class);
        intent.putExtra(BarcodeCaptureActivity.AutoFocus, true);
        intent.putExtra(BarcodeCaptureActivity.UseFlash, false);

        startActivityForResult(intent, RC_BARCODE_CAPTURE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_BARCODE_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                    //statusMessage.setText(R.string.barcode_success);
                    eCodigoBarras.setText(barcode.displayValue);
                    Log.d(TAG, "Barcode read: " + barcode.displayValue);
                } else {
                    //statusMessage.setText(R.string.barcode_failure);
                    Log.d(TAG, "No barcode captured, intent data is null");
                }
            } else {
                Log.d(TAG, String.format(getString(R.string.barcode_error),
                        CommonStatusCodes.getStatusCodeString(resultCode)));

            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
