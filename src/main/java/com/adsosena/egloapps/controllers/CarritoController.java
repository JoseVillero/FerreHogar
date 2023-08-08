package com.adsosena.egloapps.controllers;


import com.adsosena.egloapps.constants.ConstantesVistas;
import com.adsosena.egloapps.services.impl.CarritoServiceImpl;
import com.adsosena.egloapps.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
        model.addAttribute("usuario", usuarioService.getUsuarioActual().getNombreCompleto());
        model.addAttribute("pedidos", carritoService.listarPedidos());
        return ConstantesVistas.CARRITO_VISTA;
    }
}



