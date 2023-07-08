package com.adsosena.egloapps.models;

import com.adsosena.egloapps.entities.Operacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransaccionModel {

    private Long id;

    private ProductoModel productoModel;

    private UsuarioModel usuarioModel;

    private int cantidad;

    private Operacion tipoDeOperacion;

    private String metodoDePago;

    private double total;

    private Timestamp fechaDeRealizacion;

    public void setCantidad(int cantidad) {
        if(cantidad >= 0) {this.cantidad = cantidad;}
    }

    public void setTotal(double total) {
        if(total >=0) {this.total = total;}
    }

}
