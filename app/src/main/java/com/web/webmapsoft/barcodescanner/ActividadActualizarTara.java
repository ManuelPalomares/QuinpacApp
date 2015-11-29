package com.web.webmapsoft.barcodescanner;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.web.webmapsoft.barcodescanner.model.Recipiente;
import com.web.webmapsoft.barcodescanner.negocio.ConsultasWs;

import java.text.SimpleDateFormat;

/**
 * Created by mpalomar on 21/11/2015.
 */
public class ActividadActualizarTara extends Activity {


    private EditText etNumeroSerie; //x_numserie
    private EditText etTipo; //x_tarareal
    private EditText etCapacidadCloro; //x_capacidadCloro
    private EditText etTaraImpresa; //x_taraImpresa
    private EditText etTaraReal; //x_tarareal
    private EditText etTaraNueva; //x_taranueva
    private EditText etCodigoCapturado; //x_codigobarrascapturado
    private Button  btCodigoBarras;

    private Recipiente recipiente;
    private ImageView imRecipiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actualizar_tara);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        etNumeroSerie = (EditText) findViewById(R.id.x_numserie);
        etTipo        = (EditText) findViewById(R.id.x_tipoRecipiente);
        etCapacidadCloro = (EditText) findViewById(R.id.x_capacidadCloro);
        etTaraImpresa = (EditText) findViewById(R.id.x_taraImpresa);
        etTaraReal = (EditText) findViewById(R.id.x_tarareal);
        etTaraNueva   = (EditText) findViewById(R.id.x_taranueva);
        btCodigoBarras = (Button) findViewById(R.id.x_codigobarras);
        etCodigoCapturado =(EditText) findViewById(R.id.x_codigobarrascapturado);
        imRecipiente = (ImageView) findViewById(R.id.x_imagenrecipien);

        btCodigoBarras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamarActividadCamara();
            }
        });
    }

    public void llamarActividadCamara() {
        IntentIntegrator scanItegraIntegrator = new IntentIntegrator(this);
        scanItegraIntegrator.initiateScan();

        // launch barcode activity.
        /*Intent intent = new Intent(this, BarcodeCaptureActivity.class);

        intent.putExtra(BarcodeCaptureActivity.AutoFocus, false);
        intent.putExtra(BarcodeCaptureActivity.UseFlash, false);

        startActivityForResult(intent, RC_BARCODE_CAPTURE);
*/

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanningResult != null) {
//we have a result

            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            if (scanContent != null) {
                etCodigoCapturado.setText(scanContent.toString());
                traerRecipienteWsCodigoBarra(scanContent.toString());

            }
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

    private void traerRecipienteWsCodigoBarra(String codigoBarra) {
        ConsultasWs consultasWs = new ConsultasWs();
        this.recipiente = consultasWs.traerRecipientexCodigoBarra(codigoBarra);
        etNumeroSerie.setText(recipiente.getSerie());
        etCapacidadCloro.setText(recipiente.getCapacidadCloro());
        etTaraImpresa.setText(recipiente.getTaraImpresa());
        etTaraReal.setText(recipiente.getTaraReal());
        if(recipiente.getTipoRecipiente().equals("T")){
            etTipo.setText("Tambor");
            Drawable resTambor = getResources().getDrawable(R.drawable.tambor);
            imRecipiente.setBackground(resTambor);
        }
        if(recipiente.getTipoRecipiente().equals("C")) {
            etTipo.setText("Cilindro");
            Drawable resCilindro = getResources().getDrawable(R.drawable.cilindro);
            imRecipiente.setBackground(resCilindro);
        }

    }


}
