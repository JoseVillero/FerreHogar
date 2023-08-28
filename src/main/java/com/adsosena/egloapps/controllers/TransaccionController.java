package com.adsosena.egloapps.controllers;

import com.adsosena.egloapps.constants.ConstantesVistas;
import com.adsosena.egloapps.entities.Pedido;
import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.models.FranquiciaTC;
import com.adsosena.egloapps.models.TarjetaCredito;
import com.adsosena.egloapps.services.impl.CarritoServiceImpl;
import com.adsosena.egloapps.services.impl.TarjetaService;
import com.adsosena.egloapps.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Controller
public class TransaccionController {

    @Autowired
    CarritoServiceImpl carritoService;

    @Autowired
    TarjetaService tarjetaService;

    @Autowired
    UsuarioServiceImpl usuarioService;


    @GetMapping("/transaccion")
    public String PaginaTransaccion(Model model){
        if (carritoService.validarPedidos().isEmpty()){
            model.addAttribute("tarjetaCredito", new TarjetaCredito());
            model.addAttribute("franquiciaTC", FranquiciaTC.AMERICAN_EXPRESS);

            return ConstantesVistas.TRANSACCION_VISTA;
        }
        return "redirect:/carrito?err";
    }

    @PostMapping("/pagar")
    public String realizarPago(@ModelAttribute TarjetaCredito tarjetaCredito, @RequestParam("franquicia") String franquicia,
                             @RequestParam("mes") int mes, @RequestParam("year") int year,
                               @RequestParam("opcion") String opcion,
                               @RequestParam(value = "domicilio", required = false)String direccion, Model model) {

        String fechaExpiracion = String.valueOf(mes) + "/" + String.valueOf(year);
        tarjetaCredito.setExpiracion(fechaExpiracion);
        tarjetaCredito.setFranquicia(FranquiciaTC.valueOf(franquicia));
        List<Pedido> compra = tarjetaService.realizarPago(tarjetaCredito);
        model.addAttribute("productosComprados", compra);
        if ("tienda".equals(opcion)) {
            model.addAttribute("opcion", "RECOGER EN TIENDA");
        } else if ("domicilio".equals(opcion)) {
            model.addAttribute("opcion", direccion);
        }

        return mostrarFactura(model);
    }

    @GetMapping("/factura")
    public String mostrarFactura(Model model){

        List<Pedido> compra = (List<Pedido>) model.getAttribute("productosComprados");
        String tipoDeEnvio = (String) model.getAttribute("opcion");
        DateFormat dateFormat = new SimpleDateFormat("d/MMM/yyyy");
        String date = dateFormat.format(new Date());
        Usuario usuario = usuarioService.getUsuarioActual();

        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000; // G

        model.addAttribute("listaProductosComprados", compra);
        model.addAttribute("usuario", usuario);
        model.addAttribute("fecha", date.toUpperCase());
        model.addAttribute("tipoEnvio", tipoDeEnvio);
        model.addAttribute("numeroFactura", randomNumber);
        model.addAttribute("totalAPagar", totalAPagar(compra));

        return ConstantesVistas.FACTURA_VISTA;
    }

    private double totalAPagar(List<Pedido> pedidoList){
        double total = 0;
        for(Pedido pedido: pedidoList){
            total += pedido.getCantidad() * pedido.getProducto().getPrecio();
        }
        return total;
    }
}
