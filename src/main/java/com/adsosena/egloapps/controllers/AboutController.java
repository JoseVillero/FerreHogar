package com.adsosena.egloapps.controllers;

import com.adsosena.egloapps.constants.ConstantesVistas;
import com.adsosena.egloapps.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping("/about")
    public String mostrarQuienesSomos(Model model){

        model.addAttribute("fullName",usuarioService.getUsuarioActual().getNombreCompleto());
        return ConstantesVistas.QUIENES_SOMOS_VISTA;
    }
}
