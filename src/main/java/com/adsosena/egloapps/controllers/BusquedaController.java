package com.adsosena.egloapps.controllers;


import com.adsosena.egloapps.components.converters.UsuarioConverter;
import com.adsosena.egloapps.constants.ConstantesVistas;
import com.adsosena.egloapps.services.ProductoService;
import com.adsosena.egloapps.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BusquedaController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UsuarioServiceImpl usuarioService;


    @GetMapping("/buscar-producto")
    public String busquedaProductos(@RequestParam("busqueda") String busqueda, Model model){
        UsuarioConverter usuarioConverter = new UsuarioConverter();

        model.addAttribute("productos", productoService.buscarProductos(busqueda));
        model.addAttribute("busqueda",busqueda);
        model.addAttribute("usuarioActual",usuarioConverter.usuarioToUsuarioModel(usuarioService.getUsuarioActual()));
        model.addAttribute("cantidad",1);
        return ConstantesVistas.BUSQUEDA_VISTA;
    }
}
