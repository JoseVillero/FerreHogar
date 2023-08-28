package com.adsosena.egloapps.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TarjetaCredito implements MetodoDePago{

    private FranquiciaTC franquicia;

    private String numero;

    @JsonProperty("nombre")
    private  String NombreCompleto;

    private  String direccion;

    private String pais;

    private  double monto;

    @JsonProperty("CVV")
    private int CVV;

    private String expiracion;


    @Override
    public double obtenerSaldo() {
        return monto;
    }

    @Override
    public String metodoDePago() {
        return getClass().getSimpleName();
    }

    public void franquicia(String franquicia){
        setFranquicia(FranquiciaTC.valueOf(franquicia));
    }
}
