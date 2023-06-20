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


/**Clase RegistroController: Esta clase es un controlador que maneja los endpoint o rutas
 * relacionadas con la vista registro
 * @author Jose David */
@Controller
public class RegistroController {

    @Autowired
    RegistroService registroService;

    /**Metodo mostrarRegistro: controla la peticion al recurso /registro. El metodo puede recibir tres parametros.
     * Dos de los parametros son parametros http opcionales.
     * @param existe parametro opcional enviado si el usuario a registrar ya existe en la base de datos
     * @param noExiste parametro opcional enviado si el usuario a registrar no existe en la base de datos
     * @param model de tipo Model, spring se encarga de inyectar el atributo
     * @return String - retorna la vista registro*/
    @GetMapping("/registro")
    public String mostrarRegistro(@RequestParam(name = "true", required = false) String existe, @RequestParam(name = "false", required = false) String noExiste, Model model){

        model.addAttribute("usuario",new UsuarioModel());
        model.addAttribute("existe", existe);
        model.addAttribute("noExiste",noExiste);
        return ConstantesVistas.REGISTRO_VISTA;
    }

    /**Metodo registrarUsuario: controla la peticion  /registrar. Este metodo controla la peticion post enviada por
     * el formulario de inscripcion. El metodo llama al servicio para verificar si el usuario ya exisite. Si existe,
     * envia un parametro llamado 'true' al recurso /registro. Si el usuario no existe, el metodo intenta guardar
     * el usuario brindado por el formulario. Si lo guarda correctamente envia un parametro llamado 'false' al recurso
     * /registro.
     * @param usuarioModel de tipo UsuarioModel, spring se encarga de inyectar el atributo
     * @return String - retorna la vista registro con los parametros opcionales true o false*/
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
