package com.adsosena.egloapps.services;

import com.adsosena.egloapps.entities.Carrito;
import com.adsosena.egloapps.entities.Pedido;
import com.adsosena.egloapps.entities.Usuario;

import java.util.List;

public interface CarritoService {

    Carrito crearCarrito(Usuario usuario);

    List<Pedido> listarPedidos();

    void guardarPedido(int idProducto, int cantidad, Long idCarrito);

}
