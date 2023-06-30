package com.adsosena.egloapps.controllers;

import com.adsosena.egloapps.constants.ConstantesVistas;
import com.adsosena.egloapps.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InicioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping("/")
    public String mostrarInicio(Model model){

        model.addAttribute("fullName",usuarioService.getFullName());

        return ConstantesVistas.INDEX_VISTA;
    }


}
