package com.adsosena.egloapps.controllers;


import com.adsosena.egloapps.constants.ConstantesVistas;
import com.adsosena.egloapps.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**Clase CatalogoController: Esta clase es un controlador que maneja los endpoint o rutas
 * relacionadas con la vista catalogo
 * @author Jose David */
@Controller
public class CatalogoController {

    @Autowired
    ProductoService productoService;

    /**Metodo mostrarCatalgo: controla la peticion al recurso /catologo. Llama al servicio y le solicita listar
     * los prductos
     * @param model de tipo Model, spring se encarga de inyectar el atributo
     * @return String - retorna la vista catalogo*/
    @GetMapping("/catalogo")
    public String mostrarCatalgo(Model model){
        model.addAttribute("productos",productoService.listarProductos());
        return ConstantesVistas.CATALOGO_VISTA;
    }

}
