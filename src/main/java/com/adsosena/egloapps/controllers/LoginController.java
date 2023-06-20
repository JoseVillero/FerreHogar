package com.adsosena.egloapps.controllers;

import com.adsosena.egloapps.constants.ConstantesVistas;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**Clase LoginController: Esta clase es un controlador que maneja los endpoint o rutas
 * relacionadas con la vista login
 * @author Jose David */
@Controller
public class LoginController {

    /**Metodo mostrarLogin: controla la peticion al recurso /login. Si el usuario no es autenticado vuelve y redireccina
     * a la vista login
     * @param userDetails de tipo UserDetail, spring se encarga de inyectar el atributo
     * @return String - retorna la vista login o index si userDetails no es nulo*/
    @GetMapping("/login")
    public String mostrarLogin(@AuthenticationPrincipal UserDetails userDetails){

        if(userDetails == null){
            return ConstantesVistas.LOGIN_VISTA;
        } else {
            return "redirect:/";
        }
    }
}
