package com.adsosena.egloapps.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoModel {

    private int id;

    private int codigo;

    private String referencia;

    private String nombre;

    private String marca;

    private double precio;

    private String descripcion;

}
