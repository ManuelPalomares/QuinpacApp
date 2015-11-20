package com.web.webmapsoft.barcodescanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.web.webmapsoft.barcodescanner.model.Recipiente;
import com.web.webmapsoft.barcodescanner.negocio.ConsultasWs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    private Button bRllenado;
    private CheckBox chNumeroSerie;
    private CheckBox chTaraReal;
    private CheckBox chHidros;
    private Recipiente recipiente;

    private EditText eSerie;
    private EditText eTaraReal;
    private EditText ePruebaHidro;
    private EditText eTaraimpresa;
    private EditText eCloro;

    private CheckBox chFlash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_llenado);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        bt_camara = (Button) findViewById(R.id.x_codigobarras);
        eCodigoBarras = (EditText) findViewById(R.id.x_codigobarrascapturado);
        eLote = (EditText) findViewById(R.id.x_lote);
        bRllenado = (Button) findViewById(R.id.x_registrarllenado);
        chNumeroSerie = (CheckBox) findViewById(R.id.x_checknumeroserie);
        chTaraReal = (CheckBox) findViewById(R.id.x_chtarareal);
        chHidros   = (CheckBox) findViewById(R.id.x_chhidro);
        chFlash  = (CheckBox) findViewById(R.id.x_flash);
        //campos
        eSerie =(EditText) findViewById(R.id.x_numserie);
        eTaraReal = (EditText) findViewById(R.id.x_tarareal);
        ePruebaHidro = (EditText) findViewById(R.id.x_pruebahidro);
        eTaraimpresa = (EditText) findViewById(R.id.x_taraimpresa);
        eCloro = (EditText) findViewById(R.id.x_cloro);

        // Create Date object.
        Date date = new Date();
        // Specify the desired date format
        String DATE_FORMAT = "yy/MM/dd";
        // Create object of SimpleDateFormat and pass the desired date format.
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.format(date);
        Calendar c = sdf.getCalendar();
        StringBuilder lote = new StringBuilder();
        lote.append(c.get(Calendar.MONTH)+1);
        String ano = c.get(Calendar.YEAR)+"";
        ano = ano.substring(2);

        lote.append(ano);

        if(c.get(Calendar.DAY_OF_MONTH)+1 > 15){
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

        bRllenado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarLlenado();
            }
        });

    }

    public void llamarActividadCamara(){
        IntentIntegrator scanItegraIntegrator = new IntentIntegrator(this);
        scanItegraIntegrator.initiateScan();

        // launch barcode activity.
        /*Intent intent = new Intent(this, BarcodeCaptureActivity.class);

        intent.putExtra(BarcodeCaptureActivity.AutoFocus, false);
        intent.putExtra(BarcodeCaptureActivity.UseFlash, false);

        startActivityForResult(intent, RC_BARCODE_CAPTURE);
*/

    }

    public void validarLlenado(){
       if(chHidros.isChecked() & chTaraReal.isChecked() & chNumeroSerie.isChecked()){
        //TODO LLAMA WS envia llenado
           System.out.println("Se ejecuta ws");
       }else{
           Context context = getApplicationContext();
           CharSequence text = "No es posible realizar el llenado realize el checkeo de informacion";
           int duration = Toast.LENGTH_SHORT;

           Toast toast = Toast.makeText(context, text, duration);
           toast.show();
       }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanningResult != null) {
//we have a result
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            eCodigoBarras.setText(scanContent.toString());

        }

        /*if (requestCode == RC_BARCODE_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                    //statusMessage.setText(R.string.barcode_success);
                    eCodigoBarras.setText(barcode.displayValue);
                    traerRecipienteWsCodigoBarra(barcode.displayValue.toString());


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
        }*/

    }

    private void traerRecipienteWsCodigoBarra(String codigoBarra){
        ConsultasWs consultasWs = new ConsultasWs();
        this.recipiente= consultasWs.traerRecipientexCodigoBarra(codigoBarra);
        eSerie.setText(recipiente.getSerie());
        eCloro.setText(recipiente.getCapacidadCloro());
        eTaraimpresa.setText(recipiente.getTaraImpresa());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        ePruebaHidro.setText(sdf.format(recipiente.getFechaHidroStatica()));
        eTaraReal.setText(recipiente.getTaraReal());
    }
}
