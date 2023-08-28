package com.adsosena.egloapps.components.converters;

import com.adsosena.egloapps.entities.Operacion;
import com.adsosena.egloapps.entities.Producto;
import com.adsosena.egloapps.entities.Transaccion;
import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.models.TarjetaCredito;

import java.sql.Timestamp;


public class TransaccionConverter {

    private final String ENTRADA = "NO APLICA";

    public Transaccion transaccionAgregarProducto(Producto producto, Usuario usuario){

        Transaccion transaccion = new Transaccion();

        transaccion.setProducto(producto);
        transaccion.setUsuario(usuario);
        transaccion.setCantidad(producto.getCantidadDisponible());
        transaccion.setTipoDeOperacion(Operacion.ENTRADA);
        transaccion.setMetodoDePago(ENTRADA);
        transaccion.setFechaDeRealizacion(new Timestamp(System.currentTimeMillis()));

        return transaccion;
    }

    public Transaccion transaccionVenderProducto(Producto producto, Usuario usuario, int cantidad, TarjetaCredito tarjetaCredito){

        Transaccion transaccion = new Transaccion();

        transaccion.setProducto(producto);
        transaccion.setUsuario(usuario);
        transaccion.setCantidad(cantidad);
        transaccion.setTipoDeOperacion(Operacion.VENTA);
        transaccion.setMetodoDePago(tarjetaCredito.metodoDePago().toUpperCase());
        transaccion.setTotal(cantidad * producto.getPrecio());
        transaccion.setFechaDeRealizacion(new Timestamp(System.currentTimeMillis()));

        return transaccion;

    }

}
