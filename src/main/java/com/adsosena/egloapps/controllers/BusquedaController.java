package com.adsosena.egloapps.controllers;


import com.adsosena.egloapps.constants.ConstantesVistas;
import com.adsosena.egloapps.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BusquedaController {

    @Autowired
    private ProductoService productoService;


    @PostMapping("/buscar-producto")
    public String busquedaProductos(@RequestParam(name = "busqueda") String busqueda, Model model){
        System.out.println(busqueda);
        model.addAttribute("productos", productoService.buscarProductos(busqueda));
        return ConstantesVistas.BUSQUEDA_VISTA;
    }
}
