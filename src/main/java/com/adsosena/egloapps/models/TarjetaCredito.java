package com.adsosena.egloapps.models;

public class TarjetaCredito implements MetodoDePago{

    private FranquiciaTC franquicia;

    private String numero;

    private  String NombreCompleto;

    private  String direccion;

    private  String Telefono;

    private  double monto;


    @Override
    public double obtenerSaldo() {
        return monto;
    }

    @Override
    public String metodoDePago() {
        return getClass().getSimpleName();
    }
}
