package com.adsosena.egloapps.controllers;

import com.adsosena.egloapps.constants.ConstantesVistas;
import com.adsosena.egloapps.entities.Rol;
import com.adsosena.egloapps.models.UsuarioModel;
import com.adsosena.egloapps.services.impl.RegistroServiceImpl;
import com.adsosena.egloapps.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private RegistroServiceImpl registroService;

    @GetMapping("/usuarios")
    public String mostrarUsuarios(@RequestParam(name = "true", required = false) String guardado,
                                  @RequestParam(name = "false", required = false) String noGuardado,
                                  Model model){

        model.addAttribute("noGuardado", noGuardado);
        model.addAttribute("guardado", guardado);
        model.addAttribute("user",Rol.USER);
        model.addAttribute("admin",Rol.ADMIN);
        model.addAttribute("usuario", new UsuarioModel());
        model.addAttribute("fullName", usuarioService.getUsuarioActual().getNombreCompleto());
        model.addAttribute("listaUsuario", usuarioService.listarUsuarios());

        return ConstantesVistas.USUARIOS_VISTA;
    }

    @PostMapping("/usuarios/agregar-usuario")
    public String agregarUsuario(@ModelAttribute UsuarioModel usuarioModel){
        try {
            if(usuarioModel != null){
                registroService.agregarUsuario(usuarioModel);
                return "redirect:/usuarios?true";
            }
        } catch (Exception exception){
            return "redirect:/usuarios?false";
        }
        return "usuarios";
    }
    @PostMapping ("/usuarios/eliminar")
    public String eliminarUsuario(@RequestParam(name = "id") String id){

       registroService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

    @PostMapping("/usuarios/editar-usuario")
    public String editarUsuario(@ModelAttribute UsuarioModel usuarioModel) {
        try {
            if (usuarioModel != null) {
                registroService.editarUsuario(usuarioModel);
                return "redirect:/usuarios?true";
            }
        } catch (Exception exception) {
            return "redirect:/usuarios?false";
        }
        return "usuarios";
    }
}
