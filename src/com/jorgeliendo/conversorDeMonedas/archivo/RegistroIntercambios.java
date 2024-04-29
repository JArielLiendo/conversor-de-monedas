package com.jorgeliendo.conversorDeMonedas.archivo;

public class RegistroIntercambios {
    private String parDeIntercambio;
    private double montoAIntercambiar;
    private double montoRecibido;

    public RegistroIntercambios(String parDeIntercambio, double montoAIntercambiar, double montoRecibido){
        this.parDeIntercambio=parDeIntercambio;
        this.montoAIntercambiar=montoAIntercambiar;
        this.montoRecibido=montoRecibido;
    }

}
