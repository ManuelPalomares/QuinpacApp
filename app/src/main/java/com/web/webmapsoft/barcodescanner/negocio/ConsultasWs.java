package com.web.webmapsoft.barcodescanner.negocio;

import com.web.webmapsoft.barcodescanner.model.Recipiente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mpalomar on 19/11/2015.
 */
public class ConsultasWs {

    public Recipiente traerRecipientexCodigoBarra(String codigoBarra){

        System.out.println(codigoBarra);

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
        System.out.println(date);

        recipiente.setFechaHidroStatica(date);

        return recipiente;
    }
}
