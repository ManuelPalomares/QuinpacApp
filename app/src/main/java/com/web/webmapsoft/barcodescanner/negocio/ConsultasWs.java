package com.web.webmapsoft.barcodescanner.negocio;

import android.os.AsyncTask;

import com.web.webmapsoft.barcodescanner.model.Recipiente;
import com.web.webmapsoft.clientews.NLIBINDING_SIBTC;
import com.web.webmapsoft.clientews.NLIOperationResult;
import com.web.webmapsoft.clientews.NLIZFmPmRfcWssibtcResponse;
import com.web.webmapsoft.clientews.NLIZstPmDataSibtc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mpalomar on 19/11/2015.
 */
public class ConsultasWs {

    public Recipiente recipiente;
    public String usuario;
    public String clave;
    public String mensaje;
    public String tipoMensaje;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String  consultarByCodigoBarra(String codigo){
        NLIZstPmDataSibtc recipientews = new NLIZstPmDataSibtc();
        recipientews.FchNextPrueba = "2015-01-01";
        recipientews.FchPruHidro   =  "2015-01-01";
        recipientews.CodBarras = codigo;


        NLIBINDING_SIBTC clienteWs = new NLIBINDING_SIBTC();

        try {
            NLIZFmPmRfcWssibtcResponse respuesta ;

            respuesta = clienteWs.ZFmPmRfcWssibtc(recipientews,"CONSULTA",this.usuario,this.clave);

            if(respuesta.EvTipoRespu.equals("W")){

                return respuesta.EvRespuesta;
            }

            if(respuesta.EvTipoRespu.equals("S")){
                recipiente = new Recipiente();
                recipiente.setSerie(respuesta.CsDataSibtc.NumSerie);
                recipiente.setTaraReal(respuesta.CsDataSibtc.TaraReal);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                Date date = null;
                Date date2 =null;
                date = sdf.parse(respuesta.CsDataSibtc.FchPruHidro);
                date2 = sdf.parse(respuesta.CsDataSibtc.FchPruHidro);

                recipiente.setFechaHidroStatica(date);
                recipiente.setFechaPrueba(date2);
                recipiente.setCapacidadCloro(respuesta.CsDataSibtc.CapaCloro);

            }

        } catch (Exception e) {
            return e.getMessage();
        }

        return null;
    }

    public Recipiente traerRecipientexCodigoBarra(String codigoBarra){

        //TODO implementar ws codigo de barra
        Recipiente  recipiente = new Recipiente();
        recipiente.setSerie("12345");
        recipiente.setTaraReal("50");
        recipiente.setTaraImpresa("52");
        recipiente.setCapacidadCloro("60");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = "01/01/2009";
        Date date = null;

        try {
            date = sdf.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        recipiente.setFechaHidroStatica(date);

        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString2 = "01/01/2014";
        Date date2 = null;

        try {
            date2 = sdf2.parse(dateInString2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        recipiente.setFechaPrueba(date2);



        return recipiente;
    }






}
