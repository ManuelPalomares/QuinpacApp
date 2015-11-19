package com.web.webmapsoft.barcodescanner.model;

import java.util.Date;

/**
 * Created by mpalomar on 19/11/2015.
 */
public class Recipiente {
    private String serie;
    private String taraReal;
    private String taraImpresa;
    private String capacidadCloro;
    private Date   fechaHidroStatica;
    private Date   fechaPrueba;
    private String codigoBarras;

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTaraReal() {
        return taraReal;
    }

    public void setTaraReal(String taraReal) {
        this.taraReal = taraReal;
    }

    public String getTaraImpresa() {
        return taraImpresa;
    }

    public void setTaraImpresa(String taraImpresa) {
        this.taraImpresa = taraImpresa;
    }

    public String getCapacidadCloro() {
        return capacidadCloro;
    }

    public void setCapacidadCloro(String capacidadCloro) {
        this.capacidadCloro = capacidadCloro;
    }

    public Date getFechaHidroStatica() {
        return fechaHidroStatica;
    }

    public void setFechaHidroStatica(Date fechaHidroStatica) {
        this.fechaHidroStatica = fechaHidroStatica;
    }

    public Date getFechaPrueba() {
        return fechaPrueba;
    }

    public void setFechaPrueba(Date fechaPrueba) {
        this.fechaPrueba = fechaPrueba;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
}
