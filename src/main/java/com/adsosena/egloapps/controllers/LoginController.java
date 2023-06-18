package com.adsosena.egloapps.controllers;

import com.adsosena.egloapps.constants.ConstantesVistas;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String mostrarLogin(@AuthenticationPrincipal UserDetails userDetails){

        if(userDetails == null){
            return ConstantesVistas.LOGIN_VISTA;
        } else {
            return "redirect:/";
        }
    }

}
