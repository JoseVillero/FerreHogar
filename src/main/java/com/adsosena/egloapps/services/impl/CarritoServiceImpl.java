package com.adsosena.egloapps.services.impl;

import com.adsosena.egloapps.entities.Carrito;
import com.adsosena.egloapps.entities.Producto;
import com.adsosena.egloapps.entities.Pedido;
import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.repositories.CarritoRepository;
import com.adsosena.egloapps.repositories.PedidoRepository;
import com.adsosena.egloapps.repositories.ProductoRepository;
import com.adsosena.egloapps.services.CarritoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Override
    public Carrito crearCarrito(Usuario usuario) {

        Carrito carrito = new Carrito();

        carrito.setId(null);
        carrito.setUsuario(usuario);
        carrito.setListaPedidos(new ArrayList<>());
        return carrito;
    }

    @Override
    public List<Pedido> listarPedidos() {
        return usuarioService.getUsuarioActual().getCarrito().getListaPedidos();
    }

    @Override
    public void guardarPedido(int idProducto, int cantidad, Long idCarrito) {

        Producto producto = productoRepository.findById(idProducto).get();
        Carrito carrito = carritoRepository.findById(idCarrito).get();

        Pedido pedido = new Pedido(null, carrito, producto, cantidad);

        pedidoRepository.save(pedido);

    }

    @Override
    public void borrarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Transactional
    public void actualizarPedido(Long id, int cantidad){
        pedidoRepository.updateCantidad(id, cantidad);
    }

}
