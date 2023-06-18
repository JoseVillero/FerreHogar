package com.adsosena.egloapps.controllers;


import com.adsosena.egloapps.constants.ConstantesVistas;
import com.adsosena.egloapps.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CatalogoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/catalogo")
    public String mostrarCatalgo(Model model){
        model.addAttribute("productos",productoService.listarProductos());
        return ConstantesVistas.CATALOGO_VISTA;
    }

}
