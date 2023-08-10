package com.adsosena.egloapps.controllers;


import com.adsosena.egloapps.constants.ConstantesVistas;
import com.adsosena.egloapps.entities.Pedido;
import com.adsosena.egloapps.services.impl.CarritoServiceImpl;
import com.adsosena.egloapps.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class CarritoController {

    @Autowired
    private CarritoServiceImpl carritoService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/carrito/agregar-pedido")
    public String agregarPedido(@RequestParam(name = "idProducto") int idProducto,
                                @RequestParam(name = "cantidad") int cantidad,
                                @RequestParam(name = "busqueda", required = false) String busqueda){
        Long idCarrito = usuarioService.getUsuarioActual().getCarrito().getId();
        if(busqueda.isBlank()){
            guardarPedido(idProducto, cantidad, idCarrito);
            return "redirect:/catalogo";
        }
        guardarPedido(idProducto, cantidad, idCarrito);
        return "redirect:/buscar-producto?busqueda=" + busqueda;
    }
    private void guardarPedido(int idProducto, int cantidad, Long idCarrito){
        carritoService.guardarPedido(idProducto, cantidad, idCarrito);
    }

    @GetMapping("/carrito")
    public String mostrarCarrito(Model model){
        List<Pedido> pedidoList = carritoService.listarPedidos();

        model.addAttribute("usuario", usuarioService.getUsuarioActual().getNombreCompleto());
        model.addAttribute("pedidos", pedidoList);
        model.addAttribute("totalApagar", totalAPagar(pedidoList));
        model.addAttribute("cantidadEditada", 0);
        return ConstantesVistas.CARRITO_VISTA;
    }

    @PostMapping("/carrito/eliminar-pedido")
    public String eliminarPedido(@RequestParam(name = "id") Long id){
        carritoService.borrarPedido(id);
        return "redirect:/carrito";
    }

    @PostMapping("/carrito/actualizar-pedido")
    public String actualizarCantidadPedido(@RequestParam(name = "cantidad") int cantidad, @RequestParam(name = "idPedido") Long id){

        carritoService.actualizarPedido(id,cantidad);
        return "redirect:/carrito";
    }

    private double totalAPagar(List<Pedido> pedidoList){
        double total = 0;
        for(Pedido pedido: pedidoList){
            total += pedido.getCantidad() * pedido.getProducto().getPrecio();
        }
        return total;
    }
}



