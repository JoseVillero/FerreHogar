package com.adsosena.egloapps.controllers;

import com.adsosena.egloapps.constants.ConstantesVistas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping("/login")
    public String mostarLogin(){
        return ConstantesVistas.LOGIN_VISTA;
    }

}
