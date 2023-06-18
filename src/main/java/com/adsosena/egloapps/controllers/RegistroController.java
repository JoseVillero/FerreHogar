package com.adsosena.egloapps.controllers;

import com.adsosena.egloapps.constants.ConstantesVistas;

import com.adsosena.egloapps.models.UsuarioModel;
import com.adsosena.egloapps.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class RegistroController {

    @Autowired
    RegistroService registroService;

    @GetMapping("/registro")
    public String mostrarRegistro(@RequestParam(name = "true", required = false) String existe, @RequestParam(name = "false", required = false) String noExiste, Model model){

        model.addAttribute("usuario",new UsuarioModel());
        model.addAttribute("existe", existe);
        model.addAttribute("noExiste",noExiste);
        return ConstantesVistas.REGISTRO_VISTA;
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute UsuarioModel usuarioModel){

        if(registroService.consultarUsuarioPorId(usuarioModel)){
            return "redirect:/registro?true";
        }
        else {
            registroService.registrarUsuario(usuarioModel);
            return "redirect:/registro?false";
        }
    }
}
