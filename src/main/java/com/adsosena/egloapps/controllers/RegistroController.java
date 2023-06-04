package com.adsosena.egloapps.controllers;

import com.adsosena.egloapps.constants.ConstantesVistas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegistroController {

    @GetMapping("/registro")
    public String mostrarRegistro(){
        return ConstantesVistas.REGISTRO_VISTA;
    }
}
