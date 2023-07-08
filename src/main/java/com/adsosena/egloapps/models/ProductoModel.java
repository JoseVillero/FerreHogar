package com.adsosena.egloapps.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**Clase ProductoModel:
 * Esta clase representa un modelo de una entidad(tabla) de la base de datos.
 * Un modelo es un objeto intermedio que puede representar un objeto de la entidad. Ya sea para convertirse
 * en la entidad o ya está convertido de una entidad
 * @author Jose David */
@Getter
@AllArgsConstructor
public class ProductoModel {

    private int id;

    private int codigo;

    private String referencia;

    private String nombre;

    private String marca;

    private double precio;

    private String descripcion;

    private String imagen;

    private int cantidadDisponible;

    private List<TransaccionModel> transacciones;

    public ProductoModel() {
        this.transacciones = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(int codigo) {
        if(codigo > 100){
            this.codigo = codigo;
        }
    }

    public void setReferencia(String referencia) {
        if(referencia != null && !referencia.isBlank()){
            this.referencia = referencia;
        }
    }

    public void setNombre(String nombre) {
        if(nombre != null && !nombre.isBlank()){
            this.nombre = nombre;
        }
    }

    public void setMarca(String marca) {
        if(marca != null && !marca.isBlank()){
            this.marca = marca;
        }
    }

    public void setPrecio(double precio) {
        if(precio > 0){
            this.precio = precio;
        }
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(String imagen) {
        if(imagen != null && !imagen.isBlank()){
            this.imagen = imagen;
        }
    }

    public void setCantidadDisponible(int cantidad){
        if(cantidad >= 0){
            this.cantidadDisponible = cantidad;
        }
    }

    public void setTransacciones(List<TransaccionModel> transacciones) {
        this.transacciones = transacciones;
    }

    @Override
    public String toString() {
        return "ProductoModel{" +
                "id=" + id +
                ", codigo=" + codigo +
                ", referencia='" + referencia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                ", transacciones=" + transacciones +
                '}';
    }
}
