package com.adsosena.egloapps.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**Clase producto:
 * Esta clase representa una entidad (tabla) en la base de datos.
 * Los atributos son representados como columnas en la base de datos
 * @author Jose David */

@Entity
@Table(name = "productos")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "codigo", nullable = false)
    private int codigo;

    @Column(name = "referencia", nullable = false, length = 30)
    private String referencia;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Column(name = "marca", nullable = false, length = 15)
    private String marca;

    @Column(name = "precio",nullable = false)
    private double precio;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Column(name = "cantidad_disponible", nullable = false)
    private int cantidadDisponible;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Transaccion> transacciones;

}
