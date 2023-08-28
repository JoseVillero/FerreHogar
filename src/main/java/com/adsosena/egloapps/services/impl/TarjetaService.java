package com.adsosena.egloapps.services.impl;
import com.adsosena.egloapps.components.converters.TransaccionConverter;
import com.adsosena.egloapps.entities.Pedido;
import com.adsosena.egloapps.entities.Transaccion;
import com.adsosena.egloapps.entities.Usuario;
import com.adsosena.egloapps.models.TarjetaCredito;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class TarjetaService {

    @Autowired
    private CarritoServiceImpl carritoService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private ProductoServiceImpl productoService;

    private TarjetaCredito buscarTarjeta(TarjetaCredito tarjetaCredito) {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/static/js/tarjetasCreditoListado.json");

        try {
            // Lee el archivo JSON
            List<TarjetaCredito> tarjetasList = objectMapper.readValue(
                    inputStream,
                    new TypeReference<List<TarjetaCredito>>() {}
            );
            for (TarjetaCredito tc : tarjetasList){
                if (tarjetaMatches(tarjetaCredito,tc)){
                    return tc;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean tarjetaMatches(TarjetaCredito tarjetaCredito, TarjetaCredito tarjeta) {
        return tarjeta.getFranquicia().equals(tarjetaCredito.getFranquicia()) &&
                tarjeta.getNumero().equals(tarjetaCredito.getNumero()) &&
                tarjeta.getNombreCompleto().equals(tarjetaCredito.getNombreCompleto()) &&
                tarjeta.getDireccion().equals(tarjetaCredito.getDireccion()) &&
                tarjeta.getPais().equals(tarjetaCredito.getPais()) &&
                tarjeta.getCVV() == tarjetaCredito.getCVV() &&
                tarjeta.getExpiracion().equals(tarjetaCredito.getExpiracion());
    }

    public List<Pedido> realizarPago(TarjetaCredito tarjetaCredito){

        Usuario usuario = usuarioService.getUsuarioActual();
        List<Pedido> pedidosComprados = new ArrayList<>();
        List<Pedido> pedidoList = carritoService.listarPedidos();
        TarjetaCredito tc = buscarTarjeta(tarjetaCredito);  // envolver en un try - catch
        double totalAPagar = totalAPagar(pedidoList);
        TransaccionConverter transaccionConverter = new TransaccionConverter();

        if (tc != null && tc.getMonto() >= totalAPagar ){
            for (Pedido pedido: pedidoList){
                if (pedido.getCantidad() <= pedido.getProducto().getCantidadDisponible()){
                    productoService.restarCantidadProducto(pedido.getProducto().getId(), pedido.getCantidad());
                    Transaccion transaccion = transaccionConverter.transaccionVenderProducto
                            (pedido.getProducto(), usuario, pedido.getCantidad(), tc);
                    pedido.getProducto().getTransacciones().add(transaccion);
                    productoService.actualizarProducto(pedido.getProducto());
                    pedidosComprados.add(pedido);
                }
            }
            usuario.getCarrito().getListaPedidos().clear();
            usuarioService.actualizaUsuario(usuario);
        }
        return pedidosComprados;
    }

    private double totalAPagar(List<Pedido> pedidoList){
        double total = 0;
        for(Pedido pedido: pedidoList){
            total += pedido.getCantidad() * pedido.getProducto().getPrecio();
        }
        return total;
    }

}
