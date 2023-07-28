package com.adsosena.egloapps.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@Setter
public class CarritoModel {

    private UsuarioModel usuarioModel;

    private List<PedidoModel> listaPedidos;

    public CarritoModel() {
        this.listaPedidos = new ArrayList<>();
    }

}
