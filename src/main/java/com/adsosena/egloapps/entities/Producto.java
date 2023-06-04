package com.adsosena.egloapps.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @NotNull
    @Column(name = "codigo")
    private int codigo;

    @NotNull
    @Column(name = "referencia")
    private String referencia;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "marca")
    private String marca;

    @NotNull
    @Column(name = "precio")
    private double precio;

    @Column(name = "descripcion")
    private String descripcion;
}
