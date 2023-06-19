package com.adsosena.egloapps.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**Clase ProductoModel:
 * Esta clase representa un modelo de una entidad(tabla) de la base de datos.
 * Un modelo es un objeto intermedio que puede representar un objeto de la entidad. Ya sea para convertirse
 * en la entidad o ya esta convertido de una entidad
 * @author Jose David */
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
