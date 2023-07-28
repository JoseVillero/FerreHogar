package com.adsosena.egloapps.services.impl;

import com.adsosena.egloapps.entities.Carrito;
import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.services.CarritoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Override
    public Carrito crearCarrito(Usuario usuario) {

        Carrito carrito = new Carrito();

        carrito.setId(null);
        carrito.setUsuario(usuario);
        carrito.setListaPedidos(new ArrayList<>());
        return carrito;
    }

}
