package com.adsosena.egloapps.controllers;


import com.adsosena.egloapps.constants.ConstantesVistas;
import com.adsosena.egloapps.models.ProductoModel;
import com.adsosena.egloapps.services.ImagenService;
import com.adsosena.egloapps.services.ProductoService;
import com.adsosena.egloapps.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**Clase CatalogoController: Esta clase es un controlador que maneja los endpoint o rutas
 * relacionadas con la vista catálogo
 * @author Jose David */
@Controller
public class CatalogoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private ImagenService imagenService;


    /**Metodo mostrarCatalgo: controla la peticion al recurso /catologo. Llama al servicio y le solicita listar
     * los prductos
     * @param model de tipo Model, spring se encarga de inyectar el atributo
     * @return String - retorna la vista catalogo*/
    @GetMapping("/catalogo")
    public String mostrarCatalgo(@RequestParam(name = "true", required = false) String guardado,
                                 @RequestParam(name = "false", required = false) String noGuardado,
                                 Model model){

        model.addAttribute("noGuardado", noGuardado);
        model.addAttribute("guardado", guardado);
        model.addAttribute("productoModel", new ProductoModel());
        model.addAttribute("productos",productoService.listarProductos());
        model.addAttribute("fullName", usuarioService.getUsuarioActual().getNombreCompleto());
        model.addAttribute("busqueda", "");
        return ConstantesVistas.CATALOGO_VISTA;
    }

    @PostMapping("/catalogo/agregar-producto")
    public String agregarProducto(@ModelAttribute ProductoModel productoModel, @RequestParam(name = "imagenFile") MultipartFile imagen){
        try {
            if (productoModel != null && imagen != null){
                String imagenUrl = imagenService.guardarImagen(imagen);
                if(!imagenUrl.isBlank()){
                    productoModel.setImagen(imagenUrl);
                    productoService.agregarProducto(productoModel);
                }
                return "redirect:/catalogo?true";
            }
        } catch (Exception exception){
            exception.printStackTrace();

            return "redirect:/catalogo?false";
        }
        return "redirect:/catalogo";
    }
    @PostMapping("/catalogo/actualizar-producto")
    public String actualizarProducto(@ModelAttribute ProductoModel productoModel){
        if (productoModel != null){
            productoService.actualizarProducto(productoModel);
            return "redirect:/catalogo?true";
        }
        return "redirect:/catalogo?false";
    }
    @PostMapping("/catalogo/eliminar-producto")
    public String eliminarProducto(@RequestParam(name = "id") int id){

        productoService.eliminarProducto(id);
        return "redirect:/catalogo";
    }
}
