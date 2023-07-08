package com.adsosena.egloapps.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PedidoModel {

    private Long id;

    private CarritoModel carritoModel;

    private ProductoModel productoModel;

    private int cantidad;

    public void setCantidad(int cantidad) {
        if (cantidad > 0){
            this.cantidad = cantidad;
        }
    }
}
